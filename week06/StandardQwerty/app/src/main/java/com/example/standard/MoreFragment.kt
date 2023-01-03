package com.example.standard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.standard.databinding.FragmentMoreBinding
import com.example.standard.databinding.FragmentOneBinding
import com.google.android.material.tabs.TabLayoutMediator

class MoreFragment : Fragment() {

    private lateinit var binding: FragmentMoreBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMoreBinding.inflate(layoutInflater)

        val moreVPAdapter = MoreVPAdapter(requireActivity())
        binding.vpMore.adapter = moreVPAdapter

        val tabTitleArr = arrayOf("One", "Two", "Three")
        TabLayoutMediator(binding.tabFragMore, binding.vpMore) { tab, pos ->
            tab.text = tabTitleArr[pos]
        }.attach()

        return binding.root
    }
}