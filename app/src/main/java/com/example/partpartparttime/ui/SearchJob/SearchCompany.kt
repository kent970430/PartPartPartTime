package com.example.partpartparttime.ui.SearchJob


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.example.partpartparttime.R
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentSearchCompanyBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.partpartparttime.MainActivity.Companion.categoryyyyy
import com.example.partpartparttime.ui.events.EventFragmentDirections
import kotlinx.android.synthetic.main.list_event.*


/**
 * A simple [Fragment] subclass.
 */
class SearchCompany : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentSearchCompanyBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_search_company, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).companyDao

        val viewModelFactory = SearchCompanyViewModelFactory(dataSource, application, categoryyyyy)

        val searchCompanyViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(SearchCompanyViewModel::class.java)

        val adapter = SearchCompanyAdapter()

        binding.companyList.adapter = adapter

        searchCompanyViewModel.companies.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        var category: Array<String> =
            arrayOf("IT", "Marketing", "Business", "Interior Design", "Finance")
        var adapterCategory = ArrayAdapter(this.context!!,android.R.layout.simple_list_item_1,category)
        binding.spinnerCategory.adapter = adapterCategory


        binding.buttonSearch.setOnClickListener {

           val category = binding.spinnerCategory.selectedItem.toString()
            categoryyyyy = category

            searchCompanyViewModel.company_category.observe(viewLifecycleOwner, Observer {
                it?.let {
                    adapter.data = it
                }
            })

        }

        searchCompanyViewModel.navigateToCompany.observe(this, Observer { iddd ->
            iddd?.let {

                this.findNavController().navigate(
                    SearchCompanyDirections
                        .actionSearchCompanyToSwapComapanyTemplate(iddd))
                searchCompanyViewModel.onEventNavigated()

                Log.i("idddd",iddd)

            }
        })

        return binding.root
    }


}
