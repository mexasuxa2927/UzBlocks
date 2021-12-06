package com.example.uzblocks.APi

import com.example.uzblocks.Models.CommentModel
import com.example.uzblocks.Models.PostModel
import com.example.uzblocks.Models.UserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface Api {
    @Headers("app-id:61a48ab29e277bcc52d0d591")
    @GET("user")
    fun getUser() :Call<Base<List<UserModel>>>

    @Headers("app-id:61a48ab29e277bcc52d0d591")
    @GET("post")
    fun getPost() :Call<Base<List<PostModel>>>


    @Headers("app-id:61a48ab29e277bcc52d0d591")
    @GET("user/{user_id}/post")
    fun getPostbyUser(@Path("user_id") id:String) :Call<Base<List<PostModel>>>


    @Headers("app-id:61a48ab29e277bcc52d0d591")
    @GET("post/{post_id}/comment")
    fun getCommentByPost(@Path("post_id") id:String) :Call<Base<List<CommentModel>>>

    @Headers("app-id:61a48ab29e277bcc52d0d591")
    @GET("tag/{tags}/comment")
    fun getPostByTag(@Path("tags") tag:String) :Call<Base<List<PostModel>>>


}