package umc_android.week07.labthread

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import umc_android.week07.labthread.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("LifeCycle", "onCreate");

//        val imageList: ArrayList<Int> = arrayListOf(
//            R.drawable.cat,
//            R.drawable.dog,
//            R.drawable.tiger,
//            R.drawable.rabbit
//        )
        val imageList: ArrayList<Int> = arrayListOf(
            R.drawable.cat,
            R.drawable.rabbit
        )
        var imgIndex = 0

        val handler = Handler(mainLooper)

        Thread() {
            while(true) {
                if (imgIndex == imageList.size -1) {
                    imgIndex = 0
                } else {
                    imgIndex++
                }

                handler.post {
                    binding.imgMain.setImageResource(imageList[imgIndex])
                }

                Thread.sleep(2000)
            }
        }.start()
    }
}