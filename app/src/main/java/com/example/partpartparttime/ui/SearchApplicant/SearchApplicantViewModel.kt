package com.example.partpartparttime.ui.SearchApplicant

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.partpartparttime.MainActivity.Companion.categoryyyyy
import com.example.partpartparttime.database.ApplicantDao
import com.example.partpartparttime.database.CompanyDao
import com.example.partpartparttime.database.MatchDao
import com.example.partpartparttime.ui.SearchJob.SearchCompany

class SearchApplicantViewModel(val database: MatchDao,
                               application: Application, company_id : String, user_id: String, status: String
): AndroidViewModel(application)  {

    val getAppliedApplicant = database.getAppliedApplicant(company_id,user_id,status)

    private val _navigateToCompany = MutableLiveData<String>()
    val navigateToCompany get() =_navigateToCompany

    fun onEventClicked(id: String?) {
        _navigateToCompany.value = id
    }

    fun onEventNavigated() {
        _navigateToCompany.value = null
    }

}