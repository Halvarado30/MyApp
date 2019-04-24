package com.example.myapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.myapp.Model.UsersDBHelper
import kotlinx.android.synthetic.main.activity_carga_puntaje2.*

class CargaPuntaje2 : AppCompatActivity() {

    lateinit var UsersDBHelper : UsersDBHelper
    var nombreJugador: String? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carga_puntaje2)

        UsersDBHelper = UsersDBHelper(this)

        val jugadores = UsersDBHelper.readAllUsers(nombreJugador.toString())
        jugadores.forEach {
            val tv_user = TextView(this)
            tv_user.textSize = 30F
            tv_user.text = it. nombre + "     " + it. puntos .toString()
            this.Carga.addView(tv_user)
        }

    }
}