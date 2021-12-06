package com.example.uzblocks.Models

data class PostModel(
    val id:String,
    val image:String,
    val likes:String,
    val text:String,
    val publishData:String,
    val tags:Array<String>,
    val owner:UserModel
)