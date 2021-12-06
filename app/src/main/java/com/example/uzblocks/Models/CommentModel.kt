package com.example.uzblocks.Models

data class CommentModel(
    val id:String,
    val message:String,
    val owner:UserModel,
    val post:String,
    val publishData:String
    
)

