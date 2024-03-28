package com.example.advweek4160421024.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.advweek4160421024.model.Student
import com.example.advweek4160421024.model.Web
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LiveModel(application: Application):AndroidViewModel(application) {
    val webLD = MutableLiveData<ArrayList<Web>>()
    val webLoadErrorLD = MutableLiveData<Boolean>()
    val loadLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue:RequestQueue? = null

    fun refresh(){

            /*studentLD.value = arrayListOf(
                Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100" +
                        ".jpg/cc0000/ffffff"),
                Student("13312","Rich","1994/12/14","3925444073","http://dummyimage.com/75x100" +
                        ".jpg/5fa2dd/ffffff"),
                Student("11204","Dinny","1994/10/07","6827808747",
                    "http://dummyimage.com/75x100.jpg/5fa2dd/ffffff1"))
            */

        webLoadErrorLD.value = false

        loadLD.value = false

            queue = Volley.newRequestQueue(getApplication())
            val url = "http://10.0.0.2/website/web.json"

            val stringRequest  = StringRequest(
                Request.Method.GET, url,{
                    val sType = object : TypeToken<List<Web>>() { }.type
                    val result = Gson().fromJson<List<Web>>(it, sType)
                    webLD.value = result as ArrayList<Web>?
                    loadLD.value = false
                    Log.d("showfoley", result.toString())
                },
                {
                    Log.d("showfoley", it.toString())
                    webLoadErrorLD.value = false
                    loadLD.value = false
                }
            )

            stringRequest.tag = TAG
            queue?.add(stringRequest)

    }
}