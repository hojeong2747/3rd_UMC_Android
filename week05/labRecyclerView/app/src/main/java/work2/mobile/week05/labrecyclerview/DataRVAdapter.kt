package work2.mobile.week05.labrecyclerview

import android.util.SparseArray
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import work2.mobile.week05.labrecyclerview.databinding.ItemDataBinding

// <> 속에 viewHolder 객체를 넣어줌, 그리고 alt enter로 필수 재정의 함수 가져옴
class DataRVAdapter(private val dataList: ArrayList<Data>): RecyclerView.Adapter<DataRVAdapter.DataViewHolder>() {

    // standard mission - 스위치 문제 해결
    // SparseBooleanArray() : 정수 값들을 boolean 값들로 매핑시키는 기능을 하는 클래스
    private val checkboxStatus = SparseBooleanArray()

    // 아이템이 담긴 list 생성 (방법 여러 개)
//    private val dataList: ArrayList<Data> = arrayListOf()
    // 이렇게 써도 되는데 이렇게 하면, 이 adapter 속에 들어있는 데이터 list를 수정하기 위한 구현을 해야 한다. add 함수로 별도 구현
    // 그래서 변수 선언을 adapter 자체 입력 값으로(인자로) 넣어준다.
    // 지금은 adapter의 설계도를 만든 것이고, 이 클래스 객체를 메인 액티비티에 만들 건데 인자 값을 같이 넣어서 생성하게 한다.
    // 그럼 메인에서 데이터 list가 수정되면, 이 adapter에서도 바로 데이터 list가 수정된다. 한 데이터 list를 공유한다.
    
    // ViewHolder 객체
    // 클래스 안에 클래스 정의
    // ViewBinding 정보 받을 수 있게 작성(layout의 binding 객체를 가져오면 됨)(oncreateViewHolder에서 viewBinding을 설정)
    inner class DataViewHolder(private val viewBinding: ItemDataBinding): RecyclerView.ViewHolder(viewBinding.root) {

        // 실제 view를 만들 때 호출되는 함수 -> view 만들어줌
        fun bind(data: Data) {
            // viewBinding의 view에 data를 채워넣어야 하므로 매개변수로 data를 넣어야 함
            viewBinding.tvTitle.text = data.title;
            viewBinding.tvDesc.text = data.desc;

            viewBinding.swcData.isChecked = checkboxStatus[adapterPosition]
            viewBinding.swcData.setOnClickListener {
                if (!viewBinding.swcData.isChecked)
                    checkboxStatus.put(adapterPosition, false)
                else
                    checkboxStatus.put(adapterPosition, true)
                notifyItemChanged(adapterPosition)
            }
        }
    }

    // ViewHolder 만들어질 때 실행할 동작 (xml)
    // parent는 이 viewHolder가 담길 부모 layout이나 view (listView일 가능성 높음)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        // 실제 viewHolder에 xml을 넣는 것
        // 부모의 context로 layout을 설정함. adapter에서는 바로 xml을 가져올 수 없어서.
        // attachToParent는 일반적으로 false라고 쓰면 됨
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }
    
    // ViewHolder가 실제로 데이터를 표시해야 할 때 호출되는 함수
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    // 표현할 item의 총 개수
    override fun getItemCount(): Int = dataList.size
}