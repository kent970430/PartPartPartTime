package com.example.partpartparttime.ui.events


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.partpartparttime.R
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentEventBinding
import kotlinx.android.synthetic.main.list_event.*

/**
 * A simple [Fragment] subclass.
 */
class EventFragment : Fragment() {
    var users = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Event"

        val binding: FragmentEventBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_event, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).eventDao
        val viewModelFactory = EventsViewModelFactory(dataSource, application)

        val eventViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(EventsViewModel::class.java)

        val adapter = EventRecyclerAdapter(EventListener { companyID ->
            Toast.makeText(context,"${companyID}", Toast.LENGTH_LONG).show()
            eventViewModel.onEventClicked(companyID)
        })

        eventViewModel.eventttt.observe(viewLifecycleOwner, Observer{
            eventViewModel.eventttt.observe(viewLifecycleOwner, Observer {
                it?.let {
                    adapter.submitList(it)
                }
            })
        })

        binding.eventList.adapter = adapter

        eventViewModel.navigateToCompany.observe(this, Observer { iddd ->
            iddd?.let {
                this.findNavController().navigate(
                    EventFragmentDirections
                        .actionEventsToProfileCompany(iddd))
                eventViewModel.onEventNavigated()

                users = company_id.text.toString()

            }
        })


        val aaa = GridLayoutManager(activity, 2)

        binding.eventList.layoutManager = aaa

        return binding.root
    }


}
