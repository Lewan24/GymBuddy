package com.example.gymbuddy.data.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gymbuddy.R
import com.example.gymbuddy.data.entities.ExerciseModel
import com.example.gymbuddy.data.viewmodels.ExercisesDbViewModel
import com.google.gson.Gson

class ExercisesAdapter : RecyclerView.Adapter<ExercisesAdapter.ExerciseViewHolder>() {
    private lateinit var databaseViewModel: ExercisesDbViewModel
    var items = ArrayList<ExerciseModel>()

    fun setListData(data: ArrayList<ExerciseModel>){
        this.items = data
    }

    fun setViewModel(viewModel: ExercisesDbViewModel){
        this.databaseViewModel = viewModel
    }
    inner class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val exerciseName: TextView = itemView.findViewById(R.id.tvExerciseName)
        val exerciseLevel: TextView = itemView.findViewById(R.id.tvLevel)
        val exerciseMuscles: TextView = itemView.findViewById(R.id.tvMuscles)
//        val exerciseVideo: VideoView = itemView.findViewById(R.id.vvExerciseVideo)
//        val mediaController = MediaController(itemView.context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.singleexercise, parent, false)
        return ExerciseViewHolder(itemView)
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val currentExercise = items[position]

        holder.exerciseName.text = "${currentExercise.id}. ${currentExercise.exerciseName}"
        holder.exerciseLevel.text = "Level: ${currentExercise.level}"

        // Todo: Check if this solution is not killing performance if there would be many more exercises
        val gson = Gson()
        val exerciseMusclesAsList: List<String> = gson.fromJson<List<String>>(currentExercise.musclesUsed, List::class.java)
        "Muscles: ${exerciseMusclesAsList.joinToString(separator = ",")}".also { holder.exerciseMuscles.text = it }

        // Todo: Need to check nulls and prepare catching
        //val videoUri: Uri? = if (currentExercise.videoUrl != "") Uri.parse(currentExercise.videoUrl) else null

//        val videoUri: Uri = Uri.parse(currentExercise.videoUrl)
//
//        holder.exerciseVideo.setVideoURI(videoUri)
//
//        holder.mediaController.setAnchorView(holder.exerciseVideo)
//        holder.mediaController.setMediaPlayer(holder.exerciseVideo)
//
//        holder.exerciseVideo.setMediaController(holder.mediaController)
//        holder.exerciseVideo.start()
    }
}
