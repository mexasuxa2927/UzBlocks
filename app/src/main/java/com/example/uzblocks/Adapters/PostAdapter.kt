package com.example.uzblocks.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uzblocks.CommentsByPost
import com.example.uzblocks.Models.PostModel
import com.example.uzblocks.R
import kotlinx.android.synthetic.main.custom_post_view.view.*


class PostAdapter (val item:List<PostModel>): RecyclerView.Adapter<PostAdapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_post_view,parent,false))

    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val post =item[position]


        Glide.with(holder.itemView.context).load(item[position].image).into(holder.itemView.PostImage)
        holder.itemView.Post_text.text = item[position].text
        holder.itemView.Post_like.text = item[position].likes
        holder.itemView.Post_tags.text = "#"+item[position].tags[0]+" #"+item[position].tags[1]+" #"+item[position].tags[2]

        holder.itemView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                val intent  = Intent(holder.itemView.context,CommentsByPost::class.java)
                intent.putExtra("id",post.id)
                intent.putExtra("image",post.image)
                intent.putExtra("likes",post.likes)
                intent.putExtra("text",post.text)
                holder.itemView.context.startActivity(intent)
            }
        })

    }



    override fun getItemCount(): Int {
        return item.count()
    }
}
