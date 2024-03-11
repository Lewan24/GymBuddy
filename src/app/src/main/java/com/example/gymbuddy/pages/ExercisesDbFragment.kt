package com.example.gymbuddy.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gymbuddy.data.adapters.ExercisesAdapter
import com.example.gymbuddy.data.viewmodels.ExercisesDbViewModel
import com.example.gymbuddy.databinding.FragmentExercisesDbBinding

class ExercisesDbFragment(private val categoryId: Int) : Fragment() {

    companion object {
        fun newInstance(categoryId: Int) = ExercisesDbFragment(categoryId)
    }

    private lateinit var viewModel: ExercisesDbViewModel
    private lateinit var exercisesAdapter: ExercisesAdapter
    private lateinit var binding: FragmentExercisesDbBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View {
        super.onCreate(savedInstanceState)

        binding = FragmentExercisesDbBinding.inflate(inflater, container, false)
        exercisesAdapter = ExercisesAdapter()

        viewModel = ViewModelProvider(this)[ExercisesDbViewModel::class.java]
        viewModel.getMatchedCategoryExercises(categoryId).observe(viewLifecycleOwner){
            exercisesAdapter.setListData(ArrayList(it))
            exercisesAdapter.notifyDataSetChanged()
        }

        binding.rvExercisesList.layoutManager = LinearLayoutManager(this.context)
        binding.rvExercisesList.adapter = exercisesAdapter

        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}