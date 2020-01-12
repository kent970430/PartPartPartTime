package com.example.partpartparttime.ui.history_applicant

import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.partpartparttime.R
import com.example.partpartparttime.database.HistoryApplicant
import com.example.partpartparttime.database.HistoryCompany

@BindingAdapter("companyNameeString")
fun TextView.setCompanyNameeString(item: HistoryApplicant?) {
    item?.let {
        text = item.companyName.toString()
    }
}


@BindingAdapter("matchImageString")
fun ConstraintLayout.setMatchImageString(item: HistoryApplicant?) {
    item?.let {
        background = ContextCompat.getDrawable(context, R.drawable.recyclevieww)
    }
}

@BindingAdapter("companyyyyNameeString")
fun TextView.setCompanyNameeString(item: HistoryCompany?) {
    item?.let {
        text = item.history_comID.toString()
    }
}


@BindingAdapter("ImageString")
fun ConstraintLayout.setMatchImageString(item: HistoryCompany?) {
    item?.let {
        background = ContextCompat.getDrawable(context, R.drawable.recyclevieww)
    }
}