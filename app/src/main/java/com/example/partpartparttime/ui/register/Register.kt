package com.example.partpartparttime.ui.register

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.partpartparttime.R
import com.example.partpartparttime.database.Applicant
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentRegisterBinding
import com.example.partpartparttime.ui.home.HomeViewModel


class Register : Fragment() {
    private lateinit var registerViewModel: RegisterViewModel

    private var username: String = ""
    private var password: String = ""
    private var firstname: String = ""
    private var lastname: String = ""
    private var email: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        (activity as AppCompatActivity).supportActionBar?.title = "Register"

        val binding: FragmentRegisterBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_register, container, false
        )
        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).applicantDao
        val viewModelFactory = RegisterViewModelFactory(dataSource, application)

        val loginViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(RegisterViewModel::class.java)

        binding.registerViewModel = loginViewModel

        binding.setLifecycleOwner(this)


        binding.buttonSignUp.setOnClickListener {view ->
            username = binding.textUserName.text.toString()
            password = binding.textPassword.text.toString()
            firstname = binding.textFirstName.text.toString()
            lastname = binding.textLastName.text.toString()
            email = binding.textEmail.text.toString()



            var appl = Applicant()


            appl.userName = username
            appl.password = password
            appl.email = email
            appl.firstName = firstname
            appl.lastName = lastname

            dataSource.insert(appl)
//            Log.i("hi","123")


            view.findNavController().navigate(R.id.action_register_to_login)
        }
        return binding.root
    }

}
