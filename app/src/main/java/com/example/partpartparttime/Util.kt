package com.example.partpartparttime

import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.partpartparttime.database.Applicant
import com.example.partpartparttime.database.Company

//import com.example.potensituitionapp.database.Course
//import com.example.partpartparttime.database.Applicant

fun formatApplicants(applicants: List<Applicant>, resources: Resources): Spanned {
    val sb = StringBuilder()
    sb.apply {
        append(resources.getString(R.string.applicants))
        applicants.forEach {
            append("<br>")
            append(resources.getString(R.string.username))
            append("\t${(it.userName)}<br>")

            append(resources.getString(R.string.password))
            append("\t${(it.password)}<br>")

            append(resources.getString(R.string.user_id))
            append("\t${(it.userID)}<br>")

        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}

fun formatCompanys(companys: List<Company>, resources: Resources): Spanned {
    val sb = StringBuilder()
    sb.apply {
        append(resources.getString(R.string.companys))
        companys.forEach {
            append("<br>")
            append(resources.getString(R.string.username))
            append("\t${(it.userName)}<br>")

            append(resources.getString(R.string.password))
            append("\t${(it.password)}<br>")

            append(resources.getString(R.string.company_id))
            append("\t${(it.companyID)}<br>")

        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}

//fun formatCourses(courses: List<Course>, resources: Resources): Spanned {
//    val sb = StringBuilder()
//    sb.apply {
//        append(resources.getString(R.string.students))
//        courses.forEach {
//            append("<br>")
//            append("Course ID")
//            append("\t${(it.courseID)}<br>")
//
//            append("Course Name")
//            append("\t${(it.courseName)}<br>")
//        }
//    }
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
//    } else {
//        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
//    }
//}

class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView){

}

