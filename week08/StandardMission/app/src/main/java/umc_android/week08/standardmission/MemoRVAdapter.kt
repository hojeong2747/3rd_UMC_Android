package umc_android.week08.standardmission

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import umc_android.week08.standardmission.databinding.ItemDataBinding

class MemoRVAdapter( private val memoList: ArrayList<Memo>, val onClickDeleteBtn: (data: Memo) -> Unit) :
    RecyclerView.Adapter<MemoRVAdapter.DataViewHolder>() {
    // ViewHolder 객체
    inner class DataViewHolder(val binding: ItemDataBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Memo) {
            binding.tvMemo.text = data.memo;
        }
    }

    // ViewHolder 만들어질 때 실행할 동작
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    // ViewHolder 가 실제로 데이터를 표시해야 할 때 호출되는 함수
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val position = memoList[position]
        holder.bind(position)
        // deleteBtn 이 눌렸을 때 position 전달
        holder.binding.deleteBtn.setOnClickListener {
            onClickDeleteBtn.invoke(position)
        }
    }

    // 표현할 Item 의 총 개수
    override fun getItemCount(): Int = memoList.size
}