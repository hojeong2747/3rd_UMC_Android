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

        val extras = intent.extras
        val data = extras!!["text"] as String
        Log.d(TAG, data)
        viewBinding.tvOutput.text = data

        viewBinding.btnNext2.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}