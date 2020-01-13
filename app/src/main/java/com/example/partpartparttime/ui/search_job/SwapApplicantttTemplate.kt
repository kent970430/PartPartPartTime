package com.example.partpartparttime.ui.search_job


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
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentSwapApplicantTemplateBinding
import com.example.partpartparttime.databinding.FragmentSwapApplicantttttTemplateBinding
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class SwapApplicantttTemplate : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentSwapApplicantttttTemplateBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_swap_applicanttttt_template, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).matchDao
        val dataSource1 = PartimeDatabase.getInstance(application).historyApplicantDao
        val dataSource2 = PartimeDatabase.getInstance(application).applicantDao

        val arguement = SwapApplicantttTemplateArgs.fromBundle(arguments)

        var userid:String = arguement.userid

        var company_id = MainActivity.loggedUser

        var username = dataSource2.getApplicantID(userid)

        var firstname = username?.firstName

        var lastname = username?.lastName
        println(company_id)
        println(userid)

        binding.btndislike.setOnClickListener { view ->

            val abc= dataSource.getAppliedApplicant1(company_id,userid,"TRUE")

            abc?.companymatchuser = "FALSE"

            dataSource.update(abc)

            view.findNavController().navigate(R.id.action_swapApplicantttTemplate_to_historyCompanyFindApplicant)

        }


        binding.btnlike.setOnClickListener { view ->

            var abc = dataSource.getAppliedApplicant1(company_id,userid,"TRUE")

            if (abc != null) {
                abc.companymatchuser = "TRUE"

                dataSource.update(abc)


                var h : HistoryApplicant? = dataSource1.getAllHistoryss(userid)

                if (h == null) {

                }else {
                    h.status = "Interview"

                    dataSource1.update(h)

                    view.findNavController()
                        .navigate(R.id.action_swapApplicantttTemplate_to_historyCompanyFindApplicant)
                }
            }

        }


        return binding.root

    }


}
