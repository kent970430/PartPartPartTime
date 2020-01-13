package com.example.partpartparttime.ui.training

import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.partpartparttime.R
import com.example.partpartparttime.database.Training

@BindingAdapter("trainingIDString")
fun TextView.setTrainingIDString(item: Training?){
    item?.let{
        text = item.trainingID
    }
}

@BindingAdapter("trainingNameString")
fun TextView.setTrainingNameString(item: Training?){
    item?.let{
        text = item.trainingName
    }
}

@BindingAdapter("trainingDateString")
fun TextView.setTrainingDateString(item: Training?){
    item?.let{
        text = item.date
    }
}

@BindingAdapter("trainingWebString")
fun TextView.setTrainingWebString(item: Training?){
    item?.let{
        text = item.website
    }
}

@BindingAdapter("eventImageString")
fun ConstraintLayout.setEventImageString(item: Training?) {
    item?.let {
        background = ContextCompat.getDrawable(context, R.drawable.recycler3)
    }
}

