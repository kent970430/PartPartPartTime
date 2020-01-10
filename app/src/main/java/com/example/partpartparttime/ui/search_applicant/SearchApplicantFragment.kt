package com.example.partpartparttime.ui.search_applicant


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.partpartparttime.R
import com.example.partpartparttime.database.PartimeDatabase
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.databinding.FragmentSearchApplicantBinding


/**
 * A simple [Fragment] subclass.
 */
class SearchApplicantFragment : Fragment() {

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

        val viewModelFactory = SearchApplicantViewModelFactory(dataSource, application, company_id, user_id?.userID!!, "TRUE")

        val searchApplicantViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(SearchApplicantViewModel::class.java)

        val adapter = SearchApplicantAdapter(MatchListener{ user_id ->
            Toast.makeText(context,"${user_id}", Toast.LENGTH_LONG).show()
            searchApplicantViewModel.onMatchClicked(user_id)
        })


        searchApplicantViewModel.getAppliedApplicant.observe(viewLifecycleOwner, Observer {
            searchApplicantViewModel.getAppliedApplicant.observe(viewLifecycleOwner, Observer{
                it?.let{
                    adapter.submitList(it)
                }
            })
        })

        binding.companyList.adapter = adapter



        searchApplicantViewModel.navigateToCompany.observe(this, Observer { iddd ->
            iddd?.let {

                this.findNavController().navigate(
                    SearchApplicantFragmentDirections
                        .actionSearchApplicantToSwapApplicantTemplate(iddd))
                searchApplicantViewModel.onMatchNavigated()

                Log.i("idddd",iddd)

            }
        })

        val aaa = GridLayoutManager(activity, 1)

        binding.companyList.layoutManager = aaa

        return binding.root
    }


}
