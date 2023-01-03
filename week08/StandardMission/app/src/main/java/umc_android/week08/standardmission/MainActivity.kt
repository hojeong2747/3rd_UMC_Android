package umc_android.week08.standardmission

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import umc_android.week08.standardmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewbinding: ActivityMainBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>

    private val memoList: ArrayList<Memo> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)

        // room
        val roomDb = AppDatabase.getInstance(this)
        // 중요한 작업임
        if (roomDb != null) {
            val getMemo = roomDb.memoDao().selectAll()
            memoList.addAll(getMemo)
        }

        // delete
        val memoRVAdapter = MemoRVAdapter(memoList, onClickDeleteBtn = {
            roomDb?.memoDao()?.delete(it)
            deleteTask(it)
        })

        getResultText =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    if (roomDb != null) {
                        val content = result.data?.getStringExtra("data") ?: ""
                        Log.d(TAG, "onCreate: $content")

                        // insert
                        val memo = Memo(content,)
                        roomDb.memoDao().insert(memo)

                        memoList.apply {
                            add(Memo("$content"))
                        }
                        memoRVAdapter.notifyItemRangeInserted(
                            memoList.size,
                            1
                        )
                    }
                }
            }
        viewbinding.btnAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, MemoActivity::class.java)
            getResultText.launch(intent)
        }
        viewbinding.rvData.adapter = memoRVAdapter  // 리사이클러뷰에 어댑터 연결
        viewbinding.rvData.layoutManager = LinearLayoutManager(this) // 레이아웃 매니저 연결
    }

    fun deleteTask(data: Memo) {
        memoList.remove(data)
        viewbinding.rvData.adapter?.notifyDataSetChanged()
    }
}