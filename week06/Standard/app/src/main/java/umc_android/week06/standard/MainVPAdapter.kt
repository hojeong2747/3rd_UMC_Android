package umc_android.week06.standard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainVPAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    // 총 아이템의 개수
    override fun getItemCount(): Int = 3

    // position에 따라서 어떤 fragment를 보여줄지 설정
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OneFragment()
            1 -> TwoFragment()
            2 -> ThreeFragment()
            else -> OneFragment()
            // 에러 때문에 else도 처리. 그냥 씀.
        }
    }
}