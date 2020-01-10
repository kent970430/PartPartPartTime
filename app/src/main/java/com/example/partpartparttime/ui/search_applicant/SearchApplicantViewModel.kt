package com.example.partpartparttime.ui.search_applicant

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.partpartparttime.database.MatchDao

class SearchApplicantViewModel(val database: MatchDao,
                               application: Application, company_id : String, user_id: String, status: String
): AndroidViewModel(application)  {

    val getAppliedApplicant = database.getAppliedApplicant(company_id,user_id,status)

    private val _navigateToCompany = MutableLiveData<String>()
    val navigateToCompany get() =_navigateToCompany

    fun onMatchClicked(id: String?) {
        _navigateToCompany.value = id
    }

    fun onMatchNavigated() {
        _navigateToCompany.value = null
    }

}