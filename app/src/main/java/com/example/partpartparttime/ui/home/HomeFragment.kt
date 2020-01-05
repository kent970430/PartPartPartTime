package com.example.partpartparttime.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.partpartparttime.R
import com.example.partpartparttime.database.*
import java.time.LocalDate

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
//            textView.text = it
        })

//        val application = requireNotNull(this.activity).application
//        val dataSource = PartimeDatabase.getInstance(application).userDao
//        val dataSource1 = PartimeDatabase.getInstance(application).applicantDao
//        val dataSource2 = PartimeDatabase.getInstance(application).companyDao
//        val dataSource3 = PartimeDatabase.getInstance(application).eventDao
//        val dataSource4 = PartimeDatabase.getInstance(application).noticDao
//        val dataSource5 = PartimeDatabase.getInstance(application).partimeJobDao
//        val dataSource6 = PartimeDatabase.getInstance(application).rateDao
//        val dataSource7 = PartimeDatabase.getInstance(application).trainingDao
//        val dataSource8 = PartimeDatabase.getInstance(application).trainingOrganizationDao

//        dataSource.insert(User("",0,0,0,""))
//        dataSource1.insert(Applicant(0,0,"","",0,"","","","",""))
//        dataSource2.insert(Company(0,0,"","","","",0))
//        dataSource3.insert(Event(0,0))
//        dataSource4.insert(Notic(0,"2018-12-31"))
//        dataSource5.insert(PartimeJob(0,"","",0,"2018-12-31",true,true))
//        dataSource6.insert(Rate(0,0.0))
//        dataSource7.insert(Training(0,0,"","2018-12-31"))
//        dataSource8.insert(TrainingOrganization(0,"","","",""))
        return root
    }
}