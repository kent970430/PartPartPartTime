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
import com.example.partpartparttime.MainActivity.Companion.loggedUser
import com.example.partpartparttime.MainActivity.Companion.name
import com.example.partpartparttime.R
import com.example.partpartparttime.database.Company
import com.example.partpartparttime.database.PartimeDatabase
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
        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).companyDao

        var comp: Company? = dataSource.getCompanyID(loggedUser)

        if (comp == null) {
            Toast.makeText(activity, R.string.login_failed, Toast.LENGTH_SHORT).show()
            Log.i("Result", "No user found")
        } else {
            val name: TextView = binding.root.findViewById(R.id.textName)
            name.setText(comp.companyName)

            val email: TextView = binding.root.findViewById(R.id.textEmaill)
            email.setText(comp.email)

            val headName: TextView = this.getActivity()!!.findViewById(R.id.head_name)
            headName.setText(MainActivity.name)
            val headEmail: TextView = this.getActivity()!!.findViewById(R.id.head_email)
            headEmail.setText(comp.email)

        }

        binding.buttonLogOut.setOnClickListener { view ->
            //            Log.i("Result", MainActivity.loggedUser)
            Toast.makeText(activity, R.string.logout_success, Toast.LENGTH_SHORT).show()

            loggedUser = ""
            name = ""
            val headName: TextView = this.getActivity()!!.findViewById(R.id.head_name)
            headName.setText("")
            val headEmail: TextView = this.getActivity()!!.findViewById(R.id.head_email)
            headEmail.setText("")

            Log.i("Result", "Successfully logged out")


            view.findNavController().navigate(R.id.action_companyFragment_to_nav_home)
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