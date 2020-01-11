package com.example.partpartparttime.ui.history_applicant

import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.partpartparttime.R
import com.example.partpartparttime.database.HistoryApplicant

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