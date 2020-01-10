package com.example.partpartparttime.ui.search_job

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.partpartparttime.R
import com.example.partpartparttime.database.Company
import com.example.partpartparttime.databinding.ListCompany2Binding
import com.example.partpartparttime.generated.callback.OnClickListener

class SearchCompanyAdapter(val clickListener: MatchListener):
    ListAdapter<Company, SearchCompanyAdapter.ViewHolder>(MatchDiffCallBack2()){

    //override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    class ViewHolder private constructor(val binding: ListCompany2Binding): RecyclerView.ViewHolder(binding.root){
        fun bind (
            item: Company,
            clickListener: MatchListener
        ){
            binding.companyy2 = item
            binding.clickListener = clickListener
            binding.executePendingBindings()

        }

        companion object {
            fun from (parent:ViewGroup): ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListCompany2Binding.inflate(layoutInflater,parent,false)
                return ViewHolder(binding)
            }
        }
    }
}

class MatchDiffCallBack2 : DiffUtil.ItemCallback<Company>() {
    override fun areItemsTheSame(oldItem: Company, newItem: Company): Boolean {
        return oldItem.companyID == newItem.companyID
    }

    override fun areContentsTheSame(oldItem: Company, newItem: Company): Boolean {
        return oldItem == newItem

    }
}

class MatchListener(val clickListener: (companyID: String?) -> Unit) {
    fun onClick(searchMatch: Company) = clickListener(searchMatch.companyID)
}