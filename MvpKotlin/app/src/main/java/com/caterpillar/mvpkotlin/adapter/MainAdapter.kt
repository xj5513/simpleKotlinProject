package com.caterpillar.mvpkotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.caterpillar.mvpkotlin.R
import com.caterpillar.mvpkotlin.data.User
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by caterpillar on 2017/8/4.
 */

class MainAdapter(val ctx:Context) : RecyclerView.Adapter<MainAdapter.MainHolder>(){

    interface OnItemClickListener{
        fun onItemClick(user:User)
    }

    private val data : ArrayList<User> = arrayListOf()

    var onItemClick : OnItemClickListener ?= null
        set(value){
            field = value
        }

    fun  notifyDataSetChanged(users: List<User>){
        data.clear()
        data.addAll(users)
        println(users.size)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainHolder {
        val itemView = LayoutInflater.from(ctx).inflate(R.layout.adapter_user_item, parent,false)
        return MainHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainHolder?, position: Int) {
        val user = data[position]
        Glide.with(ctx).load(user.avatar_url).into(holder?.user_avatar)
        holder?.user_name?.text = user.name
        holder?.user_scope?.text = "${user.score}"
        holder?.user_home?.text = user.html_url

        holder?.itemView?.onClick {
            onItemClick?.onItemClick(user)
        }
    }


    class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val user_avatar : ImageView = itemView.find(R.id.user_avatar)
        val user_name : TextView = itemView.find(R.id.user_name)
        val user_scope : TextView = itemView.find(R.id.user_scope)
        val user_home : TextView = itemView.find(R.id.user_home)
    }
}
