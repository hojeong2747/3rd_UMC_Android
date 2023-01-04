package umc_android.week03.standard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import umc_android.week03.standard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() { // MainActivity 는 AppCompatActivity 를 상속받음.
    // viewBinding 객체 생성. lateinit은 값은 나중에 할당하겠다. -> onCreate에서 할당
    // 나중에 초기화 하겠다는 것이고, 이거 안 하고 setContentView에 넣으면 오류남
    private lateinit var viewBinding: ActivityMainBinding // viewBinding 변수의 타입은 ActivityMainBinding (해당 layout의 view만 가져올 수 있음)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // xml 파일 읽어서 해석하려면 필요한 inflater는 기본 제공 됨.
        // root는 xml 파일의 맨 상단 태그를 의미함. 루트에 포함된 하위 내용 알아서 다 불러와짐.
        viewBinding = ActivityMainBinding.inflate(layoutInflater) // layout 파일 객체로 변환해주고, ActivityMainBinding 객체 생성해줌
        setContentView(viewBinding.root)

//        viewBinding.tvText.text = "안뇽"

//        viewBinding.btnNext.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
//            // intent에 값을 담아 보냄
//            intent.putExtra("text", "first string")
//            startActivity(intent)
//        }

        // 기본으로 표시되는 fragment 가 있어야 함. 기본 화면 표시 먼저 하는 것이 fragment 설정 하는 것이다.
        // FragmentManager 는 fragment 를 표시하는 데에 씀. 
        // support 는 일반은 아니고, 구버전과 호환되도록 해주는 것
        supportFragmentManager
            .beginTransaction() // 어떤 fragment 로 변경하겠다는 표식
            .replace(viewBinding.frameFragment.id, FirstFragment()) // replace() 에 xml(container id), class 적어줌
            .commitAllowingStateLoss() // state 가 loss 되어도 변경 사항 적용하겠다는 뜻

        // btn 이벤트 추가
        viewBinding.btnFragment1.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameFragment.id, FirstFragment())
                .commitAllowingStateLoss()
        }
        viewBinding.btnFragment2.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameFragment.id, SecondFragment())
                .commitAllowingStateLoss()
        }
    }
}