package com.example.partpartparttime.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.partpartparttime.R
import kotlinx.android.synthetic.main.eventss.view.*

class EventRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items : List<EventPost> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EventViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.eventss,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is EventViewHolder ->{
                holder.bind(items.get(position))
            }
        }
    }

    fun submitList(eventList: List<EventPost>){
        items = eventList
    }

    class EventViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        val eventImage = itemView.event_image
        val eventTitle = itemView.event_title
        val eventAuthor = itemView.event_author

        fun bind(eventPost: EventPost){
            eventTitle.text = eventPost.title
            eventAuthor.text = eventPost.nameee

            val requestOptionss = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptionss)
                .load(eventPost.image)
                .into(eventImage)
        }
    }

}