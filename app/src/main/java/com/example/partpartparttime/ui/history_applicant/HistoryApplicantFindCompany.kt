package com.example.partpartparttime.ui.history_applicant


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.MainActivity.Companion.loggedUser
import com.example.partpartparttime.R
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentHistoryApplicantFindCompanyBinding
import com.example.partpartparttime.ui.events.EventFragmentDirections
import com.example.partpartparttime.ui.home.HomeFragmentDirections
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

        val binding: FragmentHistoryApplicantFindCompanyBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_history_applicant_find_company, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).historyApplicantDao

        val user_id = MainActivity.loggedUser

        val viewModelFactory =
            HistoryApplicantFindCompanyViewModelFactory(dataSource, application, user_id)

        val dataSource11 = PartimeDatabase.getInstance(application).historyCompanyDao
        val viewModelFactory11 =
            HistoryApplicantViewCompanySelectViewModelFactory(dataSource11, application, user_id)

        val historyViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(HistoryApplicantFindCompanyViewModel::class.java)


        val historyViewModel11 =
            ViewModelProviders.of(
                this, viewModelFactory11
            ).get(HistoryApplicantViewCompanySelectViewModel::class.java)

        val adapter = HistoryApplicantFindCompanyAdapter(HistoryListener { companyID ->
            Toast.makeText(context, "${companyID}", Toast.LENGTH_LONG).show()
            historyViewModel.onCompanyClicked(companyID)
        })

        val adapter11 = HistoryApplicantViewCompanySelectAdapter(CompanychooseListener { hihi ->
            Toast.makeText(context, "${hihi}", Toast.LENGTH_LONG).show()
            historyViewModel11.onApplicantClicked(hihi)
        })

        historyViewModel.historyyy.observe(viewLifecycleOwner, Observer {
            historyViewModel.historyyy.observe(viewLifecycleOwner, Observer {
                it?.let {
                    adapter.submitList(it)
                }
            })
        })

        historyViewModel11.historyyy.observe(viewLifecycleOwner, Observer {
            historyViewModel11.historyyy.observe(viewLifecycleOwner, Observer {
                it?.let {
                    adapter11.submitList(it)
                }
            })
        })

        binding.historyyList.adapter = adapter
        binding.historyyCompanyChooseUList.adapter = adapter11

        historyViewModel.navigateToCompany.observe(this, Observer { iddd ->
            iddd?.let {
                this.findNavController().navigate(
                    HistoryApplicantFindCompanyDirections.actionHistoryApplicantFindCompanyToCompanysssss(
                        iddd
                    )
                )
                historyViewModel.onCompanyNavigated()

                Log.i("idddd", iddd)
            }
        })

        historyViewModel11.navigateToCompany.observe(this, Observer { iii ->
            iii?.let {
                val a: TextView = activity!!.findViewById(R.id.applselectcompanystatus)
                if (a.text == "pending") {
                    this.findNavController().navigate(
                        HistoryApplicantFindCompanyDirections.actionHistoryApplicantFindCompanyToSwapCompanyyyTemplate(
                            iii
                        )
                    )
                } else {
                    this.findNavController().navigate(
                        HistoryApplicantFindCompanyDirections.actionHistoryApplicantFindCompanyToCompanysssss(
                            iii
                        )
                    )
                }
            }
        })

        val hihi = GridLayoutManager(activity, 2)

        binding.historyyList.layoutManager = hihi

        val aa = GridLayoutManager(activity, 2)

        binding.historyyCompanyChooseUList.layoutManager = aa

        binding.buttonCancelll.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_historyApplicantFindCompany_to_nav_home)
        }

        return binding.root

    }


}
