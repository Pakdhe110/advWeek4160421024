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
/*
[
{
    "id": 1,
    "name": "TechCrunch",
    "url": "https://techcrunch.com",
    "topics": ["Technology", "Startups", "Business"],
    "founder": {
    "name": "Michael Arrington",
    "country": "United States"
},
    "images": [
    "https://loremflickr.com/320/240/cars?lock=1"
    ]
},
{
    "id": 2,
    "name": "BBC News",
    "url": "https://www.bbc.com/news",
    "topics": ["News", "World", "Politics"],
    "founder": {
    "name": "John Reith",
    "country": "United Kingdom"
},
    "images": [
    "https://loremflickr.com/320/240/cars?lock=2"
    ]
},
{
    "id": 3,
    "name": "Etsy",
    "url": "https://www.etsy.com",
    "topics": ["Crafts", "Handmade", "Vintage"],
    "founder": {
    "name": "Robert Kalin",
    "country": "United States"
},
    "images": [
    "https://loremflickr.com/320/240/cars?lock=3"
    ]
},
{
    "id": 4,
    "name": "National Geographic",
    "url": "https://www.nationalgeographic.com",
    "topics": ["Science", "Nature", "Exploration"],
    "founder": {
    "name": "Alexander Graham Bell",
    "country": "United States"
},
    "images": [
    "https://loremflickr.com/320/240/cars?lock=4"
    ]
},
{
    "id": 5,
    "name": "IMDb",
    "url": "https://www.imdb.com",
    "topics": ["Movies", "TV Shows", "Celebrities"],
    "founder": {
    "name": "Col Needham",
    "country": "United Kingdom"
},
    "images": [
    "https://loremflickr.com/320/240/cars?lock=5"
    ]
},
{
    "id": 6,
    "name": "Airbnb",
    "url": "https://www.airbnb.com",
    "topics": ["Travel", "Hospitality", "Accommodations"],
    "founder": {
    "name": "Brian Chesky",
    "country": "United States"
},
    "images": [
    "https://loremflickr.com/320/240/cars?lock=6"
    ]
},
{
    "id": 7,
    "name": "GitHub",
    "url": "https://github.com",
    "topics": ["Coding", "Open Source", "Development"],
    "founder": {
    "name": "Chris Wanstrath",
    "country": "United States"
},
    "images": [
    "https://loremflickr.com/320/240/cars?lock=7"
    ]
},
{
    "id": 8,
    "name": "Reddit",
    "url": "https://www.reddit.com",
    "topics": ["Discussion", "Community", "Social News"],
    "founder": {
    "name": "Steve Huffman",
    "country": "United States"
},
    "images": [
    "https://loremflickr.com/320/240/cars?lock=8"
    ]
},
{
    "id": 9,
    "name": "Stack Overflow",
    "url": "https://stackoverflow.com",
    "topics": ["Programming", "Coding Challenges", "Technical Questions"],
    "founder": {
    "name": "Jeff Atwood",
    "country": "United States"
},
    "images": [
    "https://loremflickr.com/320/240/cars?lock=9"
    ]
},
{
    "id": 10,
    "name": "Medium",
    "url": "https://medium.com",
    "topics": ["Writing", "Blogging", "Storytelling"],
    "founder": {
    "name": "Ev Williams",
    "country": "United States"
},
    "images": [
    "https://loremflickr.com/320/240/cars?lock=10"
    ]
}
]
*/