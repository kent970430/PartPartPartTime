package com.example.partpartparttime.ui.history_company

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.partpartparttime.database.HistoryCompany
import com.example.partpartparttime.databinding.ListHistoryCompanyBinding

class HistoryCompanyFindApplicantAdapter (val clickListener: HistoryCListener):
        ListAdapter<HistoryCompany, HistoryCompanyFindApplicantAdapter.ViewHolder>(HistoryCompanyFindApplicantDiffCallback()){

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

    class ViewHolder private constructor(val binding: ListHistoryCompanyBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(
            item: HistoryCompany,
            clickListener : HistoryCListener
        ){
            binding.companyapplicant = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
        companion object{
            fun from(parent: ViewGroup): ViewHolder{
                val layoutInflater =
                    LayoutInflater.from(parent.context)
                val binding =
                    ListHistoryCompanyBinding.inflate(layoutInflater,parent,false)
                return ViewHolder(
                    binding
                )
            }
        }
    }
}

class HistoryCompanyFindApplicantDiffCallback: DiffUtil.ItemCallback<HistoryCompany>(){
    override fun areItemsTheSame(oldItem: HistoryCompany, newItem: HistoryCompany): Boolean {
        return oldItem.userID == newItem.userID
    }

    override fun areContentsTheSame(oldItem: HistoryCompany, newItem: HistoryCompany): Boolean {
        return oldItem == newItem

    }
}

class HistoryCListener(val clickListener: (userIDDDD: String?) -> Unit) {
    fun onClick(compp: HistoryCompany) = clickListener(compp.userID)
}