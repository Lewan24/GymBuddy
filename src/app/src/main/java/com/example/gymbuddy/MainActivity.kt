package com.example.gymbuddy

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.gymbuddy.data.adapters.FragmentChangeListener
import com.example.gymbuddy.pages.AboutUsFragment
import com.example.gymbuddy.pages.ExercisesCategoriesFragment
import com.example.gymbuddy.pages.FigureFragment
import com.example.gymbuddy.pages.HomeFragment
import com.example.gymbuddy.pages.TrainingsFragment
import com.example.gymbuddy.pages.TrainingsHistoryFragment
import com.example.gymbuddy.pages.WeightFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    FragmentChangeListener {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_Home)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_Home -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            R.id.nav_Trainings -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, TrainingsFragment()).commit()
            R.id.nav_History -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, TrainingsHistoryFragment()).commit()
            R.id.nav_Weight -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, WeightFragment()).commit()
            R.id.nav_Figure -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FigureFragment()).commit()
            R.id.nav_ExercisesDb -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ExercisesCategoriesFragment()).commit()
            R.id.nav_about -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AboutUsFragment()).commit()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}