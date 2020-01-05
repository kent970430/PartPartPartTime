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
import com.example.partpartparttime.database.Applicant
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentRegisterApplicantBinding
import java.util.*


class RegisterApplicant : Fragment() {
    private lateinit var registerApplicantViewModel: RegisterApplicantViewModel

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

        val binding: FragmentRegisterApplicantBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_register_applicant, container, false
        )
        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).applicantDao
        val viewModelFactory = RegisterApplicantViewModelFactory(dataSource, application)

        val loginApplicantViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(RegisterApplicantViewModel::class.java)

        binding.registerApplicantViewModel = loginApplicantViewModel

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
            appl.userID = UUID.randomUUID().toString()

            dataSource.insert(appl)


            view.findNavController().navigate(R.id.action_register_applicant_to_login_applicant)
        }
        return binding.root
    }

}
