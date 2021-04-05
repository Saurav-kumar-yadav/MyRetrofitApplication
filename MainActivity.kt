package com.example.retrofitapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapplication.databinding.ActivityMainBinding
import com.example.retrofitapplication.model.ResponseData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding!!.songList.layoutManager = LinearLayoutManager(this)
        gtNews()
    }

    private fun gtNews() {

        val news: Call<List<ResponseData>?>? = NewsService.newsinstance.getDetails()

        if (news != null) {
            news.enqueue(object : Callback<List<ResponseData>?> {
                override fun onResponse(
                    call: Call<List<ResponseData>?>,
                    response: Response<List<ResponseData>?>
                ) {
                    binding!!.songList.adapter = response.body()?.let { MyAdapter(it) }
                    Log.d("Response is ", response.body().toString())
                }
                override fun onFailure(call: Call<List<ResponseData>?>, t: Throwable) {
                    Log.d("Saurav", "Error in fetching data", t)
                }
            }
            )
        }
    }
}