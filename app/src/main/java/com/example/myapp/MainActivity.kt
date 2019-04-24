package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

@Suppress("IMPLICIT_CAST_TO_ANY")
class MainActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        displayScreen(-1)
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
        menuInflater.inflate(R.menu.main, menu)
        return true
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)

        }

    }

    fun  displayScreen (id: Int){
        val fragment = when (id){


            R.id.nav_main -> {
                Main2Activity ()
            }

            R.id.nav_inicio -> {
                inicioJuego ()
            }

            R.id.nav_puntos -> {
                inicioJuego ()
            }

            R.id.nav_guide -> {
                jugar ()
            }

            R.id.nav_salir -> {
                this.salir()
            }

            else -> {
                Main2Activity()
            }
        }


        supportFragmentManager.beginTransaction()
            .replace(R.id.relativelayout, fragment as Fragment)
            .commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        displayScreen(item.itemId)
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun salir() {
        this.finish()
    }

    private fun jugar() {
        val intent = Intent(this, juego::class.java)
        startActivity(intent)
    }

    private fun inicioJuego(){
        val intent = Intent(this, main_game::class.java)
        startActivity(intent)
    }
}

