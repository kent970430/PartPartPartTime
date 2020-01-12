package com.example.partpartparttime.ui.history_company

import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.partpartparttime.R
import com.example.partpartparttime.database.HistoryCompany

@BindingAdapter("firstNameString")
fun TextView.setFirstNameString(item: HistoryCompany?) {
    item?.let {
        text = item.firstName.toString()
    }
}

@BindingAdapter("lastNameString")
fun TextView.setLastNameString(item: HistoryCompany?) {
    item?.let {
        text = item.lastName.toString()
    }
}

@BindingAdapter("matchImageString")
fun ConstraintLayout.msetMtchImageString(item: HistoryCompany?) {
    item?.let {
        background = ContextCompat.getDrawable(context, R.drawable.recyclevieww)
    }
}