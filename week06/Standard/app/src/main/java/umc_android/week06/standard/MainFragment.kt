package umc_android.week06.standard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import umc_android.week06.standard.databinding.FragmentMainBinding
import umc_android.week06.standard.databinding.FragmentOneBinding

class MainFragment: Fragment() {
    private lateinit var viewBinding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentMainBinding.inflate(layoutInflater)

        // 실습 2
        val mainVPAdapter = MainVPAdapter(requireActivity())
        viewBinding.vpMain.adapter = mainVPAdapter

        // tab 제목 배열 생성
        // 내용에 따라 배열 타입 설정됨
        val tabTitleArray = arrayOf(
            "One",
            "Two",
            "Three"
        )

        // tab은 tablayout에서 직접 받은 tab이고, position은 tab의 위치
        // 이렇게 하면 위에 있는 viewpager에 따라서 tablayout도 같이 움직임
        TabLayoutMediator(viewBinding.tabMain, viewBinding.vpMain) {tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

        return viewBinding.root
    }

}