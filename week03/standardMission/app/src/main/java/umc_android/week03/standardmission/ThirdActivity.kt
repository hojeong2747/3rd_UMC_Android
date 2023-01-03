package umc_android.week03.standardmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import umc_android.week03.standardmission.databinding.ActivitySecondBinding
import umc_android.week03.standardmission.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // 기본으로 표시되는 fragment
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