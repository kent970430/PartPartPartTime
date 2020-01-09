package com.example.partpartparttime.ui.addEvents


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.R
import com.example.partpartparttime.database.Company
import com.example.partpartparttime.database.Event
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentAddEventBinding
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class AddEventsFragment : Fragment() {

    private var eventIDD: String = ""
    private var eventDescriptionn: String = ""
    private var companyIDD: String? = ""
    private var companyNamee: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentAddEventBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add_event, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).companyDao
        val dataSource1 = PartimeDatabase.getInstance(application).eventDao

        var comp: Company? = dataSource.getCompanyID(MainActivity.loggedUser)

//        var lastt: String = dataSource1.getLastID()
//        var numm:Int = lastt.toInt()
//        var thisislast:Int = numm + 1


//        val eventIDDD: EditText = binding.root.findViewById(R.id.textEventIDD)
//        if (lastt != null) {
//            eventIDDD.setText(thisislast.toString())
//            eventIDDD.isEnabled = false
//        }


        if (comp == null) {
                Toast.makeText(activity, R.string.get_failed, Toast.LENGTH_SHORT).show()
                Log.i("Result", "No company found")
        } else {
            companyNamee = comp.companyName
            companyIDD = comp.companyID

//            val idd: EditText = binding.root.findViewById(R.id.textCompanyIDD)
//            idd.setText(comp.companyID)
//            idd.isEnabled = false

            val name: EditText = binding.root.findViewById(R.id.textCompanyNamee)
            name.setText(comp.companyName)
            name.isEnabled = false
        }

        val viewModelFactory = AddEventsViewModelFactory(dataSource1, application)

        val eventtttViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(AddEventsViewModel::class.java)

        binding.addeventsViewModel = eventtttViewModel

        binding.setLifecycleOwner(this)

        binding.buttonAdd.setOnClickListener{view ->
            eventDescriptionn = binding.textEventDesc.text.toString()
            companyNamee = binding.textCompanyNamee.text.toString()

            //var num:Int = eventIDD.toInt()

            var addd = Event()

            addd.eventID = UUID.randomUUID().toString()
            addd.companyID = companyIDD
            addd.companyName = companyNamee
            addd.event_description = eventDescriptionn

            dataSource1.insert(addd)
            view.findNavController().navigate(R.id.action_addEventsFragment_to_events)
        }

        binding.buttonCancell.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_addEventsFragment_to_events)
        }
        return binding.root
    }


}
