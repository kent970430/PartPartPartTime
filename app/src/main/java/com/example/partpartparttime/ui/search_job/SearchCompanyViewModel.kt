package com.example.partpartparttime.ui.search_job

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.partpartparttime.database.CompanyDao
import com.example.partpartparttime.ui.search_job.SearchCompany.Companion.categoryyyyy

class SearchCompanyViewModel(val database: CompanyDao,
                             application: Application,categoryyy : String = categoryyyyy
): AndroidViewModel(application)  {

    val companies = database.getAllCompanys()

    val company_category = database.getCompanyCategory(categoryyy)

    private val _navigateToCompany = MutableLiveData<String>()
    val navigateToCompany get() =_navigateToCompany

    fun onEventClicked(id: String?) {
        _navigateToCompany.value = id
    }

    fun onEventNavigated() {
        _navigateToCompany.value = null
    }
}