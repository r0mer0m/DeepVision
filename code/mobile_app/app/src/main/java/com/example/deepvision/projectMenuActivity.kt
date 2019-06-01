package com.example.deepvision

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_project_menu.*
import kotlinx.android.synthetic.main.app_bar_project_menu.*

const val EXTRA_IS_TRAIN = "is_train"

class projectMenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_menu)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()


//        nav_view.setNavigationItemSelectedListener(this)
//
//        val train = findViewById<Button>(R.id.button)
//        val predict = findViewById<Button>(R.id.button2)
//
//        train.setOnClickListener {
//            val intent = Intent(this, captureAndTag::class.java)
//
//            intent.putExtra(EXTRA_IS_TRAIN, true)
//
//            startActivity(intent)
//        }
//
//        predict.setOnClickListener {
//            val intent = Intent(this, captureAndTag::class.java)
//
//            intent.putExtra(EXTRA_IS_TRAIN, false)
//
//            startActivity(intent)
//        }
    }

    fun upload(view: View){

        val intent = Intent(this, captureAndTag::class.java)

        intent.putExtra(EXTRA_IS_TRAIN, false)

        startActivity(intent)

    }

    fun train(view: View){

        val intent = Intent(this, train_start::class.java)

//        intent.putExtra(EXTRA_IS_TRAIN, true)

        startActivity(intent)

    }

    fun predict(view: View){

        // TODO: Change called activity to keep them separate
        val intent = Intent(this, capture::class.java)

//        intent.putExtra(EXTRA_IS_TRAIN, false)

        startActivity(intent)

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.project_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
