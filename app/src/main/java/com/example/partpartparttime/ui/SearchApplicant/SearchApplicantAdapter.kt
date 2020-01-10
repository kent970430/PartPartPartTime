package com.example.partpartparttime.ui.SearchApplicant

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.partpartparttime.R
import com.example.partpartparttime.TextItemViewHolder
import com.example.partpartparttime.database.Company
import com.example.partpartparttime.database.Match

class SearchApplicantAdapter: RecyclerView.Adapter<TextItemViewHolder>() {
    var data =  listOf<Match>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.userID
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.text_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }




}