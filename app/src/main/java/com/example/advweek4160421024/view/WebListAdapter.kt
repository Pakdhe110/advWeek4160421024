package com.example.advweek4160421024.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4160421024.databinding.StudentListItemBinding
import com.example.advweek4160421024.databinding.WebListItemBinding
import com.example.advweek4160421024.model.Student
import com.example.advweek4160421024.model.Web
import com.example.advweek4160421024.viewmodel.ListViewModel

class WebListAdapter(val webList: ArrayList<Web>):RecyclerView.Adapter<WebListAdapter.WebViewHolder>() {
    class WebViewHolder(var binding:WebListItemBinding):RecyclerView.ViewHolder(binding.root);

    override fun onBindViewHolder(holder: WebViewHolder, position: Int)  {
        holder.binding.txtNameWeb.text = webList[position].name
        holder.binding.txtUrl.text = webList[position].url

        holder.binding.btnBuka.setOnClickListener {
            val action = StudentListFragmentDirections.actionStudentDetail(it.id.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebViewHolder {
        val binding = WebListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WebListAdapter.WebViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return webList.size
    }


    fun updateWebList(newWebList:ArrayList<Web>){
        webList.clear()
        webList.addAll(newWebList)
        notifyDataSetChanged()
    }
}