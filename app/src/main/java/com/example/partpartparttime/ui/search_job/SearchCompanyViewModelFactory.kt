package com.example.partpartparttime.ui.search_job

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.partpartparttime.MainActivity.Companion.categoryyyyy
import com.example.partpartparttime.database.CompanyDao

class SearchCompanyViewModelFactory(private val dataSource: CompanyDao,
                                    private val application: Application, val categoryyy:String = categoryyyyy
) : ViewModelProvider.Factory  {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchCompanyViewModel::class.java)) {
            return SearchCompanyViewModel(dataSource,application,categoryyy) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}