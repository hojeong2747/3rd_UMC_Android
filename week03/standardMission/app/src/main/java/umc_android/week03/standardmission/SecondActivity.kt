package umc_android.week03.standardmission

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import umc_android.week03.standardmission.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val extras = intent.extras // activity, fragment 를 오가는 데이터를 extras 객체로 쓸 수 있음
        val data = extras!!["text"] as String // !! : extras 는 반드시 null 이 아니라는 표시
        Log.d(TAG, data)
        viewBinding.tvOutput.text = data

        viewBinding.btnNext2.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}