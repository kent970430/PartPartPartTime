package com.example.partpartparttime.ui.events


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.MainActivity.Companion.loggedUser
import com.example.partpartparttime.R
import com.example.partpartparttime.database.Applicant
import com.example.partpartparttime.database.Company
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentEventBinding
import kotlinx.android.synthetic.main.fragment_event.*
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

        val dataSource1 = PartimeDatabase.getInstance(application).companyDao
        var comp: Company? = dataSource1.getCompanyID(loggedUser)
       // val btn: Button = activity!!.findViewById(R.id.buttonAdd)

//        if(app != null){
//            if(app.userID == loggedUser) {
//                buttonAdd.isVisible = false
//            }
//        }else if (loggedUser == null){
//            buttonAdd.isVisible = false
//        }else{
//            buttonAdd.isVisible = true
//        }

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
                //users = company_id.text.toString()
                this.findNavController().navigate(
                EventFragmentDirections.actionEventsToCompanysssss(iddd)
                )
                eventViewModel.onEventNavigated()

                Log.i("idddd",iddd)
            }
        })

        val aaa = GridLayoutManager(activity, 1)

        binding.eventList.layoutManager = aaa

        if(loggedUser.trim().isNotEmpty()){
            if(comp != null){
                binding.buttonAdd.hidee(true)
            }
        }

        binding.buttonAdd.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_events_to_addEventsFragment)
        }

        return binding.root
    }

    fun View.hidee(show: Boolean) {
        visibility = if(show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}
