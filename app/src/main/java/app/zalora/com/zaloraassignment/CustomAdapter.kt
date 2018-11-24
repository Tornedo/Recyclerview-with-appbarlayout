package com.mathi.recyclerviewsample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import app.zalora.com.zaloraassignment.R
import app.zalora.com.zaloraassignment.TweetEntity

class CustomAdapter(internal var context: Context, internal var androidList: List<TweetEntity>)
    : RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_android_list, parent, false)

        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder.name.text = androidList[position].tweetString


    }

    override fun getItemCount(): Int {
        return androidList.size
    }
}
