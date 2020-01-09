package com.example.partpartparttime.ui.training

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.partpartparttime.database.Training
import com.example.partpartparttime.databinding.ListTrainingBinding

class TrainingRecyclerAdapter (val clickListener: TrainingListener) :
        ListAdapter<Training, TrainingRecyclerAdapter.ViewHolder> (TrainingDiffCallBack()){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TrainingRecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    class ViewHolder private constructor(val binding: ListTrainingBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(
            item: Training,
            clickListener: TrainingListener
        ) {
            binding.trainingggg = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
        companion object{
            fun from(parent: ViewGroup) : ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListTrainingBinding.inflate(layoutInflater,parent,false)

                return ViewHolder(binding)
            }
        }
    }
}

class TrainingDiffCallBack : DiffUtil.ItemCallback<Training>(){
    override fun areItemsTheSame(oldItem: Training, newItem: Training): Boolean {
        return oldItem.trainingID == newItem.trainingID
    }

    override fun areContentsTheSame(oldItem: Training, newItem: Training): Boolean {
        return oldItem == newItem
    }
}

class TrainingListener(val clickListener: (trainingID: String?) -> Unit) {
    fun onClick(trainn: Training) = clickListener(trainn.trainingID)
}