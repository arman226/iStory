package com.example.istory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.istory.fragments.CalendarFragment
import com.example.istory.fragments.ListFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout:DrawerLayout
    lateinit var navigationView: NavigationView

    lateinit var listFragment: ListFragment;
    lateinit var calendarFragment: CalendarFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()

    }

    //switch fragments whenever an item is selected from the navigation menu
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this,item.title, Toast.LENGTH_SHORT).show()
        when(item.itemId){
            R.id.list -> switchFragment(listFragment)
            R.id.calendar -> switchFragment(calendarFragment)
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun initUI(){
        toolbar= findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout= findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        //without these lines there will be no burger menu
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,0,0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener (this)

        //create an instance of each fragment
        listFragment = ListFragment();
        calendarFragment = CalendarFragment()

        //set the list Fragment as the initial fragment
       switchFragment(listFragment)
    }

    fun switchFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            commit()
        }
    }



}