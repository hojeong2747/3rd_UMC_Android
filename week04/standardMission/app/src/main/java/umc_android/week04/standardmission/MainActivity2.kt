package umc_android.week04.standardmission

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import umc_android.week04.standardmission.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        Log.d("Lifecycle2", "onCreate")

        val extras = intent.extras
        val data = extras!!["text"] as String
        Log.d(ContentValues.TAG, data)
        viewBinding.tvOutput.text = data

    }

}