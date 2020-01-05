package com.example.partpartparttime.ui.register

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

class Register : Fragment() {
    // TODO: Rename and change types of parameters
//    private lateinit var loginViewModel: LoginViewModel
    private var username:String = ""
    private var password:String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login, container, false)

        //Database
//        val application = requireNotNull(this.activity).application
//        val dataSource = PartimeDatabase.getInstance(application).applicantDao

        binding.buttonApplicant.setOnClickListener{view ->

                    view.findNavController().
                        navigate(R.id.action_register_to_register_applicant)
        }

        binding.buttonCompany.setOnClickListener{view ->

            view.findNavController().
                navigate(R.id.action_register_to_register_company)
        }


        return binding.root
    }


}