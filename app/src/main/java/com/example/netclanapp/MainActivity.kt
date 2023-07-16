package com.example.netclanapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.netclanapp.databinding.ActivityMainBinding
import com.example.netclanapp.ui.Explore.ExploreFragment
import com.example.netclanapp.ui.Explore.fragments.PersonalFrag
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

     lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    companion object {
        var navView: BottomNavigationView? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navView = binding.navView
        val navView: BottomNavigationView = binding.navView

         navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_Explore, R.id.navigation_Network, R.id.navigation_Chat,
                R.id.navigation_Contacts, R.id.navigation_Group
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_tool_bar_menu, menu)

        val menuItem = menu?.findItem(R.id.mi_refine)
        val actionView = menuItem?.actionView

        if (actionView != null) {
            val iconImageView = actionView.findViewById<ImageView>(R.id.icon)
            val quickTextView = actionView.findViewById<TextView>(R.id.quickText)

            iconImageView.setOnClickListener {
                // Handle icon click event
                navController.navigate(R.id.Global_Action_to_refineFragment)
            }

            quickTextView.setOnClickListener {
                // Handle quick text click event
                navController.navigate(R.id.Global_Action_to_refineFragment)
            }
        }

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mi_refine -> {
                navController.navigate(R.id.Global_Action_to_refineFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun showTopToolbar(show: Boolean) {
        if (show) {
            supportActionBar?.show()
        } else {
            supportActionBar?.hide()
        }
    }
}
