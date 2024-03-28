package com.example.advweek4160421024.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.AndroidViewModel
import com.example.advweek4160421024.R
import com.example.advweek4160421024.databinding.FragmentStudentListBinding
import com.example.advweek4160421024.databinding.FragmentWebListBinding
import com.example.advweek4160421024.viewmodel.ListViewModel


class WebListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val webListAdapter = WebListAdapter(arrayListOf())
    private lateinit var binding: FragmentWebListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWebListBinding.inflate(inflater, container, false)
        return binding.root
    }


}