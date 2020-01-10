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
import androidx.recyclerview.widget.GridLayoutManager
import com.example.partpartparttime.R
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.database.Training
import com.example.partpartparttime.databinding.FragmentTrainingBinding
import kotlinx.android.synthetic.main.list_training.*
import java.util.*

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

        val addd = Training()
        addd.trainingID = UUID.randomUUID().toString()
        addd.trainingName = "TARUC Open Day 2020!!!"
        addd.date = "24/01/2020"
        addd.website = "https://www.tarc.edu.my/"

        val addd2 = Training()
        addd2.trainingID = UUID.randomUUID().toString()
        addd2.trainingName = "Sunway Education Open Day is Back !!"
        addd2.date = "15/02/2020"
        addd2.website = "https://my.sunway.edu.my/openday/"

        val addd3 = Training()
        addd3.trainingID = UUID.randomUUID().toString()
        addd3.trainingName = "Taylor's Open Day 2019"
        addd3.date = "16/02/2020"
        addd3.website = "https://university2.taylors.edu.my/enrol/"

        val addd4 = Training()
        addd4.trainingID = UUID.randomUUID().toString()
        addd4.trainingName = "THE BEST TERTIARY EDUCATION BEGINS HERE"
        addd4.date = "28/03/2020 - 29/03/2020"
        addd4.website = "http://openday.ucsiuniversity.edu.my/"

        val addd5 = Training()
        addd4.trainingID = UUID.randomUUID().toString()
        addd4.trainingName = "5 Corporate Training Programs Every Employee Should Take"
        addd4.date = "01/04/2020"
        addd4.website = "https://explorance.com/blog/5-corporate-training-programs-every-employee-take/"

        dataSource.insert(addd)
        dataSource.insert(addd2)
        dataSource.insert(addd3)
        dataSource.insert(addd4)
        dataSource.insert(addd5)

        binding.trainingList.adapter = adapter

        val ooo = GridLayoutManager(activity,1)
        binding.trainingList.layoutManager = ooo

        binding.buttonCancelll.setOnClickListener{view ->
            view.findNavController().navigate(R.id.action_trainings_to_nav_home)
        }

        trainingViewModel.navigateToTraining.observe(this, Observer{ yooo ->
            yooo?.let{
                val openURL = Intent(Intent.ACTION_VIEW)
                val site = training_website.text.toString()
                openURL.data = Uri.parse(site)
                startActivity(openURL)
            }
        })
        return binding.root
    }
}
