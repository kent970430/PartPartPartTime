
package com.example.partpartparttime

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.widget.ImageView

//import com.example.partpartparttime.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var sharedPreferences: SharedPreferences
//    private lateinit var binding: ActivityMainBinding

    companion object {
        var loggedUser = ""
        var name = ""
        var role = ""
        var imagePath: String? = ""
        var imageview: ImageView? = null
        var categoryyyyy : String = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

//        sharedPreferences = getPreferences(Context.MODE_PRIVATE)
//
//        loggedUser = sharedPreferences.getString("loggedUser","")!!
//        role = sharedPreferences.getString("role","")!!
//        name = sharedPreferences.getString("user_namename","")!!

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,R.id.events,R.id.login,R.id.register,
                R.id.profile_applicant,R.id.profile_company,R.id.trainings
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        initRecycleView()
//        addDEventData()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

//    override fun onResume() {
//        loggedUser = sharedPreferences.getString("loggedUser","")!!
//        role = sharedPreferences.getString("role","")!!
//        name = sharedPreferences.getString("user_namename","")!!
//
//        super.onResume()
//    }
//
//    override fun onPause() {
//        with(sharedPreferences.edit()){
//            putString("loggedUser", loggedUser)
//            putString("role", role)
//            putString("user_namename", name)
//            commit()
//        }
//        super.onPause()
//    }
//
//    override fun onStop() {
//        with(sharedPreferences.edit()){
//            putString("loggedUser", loggedUser)
//            putString("role", role)
//            putString("name", name)
//            commit()
//        }
//        super.onStop()
//    }
}