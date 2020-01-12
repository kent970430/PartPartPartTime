package com.example.partpartparttime.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.R
import com.example.partpartparttime.database.*
import com.example.partpartparttime.databinding.FragmentHomeBinding
import java.time.LocalDate

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home, container, false
        )

        val name: TextView = binding.root.findViewById(R.id.text_home)
        name.setText(MainActivity.name)

        binding.buttonEvent.setOnClickListener { view ->

            view.findNavController().navigate(R.id.action_nav_home_to_events)

        }

        binding.buttonTraining.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_nav_home_to_trainings)

        }

        binding.buttonJob.setOnClickListener { view ->

            view.findNavController().navigate(R.id.action_nav_home_to_searchCompany)

        }

        binding.buttonHR!!.setOnClickListener { view ->

            view.findNavController().navigate(R.id.action_nav_home_to_searchApplicant)

        }

        binding.buttonHis!!.setOnClickListener { view ->

            view.findNavController().navigate(R.id.action_historyApplicantFindCompany_to_nav_home)

        }

        return binding.root
    }
}