package com.example.gymbuddy.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gymbuddy.MainActivity
import com.example.gymbuddy.data.adapters.ExercisesCategoriesAdapter
import com.example.gymbuddy.data.adapters.FragmentChangeListener
import com.example.gymbuddy.data.viewmodels.ExercisesDbViewModel
import com.example.gymbuddy.databinding.FragmentExercisesCategoriesBinding

class ExercisesCategoriesFragment : Fragment() {

    companion object {
        fun newInstance() = ExercisesCategoriesFragment()
    }

    private lateinit var viewModel: ExercisesDbViewModel
    private lateinit var exercisesCategoriesAdapter: ExercisesCategoriesAdapter
    private lateinit var binding: FragmentExercisesCategoriesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View {
        super.onCreate(savedInstanceState)

        binding = FragmentExercisesCategoriesBinding.inflate(inflater, container, false)
        exercisesCategoriesAdapter = ExercisesCategoriesAdapter(object : FragmentChangeListener {
            override fun replaceFragment(fragment: Fragment) {
                (requireActivity() as MainActivity).replaceFragment(fragment)
            }
        })

        viewModel = ViewModelProvider(this)[ExercisesDbViewModel::class.java]
        viewModel.getAllExercisesCategories().observe(viewLifecycleOwner){
            exercisesCategoriesAdapter.setListData(ArrayList(it))
            exercisesCategoriesAdapter.notifyDataSetChanged()
        }

        binding.rvExercisesCategoriesList.layoutManager = LinearLayoutManager(this.context)
        binding.rvExercisesCategoriesList.adapter = exercisesCategoriesAdapter

        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}