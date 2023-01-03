package umc_android.week03.standardmission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import umc_android.week03.standardmission.databinding.FragmentFirstBinding
import umc_android.week03.standardmission.databinding.FragmentSecondBinding

class SecondFragment: Fragment() {
    private lateinit var viewBinding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSecondBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}