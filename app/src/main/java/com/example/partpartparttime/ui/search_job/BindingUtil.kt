package com.example.partpartparttime.ui.search_job

import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.partpartparttime.R
import com.example.partpartparttime.database.Company


@BindingAdapter("companyIDString")
fun TextView.setCompanyIDString(item: Company?) {
    item?.let {
        text = item.companyID
    }
}

@BindingAdapter("company_nameString")
fun TextView.setcompany_nameString(item: Company?) {
    item?.let {
        text = item.companyName
    }
}

@BindingAdapter("company_jobString")
fun TextView.setcompany_jobString(item: Company?) {
    item?.let {
        text = item.job
    }
}

@BindingAdapter("job_categoryString")
fun TextView.setjob_categoryString(item: Company?) {
    item?.let {
        text = item.category
    }
}

@BindingAdapter("matchImageString")
fun ConstraintLayout.setEventImage(item: Company?) {
    item?.let {
        background = ContextCompat.getDrawable(context, R.drawable.recycler2)
    }
}
