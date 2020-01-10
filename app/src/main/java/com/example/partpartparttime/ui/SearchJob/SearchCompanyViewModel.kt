package com.example.partpartparttime.ui.SearchJob

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.partpartparttime.MainActivity.Companion.categoryyyyy
import com.example.partpartparttime.database.CompanyDao
import com.example.partpartparttime.ui.SearchJob.SearchCompany

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