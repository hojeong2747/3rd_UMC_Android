package umc_android.week03.standard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import umc_android.week03.standard.databinding.ActivityMainBinding
import umc_android.week03.standard.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // intent에 보낸 값 받아옴
        val extras = intent.extras
        // text라는 key에 값이 없을 수도 있음 -> null 방지.
        // !!는 무조건 값이 넘어온다고 개발자가 적어주는 것 -> 웬만하면 사용 x
        // 어떤 타입의 값인지 적어줘야 하는데 무조건 string으로 넘어온다고 개발자가 적어줌 -> 이것도 웬만하면 사용 x
        val data = extras!!["text"] as String

        // 받아온 값으로 텍뷰 수정
        viewBinding.tvSecondtext.text = data
    }
}