package umc_android.week06.lablayoutview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

// AppCompatActivity가 FragmentStateAdapter를 상속받고 있다. 그냥 activity를 넣는다고 생각. 인자를 넣어야 함
// 어떤 activity에서 넘어오는지? MainVPAdapter 객체를 생성할 때 activity 정보를 넘겨줘야 함.
class MainVPAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    // 만약 fragment 속에서 viewpager를 사용하는 경우도 있는데 이때는 fragment에서 adapter객체 생성 시 getActivity 등으로 처리

    // 총 아이템의 개수
    override fun getItemCount(): Int = 2

    // position에 따라서 어떤 fragment를 보여줄지 설정
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OneFragment()
            1 -> TwoFragment()
            else -> OneFragment()
            // 에러 때문에 else도 처리. 그냥 씀.
        }
    }


}