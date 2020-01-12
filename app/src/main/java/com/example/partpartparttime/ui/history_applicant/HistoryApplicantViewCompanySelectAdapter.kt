package com.example.partpartparttime.ui.history_applicant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.partpartparttime.database.HistoryCompany
import com.example.partpartparttime.databinding.ListHistoryyCompanyselectapplicantBinding

class HistoryApplicantViewCompanySelectAdapter (val clickListener: companychooseListener):
    ListAdapter<HistoryCompany, HistoryApplicantViewCompanySelectAdapter.ViewHolder>(HistoryyyyCompanyFindApplicantDiffCallback()){

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

    class ViewHolder private constructor(val binding: ListHistoryyCompanyselectapplicantBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(
            item: HistoryCompany,
            clickListener: companychooseListener
        ){
            binding.compapplicant = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
        companion object{
            fun from(parent: ViewGroup): ViewHolder{
                val layoutInflater =
                    LayoutInflater.from(parent.context)
                val binding =
                    ListHistoryyCompanyselectapplicantBinding.inflate(layoutInflater,parent,false)
                return ViewHolder(
                    binding
                )
            }
        }
    }
}

class HistoryyyyCompanyFindApplicantDiffCallback: DiffUtil.ItemCallback<HistoryCompany>(){
    override fun areItemsTheSame(oldItem: HistoryCompany, newItem: HistoryCompany): Boolean {
        return oldItem.history_comID == newItem.history_comID
    }

    override fun areContentsTheSame(oldItem: HistoryCompany, newItem: HistoryCompany): Boolean {
        return oldItem == newItem
    }
}

class companychooseListener(val clickListener: (companyIDDDDD: String?) -> Unit) {
    fun onClick(compp: HistoryCompany) = clickListener(compp.history_comID)
}