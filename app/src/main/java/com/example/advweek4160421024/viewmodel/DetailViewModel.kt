package com.example.advweek4160421024.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.example.advweek4160421024.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DetailViewModel: ViewModel() {
    val studentLD = MutableLiveData<Student>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null
    val studentLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun fetch(studentId: String){
        //val student1 =Student("16055", "Nonie", "1998/03/28", "571844778", "http://dummyimage.com/75x100.jpg/cc0000/ffffff")
        //studentLD.value = student1

        val url = "http://adv.jitusolution.com/student.php?id=" + studentId
        val stringRequest  = StringRequest(
            Request.Method.GET, url,{
                val sType = object : TypeToken<Student>() { }.type
                val result = Gson().fromJson<List<Student>>(it, sType)
                studentLD.value = result as Student?
                loadingLD.value = false
                Log.d("showfoley", result.toString())
            },
            {
                Log.d("showfoley", it.toString())
                studentLoadErrorLD.value = false
                loadingLD.value = false
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }
}