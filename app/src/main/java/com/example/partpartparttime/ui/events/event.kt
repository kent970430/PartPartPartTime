package com.example.potensituitionapp.Main


import android.os.Bundle
import android.os.Handler
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import com.example.partpartparttime.R
import com.example.partpartparttime.databinding.FragmentEventBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.ui.events.EventListener
import com.example.partpartparttime.ui.events.EventRecyclerAdapter
import com.example.partpartparttime.ui.events.EventsViewModel
import com.example.partpartparttime.ui.events.EventsViewModelFactory


/**
 * A simple [Fragment] subclass.
 */
class event : Fragment() {

    private var doubleBackToExitPressedOnce = false

    companion object {
        fun newInstance(): event = event()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Main Menu"

        val binding: FragmentEventBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_event, container, false)

        //Database
        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).eventDao
        val viewModelFactory = EventsViewModelFactory(dataSource, application)


        val eventViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(EventsViewModel::class.java)

        val adapter = EventRecyclerAdapter(EventListener { eventId ->
            Toast.makeText(context,"${eventId}",Toast.LENGTH_LONG).show()
            eventViewModel.onEventClicked(eventId)
        })

        eventViewModel.eventttt.observe(viewLifecycleOwner, Observer{
            eventViewModel.eventttt.observe(viewLifecycleOwner, Observer {
                it?.let {
                    adapter.submitList(it)
                }
            })
        })

        binding.eventList.adapter = adapter

//        eventViewModel.navigateToCompany.observe(this, Observer { iddd ->
//            iddd?.let {
//                this.findNavController().navigate(
//                    eventDirections
//                        .actionMainmenuFragmentToClassdetailFragment(iddd))
//                eventViewModel.onEventNavigated()
//            }
//        })


        val aaa = GridLayoutManager(activity, 2)

        binding.eventList.layoutManager = aaa

        return binding.root
    }
}
