package com.example.advweek4160421024.model

import com.google.gson.annotations.SerializedName

data class Student(
    var id : String?,
    @SerializedName("student_name")
    var name:String?,
    @SerializedName("birth_of_date")
    var dob:String?,
    var phone:String?,
    @SerializedName("photo_url")
    var photoUrl:String?,
)

data class Web(
    var id : String?,
    var name: String?,
    var url : String?,
    var topics: String?,
    var founder: Founder?,
    var image:String?,
)

data class Founder(
    var name : String?,
    var country : String,
)