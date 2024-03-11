package com.example.gymbuddy.data.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.gymbuddy.R
import com.example.gymbuddy.data.entities.ExerciseCategoryModel
import com.example.gymbuddy.pages.ExercisesDbFragment


class ExercisesCategoriesAdapter(private val context: Context, private val fragmentChangeListener: FragmentChangeListener) : RecyclerView.Adapter<ExercisesCategoriesAdapter.ExerciseCategoriesViewHolder>() {

    var items = ArrayList<ExerciseCategoryModel>()

    fun setListData(data: ArrayList<ExerciseCategoryModel>){
        this.items = data
    }

    inner class ExerciseCategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btnOpenCategory: Button = itemView.findViewById(R.id.btnGoIntoCategory)
        val categoryName: TextView = itemView.findViewById(R.id.tvCategoryName)
        val categoryImage: ImageView = itemView.findViewById(R.id.ivCategoryImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseCategoriesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.single_exercise_category, parent, false)
        return ExerciseCategoriesViewHolder(itemView)
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ExerciseCategoriesViewHolder, position: Int) {
        val currentCategory = items[position]

        holder.categoryName.text = currentCategory.categoryName

        if (currentCategory.isStaticFile != null &&
            currentCategory.isStaticFile == "STATIC" &&
            currentCategory.imageUrl != null)
        {
            val packageName = context.packageName

            val field = Class.forName("$packageName.R\$drawable").getDeclaredField(currentCategory.imageUrl)
            val imageId = field.getInt(field)

            if (imageId != 0)
                holder.categoryImage.setImageResource(imageId)
        }
        else{
            if (currentCategory.imageUrl != null)
                holder.categoryImage.setImageURI(Uri.parse(currentCategory.imageUrl))
        }

        holder.btnOpenCategory.setOnClickListener{
            val exercisesFragment = ExercisesDbFragment.newInstance(currentCategory.id)
            goToNextFragment(exercisesFragment)
        }
    }

    private fun goToNextFragment(fragment: Fragment) {
        fragmentChangeListener.replaceFragment(fragment)
    }
}

interface FragmentChangeListener {
    fun replaceFragment(fragment: Fragment)
}