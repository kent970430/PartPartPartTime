package com.example.partpartparttime.ui.SearchApplicant


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.R
import com.example.partpartparttime.database.Match
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentSwapApplicantTemplateBinding

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

        val arguement = SwapApplicantTemplateArgs.fromBundle(arguments)

        var userid:String = arguement.userid

        var company_id = MainActivity.loggedUser

        binding.btndislike.setOnClickListener { view ->

            val abc= dataSource.getAppliedApplicant1(company_id,userid,"TRUE")

            abc?.companymatchuser = "FALSE"

            dataSource.update(abc!!)

        }


        binding.btnlike.setOnClickListener { view ->

            var abc = dataSource.getAppliedApplicant1(company_id,userid,"TRUE")

            abc?.companymatchuser="TRUE"

            dataSource.update(abc!!)

        }


        return binding.root

    }


}
