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
import com.example.partpartparttime.database.Match
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentSwapCompanyTemplateBinding

/**
 * A simple [Fragment] subclass.
 */
class SwapComapanyTemplate : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSwapCompanyTemplateBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_swap_company_template, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).matchDao

        val arguement = SwapComapanyTemplateArgs.fromBundle(arguments)

        var compid:String = arguement.compid

        val application1 = requireNotNull(this.activity).application
        val dataSource1 = PartimeDatabase.getInstance(application1).companyDao

        var company = dataSource1.getCompanyID(compid)

        println(company)

        var user_id = MainActivity.loggedUser

        binding.btndislike.setOnClickListener { view ->


            var m:Match = Match()

            m.companyID = compid
            m.userID = user_id
            m.usermatchcompany = "FALSE"

            dataSource.insert(m)

            view.findNavController().navigate(R.id.action_swapComapanyTemplate_to_historyFindJob)
        }


        binding.btnlike.setOnClickListener { view ->



            var m:Match = Match()

            m.companyID = compid
            m.userID = user_id
            m.usermatchcompany = "TRUE"

            dataSource.insert(m)

            view.findNavController().navigate(R.id.action_swapComapanyTemplate_to_historyFindJob)

        }




        return binding.root

    }


}
