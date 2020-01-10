package com.example.partpartparttime.ui.login

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import com.example.partpartparttime.R
import com.example.partpartparttime.database.PartimeDatabase
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.MainActivity.Companion.loggedUser
import com.example.partpartparttime.MainActivity.Companion.name
import com.example.partpartparttime.database.Applicant
import com.example.partpartparttime.databinding.FragmentLoginApplicantBinding
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_login_applicant.*
import kotlinx.android.synthetic.main.fragment_login_company.view.*

class LoginApplicant : Fragment() {
    private var username:String = ""
    private var password:String = ""
    lateinit var sharedPreferences: SharedPreferences
    lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentLoginApplicantBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login_applicant, container, false)

        //Database
        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).applicantDao

        //sharePreferences
//        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
//        sharedPreferences = this.getActivity()!!.getPreferences(Context.MODE_PRIVATE)

        binding.buttonLogin.setOnClickListener{view ->

            username = textUserName.text.toString()
            password = textPassword.text.toString()

            this.hideKeyboard()

            var appl: Applicant? = dataSource.getApplicant(username)

            if(appl == null){
                Toast.makeText(activity, R.string.login_failed, Toast.LENGTH_SHORT).show()
                Log.i("Result","No user found")
            }
            else{
                if(appl.password.equals(password)){
                    Toast.makeText(activity, R.string.login_success, Toast.LENGTH_SHORT).show()

                    loggedUser = appl.userID.toString()
                    name = appl.firstName+appl.lastName
//                    loginViewModel.nav_header_title = name
//                    loginViewModel.nav_header_subtitle = appl.email

                    Log.i("Result","Successfully logged in")

                    val navView : NavigationView = activity!!.findViewById(R.id.nav_view)

                    navView.menu.getItem(5).isVisible = false




                    view.findNavController().
                        navigate(R.id.action_login_to_applicantFragment)

                }

                else{
                    Toast.makeText(activity, R.string.login_failed, Toast.LENGTH_SHORT).show()

                    Log.i("Result","Invalid password")
                }
            }
        }

        binding.buttonCancel.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_login_applicant_to_nav_home)
        }

        binding.buttonSignUp.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_login_applicant_to_register)
        }

        return binding.root
    }



    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }


}