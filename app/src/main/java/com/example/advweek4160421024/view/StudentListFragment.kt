package com.example.advweek4160421024.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.advweek4160421024.R
import com.example.advweek4160421024.databinding.FragmentStudentListBinding
import com.example.advweek4160421024.viewmodel.ListViewModel


class StudentListFragment : Fragment() {
    private lateinit var  viewModel: ListViewModel
    private val studentListAdapter = StudentListAdapter(arrayListOf())
    private lateinit var  binding:FragmentStudentListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = studentListAdapter

        observeViewModel()
        binding.refreshLayoutWeb.setOnClickListener{
            binding.recView.visibility = View.GONE
            binding.txtError.visibility = View.GONE
            binding.progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            binding.refreshLayoutWeb.isRefreshing  = false
        }

    }

    fun observeViewModel(){
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            studentListAdapter.updateStudentList(it)
        })

        viewModel.studentLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if (it == true){
                binding.txtError?.visibility = View.VISIBLE
            }
            else{
                binding.txtError?.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true){
                binding.recView.visibility = View.GONE
                binding.progressLoad.visibility = View.VISIBLE
            }
            else{
                binding.recView.visibility = View.VISIBLE
                binding.progressLoad.visibility = View.GONE
            }
        })
    }



}