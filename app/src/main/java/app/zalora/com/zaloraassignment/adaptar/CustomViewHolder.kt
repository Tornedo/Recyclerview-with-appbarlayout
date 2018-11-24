package com.mathi.recyclerviewsample

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import app.zalora.com.zaloraassignment.R


class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var androidLayout: View
    var name: TextView
    init {
        androidLayout = itemView.findViewById(R.id.android_layout)
        name = itemView.findViewById(R.id.name) as TextView

    }
}
