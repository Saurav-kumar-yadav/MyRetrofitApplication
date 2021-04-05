package com.example.retrofitapplication

import com.example.retrofitapplication.model.ResponseData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://www.simplifiedcoding.net/demos/"
const val API_KEY = "marvel/"

interface NewsInterface {
    @GET("marvel/")
    fun getDetails():Call<List<ResponseData>?>
  //fun getDetails(@Query("name")name:String, @Query(value = "page")page :Int):Call<newsData>
}

object NewsService{
    var newsinstance:NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsinstance = retrofit.create(NewsInterface::class.java)
    }
 }