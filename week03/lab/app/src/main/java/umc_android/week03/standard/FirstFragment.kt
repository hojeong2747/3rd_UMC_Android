package umc_android.week03.standard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import umc_android.week03.standard.databinding.FragmentFirstBinding

// fragment에서는 onCreateView
class FirstFragment: Fragment() {
    // viewBinding 동일하게 생성
    private lateinit var viewBinding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // ?에 노란색이 뜨는 이유는 여기선 무조건 view를 반환하기 때문에 필요없다.
        // ?는 기본적으로 들어가 있음 -> 지워도 됨
        viewBinding = FragmentFirstBinding.inflate(layoutInflater)

        // setcontentview가 아니라 onCreateView의 return값으로 줌 (같은 기능)
        return viewBinding.root
    }
}