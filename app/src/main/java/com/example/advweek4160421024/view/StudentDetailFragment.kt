package com.example.advweek4160421024.view

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4160421024.R
import com.example.advweek4160421024.viewmodel.ListViewModel
import com.example.advweek4160421024.databinding.FragmentStudentDetailBinding
import com.example.advweek4160421024.databinding.StudentListItemBinding
import com.example.advweek4160421024.model.Student
import com.example.advweek4160421024.viewmodel.DetailViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit


/**
 * A simple [Fragment] subclass.
 * Use the [StudentDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentDetailFragment : Fragment() {
    private lateinit var viewModel : DetailViewModel
    private lateinit var binding: FragmentStudentDetailBinding
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStudentDetailBinding.inflate(inflater, container, false)
        return binding.root

    }
    class StudentViewHolder(var binding: FragmentStudentDetailBinding)
        : RecyclerView.ViewHolder(binding.root);

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(studentId = binding.txtID.text.toString())
        viewModel.studentLD.observe(viewLifecycleOwner, Observer{ student -> updateUI(student)})
    }

    private fun updateUI(student: Student){
        binding.txtID.setText(student.id)
        binding.txtName.setText(student.name)
        binding.txtBod.setText(student.dob)
        binding.txtPhone.setText(student.phone)

    }
    fun observeViewModel(){
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            var student = it

            binding.btnUpdate.setOnClickListener{
                Observable.timer(5, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe{
                        Log.d("Messages", "five seconds")
                        MainActivity.showNotification(student.name.toString(),
                            "A new notification created",
                            androidx.vectordrawable.animated.R.drawable.notification_tile_bg)
                    }
            }
        })
    }
}