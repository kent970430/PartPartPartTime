package com.example.partpartparttime.ui.history_applicant


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
import com.example.partpartparttime.databinding.FragmentHistoryApplicantFindCompanyBinding
import kotlinx.android.synthetic.main.fragment_history_applicant_find_company.*


/**
 * A simple [Fragment] subclass.
 */
class HistoryApplicantFindCompany : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "History"

        val binding: FragmentHistoryApplicantFindCompanyBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_history_applicant_find_company, container,false)

        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).historyApplicantDao
        val viewModelFactory = HistoryApplicantFindCompanyViewModelFactory(dataSource, application)

        val historyViewModel =
            ViewModelProviders.of(
                this,viewModelFactory).get(HistoryApplicantFindCompanyViewModel::class.java)

        val adapter = HistoryApplicantFindCompanyAdapter(HistoryListener { companyName ->
            Toast.makeText(context,"${companyName}", Toast.LENGTH_LONG).show()
            historyViewModel.onCompanyClicked(companyName)
        })

        historyViewModel.historyyy.observe(viewLifecycleOwner, Observer{
            historyViewModel.historyyy.observe(viewLifecycleOwner, Observer{
                it?.let{
                    adapter.submitList(it)
                }
            })
        })

        binding.historyyList.adapter = adapter

//        historyViewModel.navigateToCompany.observe(this,Observer{ iddd ->
//            iddd?.let{
//                this.findNavController().navigate{
//
//                }
//            }
//        })

        val hihi = GridLayoutManager(activity,2)

        binding.historyyList.layoutManager = hihi

//        binding.buttonCancelll.setOnClickListener { view ->
//            view.findNavController().navigate(R.id.action_events_to_addEventsFragment)
//        }

        return binding.root

    }


}
