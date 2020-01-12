package com.example.partpartparttime.ui.search_applicant

import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.partpartparttime.R
import com.example.partpartparttime.database.Applicant

@BindingAdapter("userIDString")
fun TextView.setCompanyIDString(item: Applicant?) {
    item?.let {
        text = item.userID
    }
}

@BindingAdapter("userNameString")
fun TextView.setUserIDDString(item: Applicant?) {
    item?.let {
        text = item.firstName + item.lastName
    }
}

@BindingAdapter("userEducationString")
fun TextView.setUserEducationString(item: Applicant?) {
    item?.let {
        text = item.education
    }
}

@BindingAdapter("userCategoryString")
fun TextView.setUserCategorytring(item: Applicant?) {
    item?.let {
        text = item.category
    }
}

@BindingAdapter("matchImageString")
fun ConstraintLayout.setEventImage(item: Applicant?) {
    item?.let {
        background = ContextCompat.getDrawable(context, R.drawable.recyclevieww)
    }
}