package com.example.uzblocks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.uzblocks.APi.ApiService
import com.example.uzblocks.APi.Base
import com.example.uzblocks.Adapters.CommentAdapter
import com.example.uzblocks.Models.CommentModel
import kotlinx.android.synthetic.main.activity_comments_by_post.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsByPost : AppCompatActivity() {
    lateinit var id :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments_by_post)

        val intent  = getIntent()
        Glide.with(this).load(intent.getStringExtra("image")).into(ImagePost)
        post_text.text = intent.getStringExtra("text")
        NumberOfLikes.text = intent.getStringExtra("likes")
        id = intent.getStringExtra("id").toString()

        loadCommentByPost(id)

    }
    fun loadCommentByPost(ids:String){
        ApiService.getClient().getCommentByPost(ids).enqueue(object : Callback<Base<List<CommentModel>>>{
            override fun onResponse(
                call: Call<Base<List<CommentModel>>>,
                response: Response<Base<List<CommentModel>>>
            ) {
                RecCommentByPost.layoutManager  = LinearLayoutManager(this@CommentsByPost)
                RecCommentByPost.adapter = CommentAdapter(response.body()?.data ?: emptyList())
            }

            override fun onFailure(call: Call<Base<List<CommentModel>>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}