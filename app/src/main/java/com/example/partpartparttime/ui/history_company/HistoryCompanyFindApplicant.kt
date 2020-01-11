package com.example.partpartparttime.ui.history_company


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.partpartparttime.R
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentHistoryCompanyFindApplicantBinding

/**
 * A simple [Fragment] subclass.
 */
class HistoryCompanyFindApplicant : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "History"

        val binding: FragmentHistoryCompanyFindApplicantBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_history_company_find_applicant,container,false)

        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).historyCompanyDao
        val viewModelFactory = HistoryCompanyFindApplicantViewModelFactory(dataSource, application)

        val historycViewModel =
            ViewModelProviders.of(
                this,viewModelFactory).get(HistoryCompanyFindApplicantViewModel::class.java)

        val adapter = HistoryCompanyFindApplicantAdapter(HistoryCListener { userIDDDD ->
            Toast.makeText(context,"${userIDDDD}", Toast.LENGTH_LONG).show()
            historycViewModel.onApplicantClicked(userIDDDD)
        })

        historycViewModel.historyyy.observe(viewLifecycleOwner, Observer{
            historycViewModel.historyyy.observe(viewLifecycleOwner, Observer{
                it?.let{
                    adapter.submitList(it)
                }
            })
        })

        binding.likedList.adapter = adapter

//        historycViewModel.navigateToCompany.observe(this,Observer{ iddd ->
//            iddd?.let{
//                this.findNavController().navigate{
//
//                }
//            }
//        })

        val lulu = GridLayoutManager(activity,2)

        binding.likedList.layoutManager = lulu

        binding.buttonCancelll.setOnClickListener{view->
//            view.findNavController().navigate(R.id)
        }

        return binding.root

    }


}
