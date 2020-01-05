package com.example.partpartparttime.ui.company_profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.R
import com.example.partpartparttime.databinding.FragmentCompanyBinding

class CompanyFragment : Fragment() {

    private lateinit var companyViewModel: CompanyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCompanyBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_company, container, false
        )

//        val application = requireNotNull(this.activity).application
//        val dataSource = PartimeDatabase.getInstance(application).applicantDao

//        textUserName.text = loggedUser

        binding.buttonLogOut.setOnClickListener{view ->
//            Log.i("Result", MainActivity.loggedUser)
            Toast.makeText(activity, R.string.logout_success, Toast.LENGTH_SHORT).show()

            MainActivity.loggedUser = ""

            Log.i("Result", "Successfully logged out")


            view.findNavController().navigate(R.id.action_companyFragment_to_nav_home)
        }
        return binding.root
    }
}