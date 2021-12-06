package com.example.uzblocks.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uzblocks.Models.UserModel
import com.example.uzblocks.PostByUser
import com.example.uzblocks.R
import kotlinx.android.synthetic.main.custom_user_profile.view.*

class UserAdapter(val item:List<UserModel>): RecyclerView.Adapter<UserAdapter.MyViewHolderUser>() {

    inner class MyViewHolderUser(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderUser {
        return MyViewHolderUser(LayoutInflater.from(parent.context).inflate(R.layout.custom_user_profile,parent,false))

    }

    override fun onBindViewHolder(holder: MyViewHolderUser, position: Int) {
        val user:UserModel = item[position]

        holder.itemView.UserName.text = item[position].firstName
        Glide.with(holder.itemView.context).load(item[position].picture).into(holder.itemView.UserPicture)
        holder.itemView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                var intent = Intent(holder.itemView.context,PostByUser::class.java)
                intent.putExtra("firstname",(user.firstName))
                intent.putExtra("lastname",(user.lastName))
                intent.putExtra("picture",(user.picture))
                intent.putExtra("title",(user.title))
                intent.putExtra("id",(user.id))
                holder.itemView.context.startActivity(intent)
            }
        })

    }

    override fun getItemCount(): Int {
        return item.count()

    }

}
