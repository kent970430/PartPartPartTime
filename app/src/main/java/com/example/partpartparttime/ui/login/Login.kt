package com.example.partpartparttime.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.partpartparttime.R

class Login : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginViewModel =
            ViewModelProviders.of(this).get(LoginViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_login, container, false)
//        val textView: TextView = root.findViewById(R.id.login)
        loginViewModel.text.observe(this, Observer {
//            textView.text = it
        })
        return root
    }
}
