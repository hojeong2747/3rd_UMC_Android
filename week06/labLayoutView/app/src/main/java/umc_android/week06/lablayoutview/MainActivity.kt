package umc_android.week06.lablayoutview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import umc_android.week06.lablayoutview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // 실습 1
        // 처음 실행했을 때 HomeFragment가 나오도록 설정
        // 기본적으로 add 말고 replace 씀
        // viewBinding으로 container id 가져올 수 있다. framelayout(fragment 담을 container)
        // HomeFragment로 띄우고 싶음. 객체라 () 써야함
//        supportFragmentManager
//            .beginTransaction()
//            .replace(viewBinding.containerFragment.id, HomeFragment())
//            .commitAllowingStateLoss()
//
        // run을 쓰면, bottomnavigation과 관련된 코드를 바로 적을 수 있다. 범위함수.
//        viewBinding.navBottom.run {
//            setOnItemSelectedListener {
//                // 어떤 item이 눌렸는지 들어옴. id로 구분
//                when (it.itemId) {
//                    R.id.menu_home -> {
//                        // 누르면 HomeFragment로 교체
//                        supportFragmentManager
//                            .beginTransaction()
//                            .replace(viewBinding.containerFragment.id, HomeFragment())
//                            .commitAllowingStateLoss()
//                    }
//                    R.id.menu_setting -> {
//                        // 누르면 SettingFragment로 교체
//                        supportFragmentManager
//                            .beginTransaction()
//                            .replace(viewBinding.containerFragment.id, SettingFragment())
//                            .commitAllowingStateLoss()
//                    }
//                }
//                true // 반환. 개발자가 실수하지 않는 한 true. 이거 사실 이벤트 처리 끝이라는 거.
//            }

            // 초기 설정한 것을 bottomnavi에 알려줌
            // 함수인데, 변수처럼 쓰도록 함.
            // 여기에 menuItem 중 id를 설정해놓으면, 현재 선택한 item을 bottomnavi에 알려줄 수 있다.
            // 선택할 때마다 하는 게 아니라 listener 안쪽이 아니라 run 안쪽이다. 그래서 처음 딱 한 번 실행한다.
            // 이렇게 하면 첨 실행했을 때 R.id.menu_home item을 가리킨다.
//           selectedItemId = R.id.menu_home
        //        }

        // 실습 2
        val mainVPAdapter = MainVPAdapter(this)
        viewBinding.vpMain.adapter = mainVPAdapter

        // tab 제목 배열 생성
        // 내용에 따라 배열 타입 설정됨
        val tabTitleArray = arrayOf(
            "One",
            "Two"
        )

        // 람다 함수 파라미터 느낌의 tab, position
        // tab은 tablayout에서 직접 받은 tab이고, position은 tab의 위치
        // 이렇게 하면 위에 있는 viewpager에 따라서 tablayout도 같이 움직임
        TabLayoutMediator(viewBinding.tabMain, viewBinding.vpMain) {tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

    }
}