package com.example.partpartparttime.ui.search_applicant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.partpartparttime.R
import com.example.partpartparttime.TextItemViewHolder
import com.example.partpartparttime.database.Applicant
import com.example.partpartparttime.databinding.ListCompanyBinding

class SearchApplicantAdapter(val clickListener: MatchListener):
    ListAdapter<Applicant, SearchApplicantAdapter.ViewHolder>(MatchDiffCallBack()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    class ViewHolder private constructor(val binding: ListCompanyBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(
            item: Applicant,
            clickListener: MatchListener
        ){
            binding.companyy = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
        companion object{
            fun from (parent:ViewGroup): ViewHolder{
                val layoutInflater=
                    LayoutInflater.from(parent.context)
                val binding =
                    ListCompanyBinding.inflate(layoutInflater,parent,false)
                return ViewHolder(
                    binding
                )
            }
        }
    }
}

class MatchDiffCallBack : DiffUtil.ItemCallback<Applicant>() {
    override fun areItemsTheSame(oldItem: Applicant, newItem: Applicant): Boolean {
        return oldItem.userID == newItem.userID
    }

    override fun areContentsTheSame(oldItem: Applicant, newItem: Applicant): Boolean {
        return oldItem == newItem

    }
}

class MatchListener(val clickListener: (userID: String?) -> Unit) {
    fun onClick(searchMatch: Applicant) = clickListener(searchMatch.userID)
}