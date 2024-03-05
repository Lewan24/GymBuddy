package com.example.gymbuddy.pages

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gymbuddy.R
import com.example.gymbuddy.data.adapters.TrainingPlansAdapter
import com.example.gymbuddy.data.viewmodels.TrainingsViewModel
import com.example.gymbuddy.databinding.FragmentTrainingsBinding

class TrainingsFragment : Fragment() {
    companion object {
        fun newInstance() = TrainingsFragment()
    }

    private lateinit var viewModel: TrainingsViewModel
    private lateinit var trainingPlansAdapter: TrainingPlansAdapter
    private lateinit var binding: FragmentTrainingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrainingsBinding.inflate(inflater, container, false)
        trainingPlansAdapter = TrainingPlansAdapter()

        viewModel = ViewModelProvider(this)[TrainingsViewModel::class.java]
        viewModel.getAllTrainingPlansAsObservers().observe(viewLifecycleOwner) {
            trainingPlansAdapter.setListData(ArrayList(it))
            trainingPlansAdapter.setViewModel(this.viewModel)
            trainingPlansAdapter.notifyDataSetChanged()
        }

        binding.rvTrainingPlansList.layoutManager = LinearLayoutManager(this.context)
        binding.rvTrainingPlansList.adapter = trainingPlansAdapter

        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}