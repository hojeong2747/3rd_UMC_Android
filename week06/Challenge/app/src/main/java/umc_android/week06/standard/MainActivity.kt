package umc_android.week06.standard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import umc_android.week06.standard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.containerFragment.id, HomeFragment())
            .commitAllowingStateLoss()

        viewBinding.navBottom.run {
            setOnItemSelectedListener {
                // 어떤 item이 눌렸는지 들어옴. id로 구분
                when (it.itemId) {
                    R.id.menu_home -> {
                        // 누르면 HomeFragment로 교체
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_setting -> {
                        // 누르면 SettingFragment로 교체
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, SettingFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_main -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, MainFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_img -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, ImgFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true // 반환. 개발자가 실수하지 않는 한 true. 이거 사실 이벤트 처리 끝이라는 거.
            }

           selectedItemId = R.id.menu_home
        }

    }
}