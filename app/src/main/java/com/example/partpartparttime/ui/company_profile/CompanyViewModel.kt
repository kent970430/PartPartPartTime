package com.example.partpartparttime.ui.company_profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.partpartparttime.database.CompanyDao

class CompanyViewModel(private val company_ID:String,
                        val database: CompanyDao,
                        application: Application
): AndroidViewModel(application){
    private val _navigateToCompany = MutableLiveData<Int>()
    val navigateToCompany
        get() = _navigateToCompany

    val chapters = database.getAllCompanys()

    fun onCompanyClicked(num: Int) {
        _navigateToCompany.value = num
    }

    fun onCompanyNavigated() {
        _navigateToCompany.value = null
    }
}