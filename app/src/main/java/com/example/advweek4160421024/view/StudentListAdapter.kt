package com.example.advweek4160421024.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4160421024.R
import com.example.advweek4160421024.databinding.StudentListItemBinding
import com.example.advweek4160421024.model.Student

class StudentListAdapter(val studentList:ArrayList<Student>):RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(), ButtonDetailClickListener
{

    class StudentViewHolder(var view: StudentListItemBinding)
        :RecyclerView.ViewHolder(view.root);

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater =  LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<StudentListItemBinding>(inflater, R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.student = studentList[position]
        holder.view.listener = this
        /*holder.binding.txtID.text = studentList[position].id
        holder.binding.txtName.text = studentList[position].name

        holder.binding.btnDetail.setOnClickListener{
            val action = StudentListFragmentDirections.actionStudentDetail(studentList[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }*/
    }
    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onButtonDetailClickListener(v: View) {
        val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }

    fun updateStudentList(newStudentList: ArrayList<Student>){
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

}

