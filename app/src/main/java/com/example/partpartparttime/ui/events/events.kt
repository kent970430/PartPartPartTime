package com.example.partpartparttime.ui.events

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.partpartparttime.R
import com.example.partpartparttime.models.EventRecyclerAdapter

class events : Fragment() {

    companion object {
        fun newInstance() = events()
    }

    private lateinit var viewModel: EventsViewModel
    private lateinit var eventAdapter: EventRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:   = DataBindingUtil.inflate(
            inflater, R.layout.fragment_events, container, false)

        return inflater.inflate(R.layout.fragment_events, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EventsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
