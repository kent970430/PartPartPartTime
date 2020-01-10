package com.example.partpartparttime.ui.SearchJob

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.partpartparttime.database.CompanyDao

class SearchCompanyViewModelFactory(private val dataSource: CompanyDao,
                                    private val application: Application, val categoryyyyy:String
) : ViewModelProvider.Factory  {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchCompanyViewModel::class.java)) {
            return SearchCompanyViewModel(dataSource,application,categoryyyyy) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}