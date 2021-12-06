package com.example.uzblocks.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uzblocks.Models.CommentModel
import com.example.uzblocks.R
import kotlinx.android.synthetic.main.comment_view.view.*

class CommentAdapter (val item:List<CommentModel>): RecyclerView.Adapter<CommentAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.comment_view,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(item[position].owner.picture).into(holder.itemView.ImageProfile_Comment)
        holder.itemView.Name.text = item[position].owner.title+"."+item[position].owner.firstName+" "+item[position].owner.lastName
        holder.itemView.data_comment.text = item[position].publishData
        holder.itemView.message.text  = item[position].message
    }

    override fun getItemCount(): Int {
       return item.count()
    }
}