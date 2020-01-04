package com.example.partpartparttime.ui.applicant_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.partpartparttime.R
import com.example.partpartparttime.database.Applicant

class ApplicantFragment : Fragment() {

    private lateinit var applicantViewModel: ApplicantViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        applicantViewModel =
            ViewModelProviders.of(this).get(ApplicantViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        applicantViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}