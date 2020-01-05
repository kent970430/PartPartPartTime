package com.example.partpartparttime.ui.applicant_profile

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
import com.example.partpartparttime.database.Applicant
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentApplicantBinding
import com.example.partpartparttime.MainActivity.Companion.loggedUser
import com.example.partpartparttime.MainActivity.Companion.name

class ApplicantFragment : Fragment() {

    private lateinit var applicantViewModel: ApplicantViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentApplicantBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_applicant, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).applicantDao

        var appl: Applicant? = dataSource.getApplicantID(loggedUser)

        if (appl == null) {
            Toast.makeText(activity, R.string.login_failed, Toast.LENGTH_SHORT).show()
            Log.i("Result", "No user found")
        } else {
            val name: TextView = binding.root.findViewById(R.id.textName)
            name.setText(appl.firstName + appl.lastName)

            val email: TextView = binding.root.findViewById(R.id.textEmaill)
            email.setText(appl.email)

            val headName: TextView = this.getActivity()!!.findViewById(R.id.head_name)
            headName.setText(MainActivity.name)
            val headEmail: TextView = this.getActivity()!!.findViewById(R.id.head_email)
            headEmail.setText(appl.email)

        }

        binding.buttonLogOut.setOnClickListener { view ->
            //            Log.i("Result", MainActivity.loggedUser)
            Toast.makeText(activity, R.string.logout_success, Toast.LENGTH_SHORT).show()

            loggedUser = ""
            name = ""

            Log.i("Result", "Successfully logged out")


            view.findNavController().navigate(R.id.action_applicantFragment_to_nav_home)
        }

        binding.buttonEdit.setOnClickListener { view ->
            //            Log.i("Result", MainActivity.loggedUser)
            Toast.makeText(activity, R.string.logout_success, Toast.LENGTH_SHORT).show()


//            view.findNavController().navigate(R.id.action_applicantFragment_to_nav_home)
        }

        binding.buttonSave.setOnClickListener { view ->
            //            Log.i("Result", MainActivity.loggedUser)
            Toast.makeText(activity, R.string.logout_success, Toast.LENGTH_SHORT).show()


//            view.findNavController().navigate(R.id.action_applicantFragment_to_nav_home)
        }
        return binding.root
    }
}