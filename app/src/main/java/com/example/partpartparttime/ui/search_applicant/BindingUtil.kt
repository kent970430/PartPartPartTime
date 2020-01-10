package com.example.partpartparttime.ui.search_applicant

import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.partpartparttime.R
import com.example.partpartparttime.database.Match


@BindingAdapter("companyIDString")
fun TextView.setCompanyIDString(item: Match?) {
    item?.let {
        text = item.companyID
    }
}

@BindingAdapter("userIDDString")
fun TextView.setUserIDDString(item: Match?) {
    item?.let {
        text = item.userID
    }
}

@BindingAdapter("matchImageString")
fun ConstraintLayout.setEventImage(item: Match?) {
    item?.let {
        background = ContextCompat.getDrawable(context, R.color.gray)
    }
}