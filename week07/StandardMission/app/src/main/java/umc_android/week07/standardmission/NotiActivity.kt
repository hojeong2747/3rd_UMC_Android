package umc_android.week07.standardmission

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import umc_android.week07.standardmission.databinding.ActivityNotiBinding

class NotiActivity : AppCompatActivity()  {
    private lateinit var binding: ActivityNotiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNoti.setOnClickListener {
            finish()
        }

    }
}