package com.example.partpartparttime.ui.search_job


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.partpartparttime.R
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentSearchCompanyBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.partpartparttime.MainActivity.Companion.categoryyyyy


/**
 * A simple [Fragment] subclass.
 */
class SearchCompany : Fragment() {

    companion object {
//        var categoryyyyy : String = ""
    }
    var x : Int = 0

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
        var category: Array<String> =
            arrayOf("IT", "Marketing", "Business", "Interior Design", "Finance")
        var adapterCategory = ArrayAdapter(this.context!!,android.R.layout.simple_list_item_1,category)
//        binding.spinnerCategory.adapter = adapterCategory
//        binding.spinnerCategory.onItemSelectedListener =
//            object : AdapterView.OnItemSelectedListener {
//                override fun onNothingSelected(parent: AdapterView<*>?) {
//                }
//
//                override fun onItemSelected(
//                    parent: AdapterView<*>?,
//                    view: View?,
//                    position: Int,
//                    id: Long
//                ) {
//                    x = position
//                    val categories = category[x]
//                    categoryyyyy = categories
//                    println("clicked: " + categoryyyyy)
//                }
//            }
        val viewModelFactory = SearchCompanyViewModelFactory(dataSource, application, categoryyyyy)

        val serchCompanyViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(SearchCompanyViewModel::class.java)

        val adapter = SearchCompanyAdapter(MatchListener{company_id ->
            Toast.makeText(context,"${company_id}",Toast.LENGTH_LONG).show()
            serchCompanyViewModel.onEventClicked(company_id)
        })

        serchCompanyViewModel.companies.observe(viewLifecycleOwner, Observer {
            serchCompanyViewModel.companies.observe(viewLifecycleOwner, Observer{
                it?.let {
                    adapter.submitList(it)
                }
            })
        })

        binding.companyList.adapter = adapter




//        binding.buttonSearch.setOnClickListener {
//
////           val category = binding.spinnerCategory.selectedItem.toString()
////            categoryyyyy = category
//
//            serchCompanyViewModel.company_category.observe(viewLifecycleOwner, Observer {
//                serchCompanyViewModel.company_category.observe(viewLifecycleOwner, Observer{
//                    it?.let {
//                        adapter.submitList(it)
//                    }
//                })
//            })
//
//        }

        serchCompanyViewModel.navigateToCompany.observe(this, Observer { iddd ->
            iddd?.let {

                this.findNavController().navigate(
                    SearchCompanyDirections
                        .actionSearchCompanyToSwapComapanyTemplate(iddd))
                serchCompanyViewModel.onEventNavigated()

                Log.i("idddd",iddd)

            }
        })

        return binding.root
    }


}
