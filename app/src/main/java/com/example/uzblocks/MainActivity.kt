package com.example.uzblocks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uzblocks.APi.ApiService
import com.example.uzblocks.APi.Base
import com.example.uzblocks.Adapters.PostAdapter
import com.example.uzblocks.Adapters.UserAdapter
import com.example.uzblocks.Models.PostModel

import com.example.uzblocks.Models.UserModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loadUser()
        loadPost()



    }
    fun loadUser(){
        ApiService.getClient().getUser().enqueue(object :Callback<Base<List<UserModel>>>{
            override fun onResponse(
                call: Call<Base<List<UserModel>>>,
                response: Response<Base<List<UserModel>>>
            ) {
                RecUser.layoutManager  = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
                RecUser.adapter  = UserAdapter(response.body()?.data ?: emptyList())

            }

            override fun onFailure(call: Call<Base<List<UserModel>>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Nooooooooooo bro ",Toast.LENGTH_LONG).show()
            }
        })
    }

    fun loadPost(){
        ApiService.getClient().getPost().enqueue(object :Callback<Base<List<PostModel>>>{
            override fun onResponse(
                call: Call<Base<List<PostModel>>>,
                response: Response<Base<List<PostModel>>>
            ) {
                RecPost.layoutManager  = LinearLayoutManager(this@MainActivity)
                RecPost.adapter  = PostAdapter(response.body()?.data ?: emptyList())
            }

            override fun onFailure(call: Call<Base<List<PostModel>>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Nooooooooooo  ",Toast.LENGTH_LONG).show()
            }
        })
    }



}


