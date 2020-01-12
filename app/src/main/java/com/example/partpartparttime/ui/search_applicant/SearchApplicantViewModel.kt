package com.example.partpartparttime.ui.search_applicant

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.partpartparttime.database.ApplicantDao

class SearchApplicantViewModel(val database: ApplicantDao,
                               application: Application
): AndroidViewModel(application)  {

    val applicants = database.getAllApplicants()

    val applicant_category = database.getApplicantCategory("")

    private val _navigateToApplicant = MutableLiveData<String>()
    val navigateToApplicant get() =_navigateToApplicant

    fun onEventClicked(id: String?) {
        _navigateToApplicant.value = id
    }

    fun onEventNavigated() {
        _navigateToApplicant.value = null
    }

}