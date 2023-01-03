package umc_android.week06.standard

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import umc_android.week06.standard.databinding.FragmentImgBinding
import umc_android.week06.standard.databinding.FragmentMainBinding

class ImgFragment: Fragment() {
    private lateinit var viewBinding: FragmentImgBinding
    val handler = Handler(Looper.getMainLooper()) {
        setPage()
        true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentImgBinding.inflate(layoutInflater)

        val imgVPAdapter = ImgVPAdapter(requireActivity())
        viewBinding.vpImg.apply {
            adapter = imgVPAdapter
            currentItem = 0
        }

        viewBinding.indicator.apply {

            setViewPager(viewBinding.vpImg)

            createIndicators(3, 0)
        }

        val thread = Thread(PagerRunnable())
        thread.start()

        return viewBinding.root
    }

    private fun getImageList() : ArrayList<Int> {
        return arrayListOf<Int>(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3
        )
    }

    private fun setPage() {
        if (viewBinding.vpImg.currentItem == 2) {
            viewBinding.vpImg.currentItem = 0
        } else {
            viewBinding.vpImg.currentItem++
        }
        viewBinding.vpImg.setCurrentItem(viewBinding.vpImg.currentItem, true)
    }

    inner class PagerRunnable:Runnable{
        override fun run() {
            while (true) {
                try {
                    Thread.sleep(3000)
                    handler.sendEmptyMessage(0)
                } catch (e: InterruptedException) {
                    Log.d("interupt", "interupt 발생")
                }
            }
        }
    }

}