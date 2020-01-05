package com.example.partpartparttime.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.partpartparttime.R
import com.example.partpartparttime.database.Company
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentRegisterCompanyBinding
import java.util.*


class RegisterCompany : Fragment() {
    private lateinit var registerCompanyViewModel: RegisterCompanyViewModel

    private var username: String = ""
    private var password: String = ""
    private var companyname: String = ""
    private var email: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        (activity as AppCompatActivity).supportActionBar?.title = "Register"

        val binding: FragmentRegisterCompanyBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_register_company, container, false
        )
        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).companyDao
        val viewModelFactory = RegisterCompanyViewModelFactory(dataSource, application)

        val loginCompanyViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(RegisterCompanyViewModel::class.java)

        binding.registerCompanyViewModel = loginCompanyViewModel

        binding.setLifecycleOwner(this)


        binding.buttonSignUp.setOnClickListener {view ->
            username = binding.textUserName.text.toString()
            password = binding.textPassword.text.toString()
            companyname = binding.textCompanyName.text.toString()
            email = binding.textEmail.text.toString()



            var comp = Company()


            comp.userName = username
            comp.password = password
            comp.email = email
            comp.companyName = companyname
            comp.companyID = UUID.randomUUID().toString()

            dataSource.insert(comp)
//            Log.i("hi","123")


            view.findNavController().navigate(R.id.action_registerCompany_to_login_company)
        }

        binding.buttonCancel.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_register_company_to_nav_home)
        }
        return binding.root
    }

}
