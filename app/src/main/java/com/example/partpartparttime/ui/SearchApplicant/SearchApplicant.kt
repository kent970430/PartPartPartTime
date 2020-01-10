package com.example.partpartparttime.ui.SearchApplicant


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
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.MainActivity.Companion.categoryyyyy
import com.example.partpartparttime.databinding.FragmentSearchApplicantBinding
import com.example.partpartparttime.databinding.FragmentSwapApplicantTemplateBinding


/**
 * A simple [Fragment] subclass.
 */
class SearchApplicant : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentSearchApplicantBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_search_applicant, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).matchDao

        var company_id = MainActivity.loggedUser

        var user_id = dataSource.getUserId(company_id)

        val viewModelFactory = SearchApplicantViewModelFactory(dataSource, application, company_id, user_id!!.userID!!, "TRUE")

        val searchApplicantViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(SearchApplicantViewModel::class.java)

        val adapter = SearchApplicantAdapter()

        binding.companyList.adapter = adapter

        searchApplicantViewModel.getAppliedApplicant.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })


        searchApplicantViewModel.navigateToCompany.observe(this, Observer { iddd ->
            iddd?.let {

                this.findNavController().navigate(
                    SearchApplicantDirections
                        .actionSearchApplicantToSwapApplicantTemplate(iddd))
                searchApplicantViewModel.onEventNavigated()

                Log.i("idddd",iddd)

            }
        })

        return binding.root
    }


}
