package com.example.partpartparttime.ui.search_applicant


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.R
import com.example.partpartparttime.database.HistoryApplicant
import com.example.partpartparttime.database.HistoryCompany
import com.example.partpartparttime.database.Match
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentSwapApplicantTemplateBinding
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class SwapApplicantTemplate : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentSwapApplicantTemplateBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_swap_applicant_template, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).matchDao
        val dataSource1 = PartimeDatabase.getInstance(application).historyCompanyDao
        val dataSource2 = PartimeDatabase.getInstance(application).applicantDao
        val dataSourceeee = PartimeDatabase.getInstance(application).companyDao

        val arguement = SwapApplicantTemplateArgs.fromBundle(arguments)

        var userid:String = arguement.userid

        var company_id = MainActivity.loggedUser

        var username = dataSource2.getApplicantID(userid)

        var firstname = username?.firstName

        var lastname = username?.lastName

        var companyName = dataSourceeee.getCompanyID(company_id)



        binding.btndislike.setOnClickListener { view ->

            var abc = dataSource.getAppliedApplicant1(company_id,userid,"FALSE")

            if (abc != null){

                abc?.companymatchuser="FALSE"

                dataSource.update(abc)

            } else {

                var m: Match = Match()

                m.companyID = company_id
                m.userID = userid
                m.companymatchuser = "FALSE"

                dataSource.insert(m)

            }

            var h: HistoryCompany = HistoryCompany()

            h.userID = userid
            h.companyID = company_id
            h.firstName = firstname
            h.lastName = lastname
            h.history_comID = UUID.randomUUID().toString()
            h.companyName = companyName?.companyName.toString()
            h.status = "dislike"

            dataSource1.insert(h)

            view.findNavController().navigate(R.id.action_swapApplicantTemplate_to_historyCompanyFindApplicant)

        }


        binding.btnlike.setOnClickListener { view ->



            var abc = dataSource.getAppliedApplicant1(company_id,userid,"TRUE")

            if (abc != null){

                abc?.companymatchuser="TRUE"

                dataSource.update(abc)

            } else {

                var m: Match = Match()

                m.companyID = company_id
                m.userID = userid
                m.companymatchuser = "TRUE"

                dataSource.insert(m)

            }




            var h: HistoryCompany = HistoryCompany()

            h.userID = userid
            h.companyID = company_id
            h.firstName = firstname
            h.lastName = lastname
            h.history_comID = UUID.randomUUID().toString()
            h.companyName = companyName?.companyName.toString()
            h.status = "pending"

            dataSource1.insert(h)

            view.findNavController().navigate(R.id.action_swapApplicantTemplate_to_historyCompanyFindApplicant)

        }


        return binding.root

    }


}
