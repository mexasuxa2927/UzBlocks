package com.example.uzblocks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.uzblocks.APi.ApiService
import com.example.uzblocks.APi.Base
import com.example.uzblocks.Adapters.PostAdapter
import com.example.uzblocks.Models.PostModel
import com.example.uzblocks.Models.UserModel
import kotlinx.android.synthetic.main.activity_post_by_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostByUser : AppCompatActivity() {

    lateinit var id:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_by_user)

        val intent:Intent =  getIntent()

        Glide.with(this).load(intent.getStringExtra("picture")).into(ImageProfile)
        LastName.text = intent.getStringExtra("lastname")
        FirstName.text= intent.getStringExtra("title")+"."+ intent.getStringExtra("firstname")
        id   = intent.getStringExtra("id").toString()

        loadPostbyUser(id)



    }
    fun loadPostbyUser(ids:String){
        ApiService.getClient().getPostbyUser(ids).enqueue(object :Callback<Base<List<PostModel>>>{
            override fun onResponse(
                call: Call<Base<List<PostModel>>>,
                response: Response<Base<List<PostModel>>>
            ) {
                RecPostByUser.layoutManager  = LinearLayoutManager(this@PostByUser)
                RecPostByUser.adapter = PostAdapter(response.body()?.data ?: emptyList())
            }

            override fun onFailure(call: Call<Base<List<PostModel>>>, t: Throwable) {
                Toast.makeText(this@PostByUser,"Noooo Data",Toast.LENGTH_LONG).show()
            }

        })

    }

}