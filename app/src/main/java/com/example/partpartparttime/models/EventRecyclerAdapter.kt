package com.example.partpartparttime.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.partpartparttime.R
import com.example.partpartparttime.TextItemViewHolder
import com.example.partpartparttime.database.Event

class EventRecyclerAdapter : RecyclerView.Adapter<TextItemViewHolder>(){
    var data = listOf<Event>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.eventID.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.eventss, parent, false) as TextView
        return TextItemViewHolder(view)
    }

    override fun getItemCount() = data.size


}