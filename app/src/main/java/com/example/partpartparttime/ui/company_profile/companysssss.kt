package com.example.partpartparttime.ui.company_profile


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.R
import com.example.partpartparttime.database.Company
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentCompanysssssBinding
import com.example.partpartparttime.ui.events.EventFragment

/**
 * A simple [Fragment] subclass.
 */
class companysssss : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCompanysssssBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_companysssss, container, false
        )

        val application = requireNotNull(this.activity).application
        val arguments = companysssssArgs.fromBundle(arguments)
        val company_ID = arguments.companyId


        val dataSource = PartimeDatabase.getInstance(application).companyDao

        var comp: Company? = dataSource.getCompanyID(company_ID)

//        var evenn = EventFragment()
//        var userss = evenn.users
//        var comp1: Company? = dataSource.getCompanyID(userss)

        //if(userss == loggedUser) {
        if (comp == null) {
            Toast.makeText(activity, R.string.get_failed, Toast.LENGTH_SHORT).show()
            Log.i("Result", "No company found")
        } else {
            val name: EditText = binding.root.findViewById(R.id.textName)
            name.setText(comp.companyName)

            val email: EditText = binding.root.findViewById(R.id.textEmaill)
            email.setText(comp.email)

            val contact: EditText = binding.root.findViewById(R.id.textDescription)
            contact.setText(comp.contact)

            val address: EditText = binding.root.findViewById(R.id.textDescription1)
            address.setText(comp.address)

            val description: EditText = binding.root.findViewById(R.id.textDescription2)
            description.setText(comp.details)

            val job: EditText = binding.root.findViewById(R.id.textDescription3)
            job.setText(comp.job)

            val image: ImageView = binding.root.findViewById(R.id.imageViewPreview2)
            val imageV = comp.image.toString().toUri()
            image.setImageURI(imageV)

            val headName: TextView = this.getActivity()!!.findViewById(R.id.head_name)
            headName.setText(MainActivity.name)
            val headEmail: TextView = this.getActivity()!!.findViewById(R.id.head_email)
            headEmail.setText(comp.email)
            val imageView: ImageView = this.getActivity()!!.findViewById(R.id.imageView)
            imageView.setImageURI(imageV)
        }
//        }else{
//            binding.buttonEdit.hidee(false)
//            binding.buttonSave.hidee(false)
//            binding.buttonLogOut.hidee(false)
//            val name: EditText = binding.root.findViewById(R.id.textName)
//            if (comp1 != null) {
//                name.setText(comp1.companyName)
//            }
//
//            val email: EditText = binding.root.findViewById(R.id.textEmaill)
//            if (comp1 != null) {
//                email.setText(comp1.email)
//            }
//
//            val contact: EditText = binding.root.findViewById(R.id.textDescription)
//            if (comp1 != null) {
//                contact.setText(comp1.contact)
//            }
//
//            val address: EditText = binding.root.findViewById(R.id.textDescription1)
//            if (comp1 != null) {
//                address.setText(comp1.address)
//            }
//
//            val description: EditText = binding.root.findViewById(R.id.textDescription2)
//            if (comp1 != null) {
//                description.setText(comp1.details)
//            }
//
//            val job: EditText = binding.root.findViewById(R.id.textDescription3)
//            if (comp1 != null) {
//                job.setText(comp1.job)
//            }
//
//            val image: ImageView = binding.root.findViewById(R.id.imageViewPreview2)
//            val imageV = comp1?.image.toString().toUri()
//            image.setImageURI(imageV)
//
//            val headName: TextView = this.getActivity()!!.findViewById(R.id.head_name)
//            headName.setText(MainActivity.name)
//            val headEmail: TextView = this.getActivity()!!.findViewById(R.id.head_email)
//            if (comp1 != null) {
//                headEmail.setText(comp1.email)
//            }
//            val imageView: ImageView = this.getActivity()!!.findViewById(R.id.imageView)
//            imageView.setImageURI(imageV)
//        }

        return binding.root
    }

}