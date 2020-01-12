package com.example.partpartparttime.ui.search_applicant

import android.content.Context
import android.net.Uri
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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.partpartparttime.MainActivity.Companion.categoryyyyy

import com.example.partpartparttime.R
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentSearchApplicantBinding
import com.example.partpartparttime.databinding.FragmentSwapApplicantTemplateBinding
import com.example.partpartparttime.ui.search_job.MatchListener

class SearchApplicantFragment : Fragment() {
    companion object {

    }
    var x : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding:FragmentSearchApplicantBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_search_applicant, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).applicantDao
        var category: Array<String> =
            arrayOf("IT", "Marketing", "Business", "Interior Design", "Finance")
        var adapterCategory = ArrayAdapter(this.context!!,android.R.layout.simple_list_item_1,category)
        binding.spinnerCategory.adapter = adapterCategory
        binding.spinnerCategory.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    x = position
                    val categories = category[x]
                    categoryyyyy = categories
                    println("clicked: " + categoryyyyy)
                }
            }
        val viewModelFactory = SearchApplicantViewModelFactory(dataSource, application, categoryyyyy)

        val serchApplicantViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(SearchApplicantViewModel::class.java)

        val adapter = SearchApplicantAdapter(com.example.partpartparttime.ui.search_applicant.MatchListener{ user_id ->
            Toast.makeText(context,"${user_id}",Toast.LENGTH_LONG).show()
            serchApplicantViewModel.onEventClicked(user_id)
        })

        serchApplicantViewModel.applicants.observe(viewLifecycleOwner, Observer {
            serchApplicantViewModel.applicants.observe(viewLifecycleOwner, Observer{
                it?.let {
                    adapter.submitList(it)
                }
            })
        })

        binding.applicantList.adapter = adapter




        binding.buttonSearch.setOnClickListener {

            //           val category = binding.spinnerCategory.selectedItem.toString()
//            categoryyyyy = category

            serchApplicantViewModel.applicant_category.observe(viewLifecycleOwner, Observer {
                serchApplicantViewModel.applicant_category.observe(viewLifecycleOwner, Observer{
                    it?.let {
                        adapter.submitList(it)
                    }
                })
            })

        }

        serchApplicantViewModel.navigateToApplicant.observe(this, Observer { iddd ->
            iddd?.let {

                this.findNavController().navigate(
                    SearchApplicantFragmentDirections
                        .actionSearchApplicantToSwapApplicantTemplate(iddd))
                serchApplicantViewModel.onEventNavigated()

                Log.i("idddd",iddd)

            }
        })

        return binding.root
    }
}
