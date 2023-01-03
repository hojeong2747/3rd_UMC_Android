package umc_android.week06.lablayoutview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import umc_android.week06.lablayoutview.databinding.FragmentOneBinding
import umc_android.week06.lablayoutview.databinding.FragmentTwoBinding

class TwoFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentTwoBinding.inflate(layoutInflater).root
    }
}