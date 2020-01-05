package com.example.partpartparttime.ui.events

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.example.partpartparttime.R
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentEventsBinding

class EventFragment : Fragment() {

    companion object {
        fun newInstance(): EventFragment = EventFragment()
    }

    private lateinit var viewModel: EventsViewModel
    private lateinit var eventAdapter: EventRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Events"

        val binding: FragmentEventsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_events, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).eventDao
        val viewModelFactory = EventViewModelFactory(dataSource, application)

        val EventTrackerViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(EventsViewModel::class.java)

//        binding.eventTrackerViewModel = EventTrackerViewModel
//        binding.setLifecycleOwner(this)

//        val adapter = EventRecyclerAdapter()
//        binding.eventList.adapter = adapter

        val adapter =
            EventRecyclerAdapter(EventListener { eventID ->
                Toast.makeText(context, "${eventID}", Toast.LENGTH_LONG).show()
                EventTrackerViewModel.onEventClicked(eventID)
            })

        EventTrackerViewModel.eventttt.observe(viewLifecycleOwner, Observer {
            EventTrackerViewModel.eventttt.observe(viewLifecycleOwner, Observer{
                it?.let{
                    adapter.submitList(it)
                }
            })
        })

        binding.eventList.adapter = adapter

        EventTrackerViewModel.navigateToCompany.observe(this, Observer { ee ->
            ee?.let {
                this.findNavController().navigate(
                    EventFragmentDirections
                        .actionMainmenuFragmentToClassdetailFragment(ee))
                EventTrackerViewModel.onEventNavigated()
            }
        })

        return binding.root
    }


//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(EventsViewModel::class.java)
//        // TODO: Use the ViewModel
//    }
}

