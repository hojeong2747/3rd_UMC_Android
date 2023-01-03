package umc_android.week06.lablayoutview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import umc_android.week06.lablayoutview.databinding.FragmentHomeBinding
import umc_android.week06.lablayoutview.databinding.FragmentOneBinding

class OneFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentOneBinding.inflate(layoutInflater).root
    }
}