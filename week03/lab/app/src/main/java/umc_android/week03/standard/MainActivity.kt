package umc_android.week03.standard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import umc_android.week03.standard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // viewBinding 객체 생성. 값은 나중에 할당하겠다. -> onCreate에서 해줌.
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // xml 파일 읽어서 해석하려면 필요한 inflater는 기본 제공 됨.
        // root는 xml 파일의 맨 상단 태그를 의미함. 루트에 포함된 하위 내용 알아서 다 불러와짐.
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

//        viewBinding.tvText.text = "안뇽"

//        viewBinding.btnNext.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
//            // intent에 값을 담아 보냄
//            intent.putExtra("text", "first string")
//            startActivity(intent)
//        }

        // 기본으로 표시되는 fragment가 있어야 함. 기본 화면 표시 먼저 하는 것이 fragment 설정 하는 것이다.
        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.frameFragment.id, FirstFragment())
            .commitAllowingStateLoss()

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