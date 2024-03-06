package com.example.gymbuddy.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gymbuddy.R
import com.example.gymbuddy.data.entities.TrainingPlanModel
import com.example.gymbuddy.data.viewmodels.TrainingsViewModel

class TrainingPlansAdapter : RecyclerView.Adapter<TrainingPlansAdapter.TrainingPlanViewHolder>() {
    private lateinit var databaseViewModel: TrainingsViewModel
    var items = ArrayList<TrainingPlanModel>()

    fun setListData(data: ArrayList<TrainingPlanModel>){
        this.items = data
    }

    fun setViewModel(viewModel: TrainingsViewModel){
        this.databaseViewModel = viewModel
    }
    inner class TrainingPlanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val trainingName: TextView = itemView.findViewById(R.id.tvTrainingName)
        val trainingExercises: TextView = itemView.findViewById(R.id.tvExercises)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingPlanViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.training_plan, parent, false)
        return TrainingPlanViewHolder(itemView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TrainingPlanViewHolder, position: Int) {
        val currentTrainingPlan = items[position]

        holder.trainingName.text = currentTrainingPlan.trainingName
        holder.trainingExercises.text = currentTrainingPlan.exercises
    }

}
