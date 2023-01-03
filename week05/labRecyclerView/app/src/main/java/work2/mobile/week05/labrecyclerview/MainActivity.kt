package work2.mobile.week05.labrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import work2.mobile.week05.labrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // adapter에서 사용할 데이터 list를 dataList에 넣고
        // adapter 객체 생성
        val dataList: ArrayList<Data> = arrayListOf()
        // data를 채운다.
        dataList.apply {
            add(Data("hello", "1"))
            add(Data("hello", "2"))
            add(Data("hello", "3"))
            add(Data("hello", "4"))
            add(Data("hello", "5"))
            add(Data("hello", "6"))
            add(Data("hello", "7"))
            add(Data("hello", "8"))
            add(Data("hello", "9"))
            add(Data("hello", "10"))
        }
        val dataRVAdapter = DataRVAdapter(dataList)

        // adapter 객체를 xml에 적었던 recyclerView와 연결
        viewBinding.rvData.adapter = dataRVAdapter
        // recyclerView의 필수 = layoutManager
        viewBinding.rvData.layoutManager = LinearLayoutManager(this)

        // data 추가 시 recyclerView에게 알려야 보인다.
        // 1초 후에 데이터 추가.
        Handler(mainLooper).postDelayed({
            dataList.apply {
                add(Data("hello", "11"))
                add(Data("hello", "12"))
                add(Data("hello", "13"))
                add(Data("hello", "14"))
            }
//            dataRVAdapter.notifyDataSetChanged()
            // 이게 편하긴 한데, recyclerView의 item 전체를 새로 가져온다. 그래서 전체 새로고침 아니면 노노.
            dataRVAdapter.notifyItemRangeInserted(10, 4)
            // 10개 넣었었고, 4개 추가
            // 용도에 따라 notify를 해줘야 효율적인 앱을 만들 수 있다.
        }, 5000)

    }
}