package com.example.partpartparttime.ui.history_applicant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.partpartparttime.database.HistoryApplicant
import com.example.partpartparttime.databinding.ListHistoryApplicantBinding

class HistoryApplicantFindCompanyAdapter (val clickListener: HistoryListener):
        ListAdapter<HistoryApplicant, HistoryApplicantFindCompanyAdapter.ViewHolder>(HistoryApplicantFindCompanyDiffCallback()){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position)!!, clickListener)
    }

    class ViewHolder private constructor(val binding: ListHistoryApplicantBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(
            item: HistoryApplicant,
            clickListener: HistoryListener
        ) {
            binding.historyapplicant = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
        companion object{
            fun from(parent: ViewGroup): ViewHolder{
            val layoutInflater =
                LayoutInflater.from(parent.context)
            val binding =
                ListHistoryApplicantBinding.inflate(layoutInflater, parent,false)
            return ViewHolder(
                binding
                )
            }
        }
    }
}

class HistoryApplicantFindCompanyDiffCallback: DiffUtil.ItemCallback<HistoryApplicant>(){
    override fun areItemsTheSame(oldItem: HistoryApplicant, newItem: HistoryApplicant): Boolean {
        return oldItem.companyName == newItem.companyName
    }

    override fun areContentsTheSame(oldItem: HistoryApplicant, newItem: HistoryApplicant): Boolean {
        return oldItem == newItem

    }
}

class HistoryListener(val clickListener: (companyName: String?) -> Unit) {
    fun onClick(eventt: HistoryApplicant) = clickListener(eventt.companyName)
}