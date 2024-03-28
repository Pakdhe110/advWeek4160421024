package com.example.advweek4160421024.view

import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4160421024.databinding.WebListItemBinding
import com.example.advweek4160421024.model.Web
import com.example.advweek4160421024.viewmodel.ListViewModel

class WebListAdapter(val webList: ArrayList<Web>):RecyclerView.Adapter<WebListAdapter.WebViewHolder>() {
    class WebViewHolder(var binding:WebListItemBinding):RecyclerView.ViewHolder(binding.root);

    override fun onBindViewHolder(holder: WebViewHolder, position: Int)  {
        holder.binding.txtNameWeb.text = webList[position].name
        holder.binding.txtUrl.text = webList[position].url

        holder.binding.btnBuka.setOnClickListener {
            val action = StudentListFragmentDirections.actionStudentDetail()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return webList.size
    }
}