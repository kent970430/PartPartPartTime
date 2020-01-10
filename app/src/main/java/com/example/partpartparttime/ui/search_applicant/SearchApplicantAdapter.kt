package com.example.partpartparttime.ui.search_applicant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.partpartparttime.R
import com.example.partpartparttime.TextItemViewHolder
import com.example.partpartparttime.database.Match
import com.example.partpartparttime.databinding.ListCompanyBinding

class SearchApplicantAdapter(val clickListener: MatchListener):
    ListAdapter<Match, SearchApplicantAdapter.ViewHolder>(MatchDiffCallBack()) {
//    var data =  listOf<Match>()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }
//
//    override fun getItemCount() = data.size
//
//    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
//        val item = data[position]
//        holder.textView.text = item.userID
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val view = layoutInflater
//            .inflate(R.layout.list_company, parent, false) as TextView
//        return TextItemViewHolder(view)
//    }

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
            item: Match,
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

class MatchDiffCallBack : DiffUtil.ItemCallback<Match>() {
    override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
        return oldItem.userID == newItem.userID
    }

    override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
        return oldItem == newItem

    }
}

class MatchListener(val clickListener: (companyID: String?) -> Unit) {
    fun onClick(searchMatch: Match) = clickListener(searchMatch.companyID)
}