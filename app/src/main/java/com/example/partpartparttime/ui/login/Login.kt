package com.example.partpartparttime.ui.login

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.partpartparttime.R
import com.example.partpartparttime.database.PartimeDatabase
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.partpartparttime.MainActivity.Companion.loggedUser
import com.example.partpartparttime.database.Applicant
import com.example.partpartparttime.databinding.FragmentLoginApplicantBinding
import com.example.partpartparttime.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login_applicant.*

class Login : Fragment() {
    // TODO: Rename and change types of parameters
//    private lateinit var loginViewModel: LoginViewModel
    private var username:String = ""
    private var password:String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        loginViewModel =
//            ViewModelProviders.of(this).get(LoginViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_login_applicant, container, false)
////        val textView: TextView = root.findViewById(R.id.login)
//        loginViewModel.text.observe(this, Observer {
////            textView.text = it
//        })

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login, container, false)

        //Database
//        val application = requireNotNull(this.activity).application
//        val dataSource = PartimeDatabase.getInstance(application).applicantDao

        binding.buttonApplicant.setOnClickListener{view ->

                    view.findNavController().
                        navigate(R.id.action_login_to_login_applicant)
        }

        binding.buttonCompany.setOnClickListener{view ->

            view.findNavController().
                navigate(R.id.action_login_to_loginCompany)
        }


        return binding.root
    }


}