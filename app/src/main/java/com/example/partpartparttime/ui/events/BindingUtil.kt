package com.example.potensituitionapp.Main

import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.partpartparttime.R
import com.example.partpartparttime.database.Event

@BindingAdapter("eventNameString")
fun TextView.setEventNameString(item: Event?) {
    item?.let {
        text = item.eventID.toString()
    }
}

@BindingAdapter("eventDescriptionString")
fun TextView.setEventDescriptionString(item: Event?) {
    item?.let {
        text = item.event_description
    }
}

@BindingAdapter("eventImageString")
fun ConstraintLayout.setEventImage(item: Event?) {
    item?.let {
        background = ContextCompat.getDrawable(context, R.color.colorPrimaryDark)
    }
}