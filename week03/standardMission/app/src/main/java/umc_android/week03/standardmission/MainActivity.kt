package umc_android.week03.standardmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import umc_android.week03.standardmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

//        val etInput = viewBinding.etInput.text.toString() -> 위치 주의.

        viewBinding.btnNext.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val etInput = viewBinding.etInput.text.toString()
            intent.putExtra("text", etInput)
            startActivity(intent)
        }
    }
}