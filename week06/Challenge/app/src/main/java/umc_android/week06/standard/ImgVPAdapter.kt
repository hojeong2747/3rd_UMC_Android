package umc_android.week06.standard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.viewpager2.adapter.FragmentStateAdapter
import umc_android.week06.standard.databinding.FragmentImgBinding

class ImgVPAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

//    inner class ImageViewHolder(val binding : FragmentImgBinding) : RecyclerView.ViewHolder(binding) {
//        fun bind(data : Int) {
//            binding.vpImg.setImageResource(data)
//        }
//    }

    // 총 아이템의 개수
    override fun getItemCount(): Int = 3

    // position에 따라서 어떤 fragment를 보여줄지 설정
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ImgOneFragment()
            1 -> ImgTwoFragment()
            2 -> ImgThreeFragment()
            else -> ImgOneFragment()
            // 에러 때문에 else도 처리. 그냥 씀.
        }
    }
}