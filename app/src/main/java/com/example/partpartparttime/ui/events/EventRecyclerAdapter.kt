package com.example.partpartparttime.ui.events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.partpartparttime.database.Event
import com.example.partpartparttime.databinding.ListEventBinding

class EventRecyclerAdapter(val clickListener: EventListener) :
    ListAdapter<Event, EventRecyclerAdapter.ViewHolder>(EventDiffCallback()){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    class ViewHolder private constructor(val binding: ListEventBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: Event,
            clickListener: EventListener
        ) {
            binding.eventttttt = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater =
                    LayoutInflater.from(parent.context)
                val binding =
                    ListEventBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(
                    binding
                )
            }
        }
    }
}

class EventDiffCallback : DiffUtil.ItemCallback<Event>() {
    override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
        return oldItem.eventID == newItem.eventID
    }

    override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
        return oldItem == newItem

    }
}

class EventListener(val clickListener: (eventId: Int) -> Unit) {
    fun onClick(eventt: Event) = clickListener(eventt.eventID)
}