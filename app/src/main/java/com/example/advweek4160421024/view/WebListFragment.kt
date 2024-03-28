package com.example.advweek4160421024.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.advweek4160421024.R
import com.example.advweek4160421024.databinding.FragmentStudentListBinding
import com.example.advweek4160421024.databinding.FragmentWebListBinding
import com.example.advweek4160421024.viewmodel.ListViewModel
import com.example.advweek4160421024.viewmodel.LiveModel


class WebListFragment : Fragment() {
    private lateinit var viewModel: LiveModel
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LiveModel::class.java)
        viewModel.refresh()

        binding.recViewWeb.layoutManager = LinearLayoutManager(context)
        binding.recViewWeb.adapter = webListAdapter

        ObserveViewModel()
        binding.refreshLayoutWeb.setOnClickListener{
            binding.recViewWeb.visibility = View.GONE
            binding.txtErrorWeb.visibility = View.GONE
            binding.progBar.visibility = View.VISIBLE
            viewModel.refresh()
            binding.refreshLayoutWeb.isRefreshing  = false
        }
    }
    fun ObserveViewModel(){

        viewModel.webLD.observe(viewLifecycleOwner, Observer {
            webListAdapter.updateWebList(it)
        })

        viewModel.webLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if (it == true){
                binding.txtErrorWeb?.visibility = View.VISIBLE
            }
            else{
                binding.txtErrorWeb?.visibility = View.GONE
            }
        })

        viewModel.loadLD.observe(viewLifecycleOwner, Observer {
            if(it == true){
                binding.recViewWeb.visibility = View.GONE
                binding.progBar.visibility = View.VISIBLE
            }
            else{
                binding.recViewWeb.visibility = View.VISIBLE
                binding.progBar.visibility = View.GONE
            }
        })
    }


}