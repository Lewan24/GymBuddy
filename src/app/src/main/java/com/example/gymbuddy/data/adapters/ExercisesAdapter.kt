package com.example.gymbuddy.data.adapters

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.gymbuddy.R
import com.example.gymbuddy.data.entities.ExerciseModel
import com.google.gson.Gson

class ExercisesAdapter : RecyclerView.Adapter<ExercisesAdapter.ExerciseViewHolder>() {
    var items = ArrayList<ExerciseModel>()

    fun setListData(data: ArrayList<ExerciseModel>){
        this.items = data
    }

    inner class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnLongClickListener {
        val exerciseName: TextView = itemView.findViewById(R.id.tvExerciseName)
        val exerciseLevel: TextView = itemView.findViewById(R.id.tvLevel)
        val exerciseMuscles: TextView = itemView.findViewById(R.id.tvMuscles)
        val buttonDetails: Button = itemView.findViewById(R.id.btnDetails)

        init {
            itemView.setOnLongClickListener(this)

            buttonDetails.setOnClickListener{
                onLongClick(this.itemView)
            }
        }

        override fun onLongClick(v: View?): Boolean {
            val position = adapterPosition
            val todoItem = items[position]

            val dialogView = LayoutInflater.from(itemView.context).inflate(R.layout.exercise_details_dialog, null)

            val exerciseVideo: VideoView = dialogView.findViewById(R.id.vvExerciseVideo)
            val mediaController = MediaController(itemView.context)

            // Todo: Need to check nulls and prepare catching
            //val videoUri: Uri? = if (todoItem.videoUrl != "") Uri.parse(todoItem.videoUrl) else null
            val videoUri: Uri = Uri.parse(todoItem.videoUrl)

            exerciseVideo.setVideoURI(videoUri)

            mediaController.setAnchorView(exerciseVideo)
            mediaController.setMediaPlayer(exerciseVideo)

            exerciseVideo.setMediaController(mediaController)
            exerciseVideo.start()

            val dialog = AlertDialog.Builder(itemView.context)
                .setView(dialogView)
                .create()

            val buttonReturn = dialogView.findViewById<Button>(R.id.btnReturn)
            buttonReturn.setOnClickListener{
                dialog.dismiss()
            }

            dialog.show()

            return true
        }
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
    }
}