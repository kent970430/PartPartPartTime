package com.example.partpartparttime.ui.training


import android.content.Intent
import android.net.Uri
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
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.partpartparttime.R
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.database.Training
import com.example.partpartparttime.databinding.FragmentTrainingBinding
import kotlinx.android.synthetic.main.list_training.*

/**
 * A simple [Fragment] subclass.
 */
class TrainingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Training"

        val binding: FragmentTrainingBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_training, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).trainingDao
        val viewModelFactory = TrainingViewModelFactory(dataSource, application)

        val trainingViewModel =
            ViewModelProviders.of(
                this,viewModelFactory).get(TrainingViewModel::class.java)

        val adapter = TrainingRecyclerAdapter(TrainingListener { trainingID ->
            Toast.makeText(context,"${trainingID}", Toast.LENGTH_LONG).show()
            trainingViewModel.onTrainingClicked(trainingID)
        })

        trainingViewModel.trainingggg.observe(viewLifecycleOwner, Observer{
            trainingViewModel.trainingggg.observe(viewLifecycleOwner, Observer{
                it?.let{
                    adapter.submitList(it)
                }
            })
        })

        binding.trainingList.adapter = adapter

        val ooo = GridLayoutManager(activity,1)
        binding.trainingList.layoutManager = ooo

        binding.buttonCancelll.setOnClickListener{view ->
            view.findNavController().navigate(R.id.action_trainingFragment_to_nav_home)
        }

        trainingViewModel.navigateToTraining.observe(this, Observer{ yooo ->
            yooo?.let{
                val openURL = Intent(Intent.ACTION_VIEW)
                var site = training_website.text.toString()
                openURL.data = Uri.parse(site)
                startActivity(openURL)
            }
        })
        return binding.root
    }
}
