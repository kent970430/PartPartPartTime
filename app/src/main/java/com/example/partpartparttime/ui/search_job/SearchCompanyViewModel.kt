package com.example.partpartparttime.ui.search_job

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.partpartparttime.database.CompanyDao

class SearchCompanyViewModel(val database: CompanyDao,
                             application: Application,categoryyyyy : String
): AndroidViewModel(application)  {

    val companies = database.getAllCompanys()

    val company_category = database.getCompanyCategory(categoryyyyy)

    private val _navigateToCompany = MutableLiveData<String>()
    val navigateToCompany get() =_navigateToCompany

    fun onEventClicked(id: String?) {
        _navigateToCompany.value = id
    }

    fun onEventNavigated() {
        _navigateToCompany.value = null
    }
}