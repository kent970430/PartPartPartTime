package com.example.partpartparttime.ui.events

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.partpartparttime.R
import com.example.partpartparttime.models.EventRecyclerAdapter
import com.example.partpartparttime.models.Source
import com.example.partpartparttime.models.Spacing
import kotlinx.android.synthetic.main.fragment_events.*

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
        return inflater.inflate(R.layout.fragment_events, container, false)
        initRecycleView()
        addEventData()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EventsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun addEventData(){
        val data = Source.createDataSet()
        eventAdapter.submitList(data)
    }

    private fun initRecycleView(){
        event_recycleview.apply{
            val spacee = Spacing(30)
            addItemDecoration(spacee)
            eventAdapter = EventRecyclerAdapter()
            adapter = eventAdapter
        }
    }

}
