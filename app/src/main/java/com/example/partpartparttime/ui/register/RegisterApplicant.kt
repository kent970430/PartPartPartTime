package com.example.partpartparttime.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
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

    private var username: String? = null
    private var password: String? = null
    private var firstname: String? = null
    private var lastname: String? = null
    private var email: String? = null

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

        var category: Array<String> =
            arrayOf("IT", "Marketing", "Business", "Interior Design", "Finance")
        var adapterCategory = ArrayAdapter(this.context!!,android.R.layout.simple_list_item_1,category)
        binding.spinnerCategory.adapter = adapterCategory


        binding.buttonSignUp.setOnClickListener {view ->

            if(binding.textUserName.text.toString() == ""){
                Toast.makeText(activity, "Please key in User Name!!!", Toast.LENGTH_SHORT).show()
            }else if(binding.textPassword.text.toString() == ""){
                Toast.makeText(activity, "Please key in Password!!!", Toast.LENGTH_SHORT).show()
            }else if(binding.textFirstName.text.toString() == "") {
                Toast.makeText(activity, "Please key in First Name!!!", Toast.LENGTH_SHORT).show()
            }else if(binding.textLastName.text.toString() == "") {
                Toast.makeText(activity, "Please key in Last Name!!!", Toast.LENGTH_SHORT).show()
            }else if(binding.textEmail.text.toString() == "") {
                Toast.makeText(activity, "Please key in Email!!!", Toast.LENGTH_SHORT).show()
            }else {
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
                appl.category = binding.spinnerCategory.selectedItem.toString()

                dataSource.insert(appl)
                Toast.makeText(activity, "Successfully Register!!", Toast.LENGTH_SHORT).show()
                view.findNavController().navigate(R.id.action_register_applicant_to_login_applicant)
            }

        }

        binding.buttonCancel.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_register_applicant_to_nav_home)
        }
        return binding.root
    }

}
