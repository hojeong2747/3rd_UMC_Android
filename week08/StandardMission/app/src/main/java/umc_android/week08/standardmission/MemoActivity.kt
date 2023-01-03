package umc_android.week08.standardmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import umc_android.week08.standardmission.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.button.setOnClickListener {
            val mIntent = Intent(this, MainActivity::class.java).apply {
                putExtra("data", viewBinding.etInput.text.toString())
            }
            setResult(RESULT_OK, mIntent)
            if(!isFinishing) finish()
        }
    }
}