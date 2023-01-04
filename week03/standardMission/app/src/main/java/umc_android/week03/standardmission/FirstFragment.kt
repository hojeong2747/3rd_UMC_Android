package umc_android.week03.standardmission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import umc_android.week03.standardmission.databinding.FragmentFirstBinding

class FirstFragment: Fragment() {
    private lateinit var viewBinding: FragmentFirstBinding
    override fun onCreateView( // onCreateView() 메소드 : 3개의 매개변수를 갖고, View 객체를 반환함.
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { // View 객체는 fragment 객체의 상위 객체.
        viewBinding = FragmentFirstBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}