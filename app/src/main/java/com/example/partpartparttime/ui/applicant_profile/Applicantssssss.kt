package com.example.partpartparttime.ui.applicant_profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.R
import com.example.partpartparttime.database.Applicant
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentApplicantssssssBinding
import kotlinx.android.synthetic.main.list_applicant.view.*

class Applicantssssss : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentApplicantssssssBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_applicantssssss, container, false
        )
        val application = requireNotNull(this.activity).application
        val arguments = ApplicantssssssArgs.fromBundle(arguments)
        val user_ID = arguments.userId

        val dataSource = PartimeDatabase.getInstance(application).applicantDao

        var appl: Applicant? = dataSource.getApplicantID(user_ID)

//        var evenn = EventFragment()
//        var userss = evenn.users
//        var comp1: Company? = dataSource.getCompanyID(userss)

        //if(userss == loggedUser) {
        if (appl == null) {
            Toast.makeText(activity, R.string.get_failed, Toast.LENGTH_SHORT).show()
            Log.i("Result", "No applicant found")
        } else {
            val name: EditText = binding.root.findViewById(R.id.textName)
            name.setText(appl.firstName + appl.lastName)

            val email: EditText = binding.root.findViewById(R.id.textEmaill)
            email.setText(appl.email)

            val contact: EditText = binding.root.findViewById(R.id.textDescription)
            contact.setText(appl.contact)

            val experince: EditText = binding.root.findViewById(R.id.textDescription1)
            experince.setText(appl.experince)

            val skill: EditText = binding.root.findViewById(R.id.textDescription2)
            skill.setText(appl.skill)

            val education: EditText = binding.root.findViewById(R.id.textDescription3)
            education.setText(appl.education)

            val image: ImageView = binding.root.findViewById(R.id.imageViewPreview2)
            val imageV = appl.image.toString().toUri()
            image.setImageURI(imageV)

            val headName: TextView = this.getActivity()!!.findViewById(R.id.head_name)
            headName.setText(MainActivity.name)
            val headEmail: TextView = this.getActivity()!!.findViewById(R.id.head_email)
            headEmail.setText(appl.email)
            val imageView: ImageView = this.getActivity()!!.findViewById(R.id.imageView)
            imageView.setImageURI(imageV)
        }

        return binding.root
    }
}
