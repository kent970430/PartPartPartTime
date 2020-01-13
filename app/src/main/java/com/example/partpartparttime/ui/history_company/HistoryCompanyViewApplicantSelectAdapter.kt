package com.example.partpartparttime.ui.history_company

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.partpartparttime.database.HistoryApplicant
import com.example.partpartparttime.databinding.ListHistoryyApplicantselectcompanyBinding

class HistoryCompanyViewApplicantSelectAdapter (val clickListener: ClickListenerrrr):
        ListAdapter<HistoryApplicant, HistoryCompanyViewApplicantSelectAdapter.ViewHolder>(HistoryyyyCompanyViewApplicantDiffCallback()){

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

    class ViewHolder private constructor(val binding: ListHistoryyApplicantselectcompanyBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(
            item: HistoryApplicant,
            clickListener: ClickListenerrrr
        ) {
            binding.apphistoryapplicant = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
        companion object{
            fun from(parent: ViewGroup): ViewHolder{
                val layoutInflater =
                    LayoutInflater.from(parent.context)
                val binding =
                    ListHistoryyApplicantselectcompanyBinding.inflate(layoutInflater,parent,false)
                return ViewHolder(
                    binding
                )
            }
        }
    }
}

class HistoryyyyCompanyViewApplicantDiffCallback: DiffUtil.ItemCallback<HistoryApplicant>(){
    override fun areItemsTheSame(oldItem: HistoryApplicant, newItem: HistoryApplicant): Boolean {
        return oldItem.userID == newItem.userID
    }

    override fun areContentsTheSame(oldItem: HistoryApplicant, newItem: HistoryApplicant): Boolean {
        return oldItem == newItem

    }
}

class ClickListenerrrr(val clickListener: (applicantIDDDDD: String?) -> Unit) {
    fun onClick(eventt: HistoryApplicant) = clickListener(eventt.userID)
}