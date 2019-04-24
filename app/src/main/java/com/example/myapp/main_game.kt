package com.example.myapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.myapp.Model.UsersDBHelper
import kotlinx.android.synthetic.main.activity_main_game.*

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class main_game : AppCompatActivity(), View.OnClickListener  {
    override fun onClick(v: View?) {
        TODO("not implemented")
    }

    var nombreJugador: String? = null
    var UsersDBHelper = UsersDBHelper(this)

    private fun obtenerNombre() {
        val objectIntent: Intent = intent
        val nombre: String = objectIntent.getStringExtra("nombre")
        nombreJugador = nombre

        UsersDBHelper = UsersDBHelper(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_game)

        val boton3: Button = findViewById(R.id.btntres)
        val boton5: Button = findViewById(R.id.btncinco)
        val boton7: Button = findViewById(R.id.btnsiete)

        obtenerNombre()

        boton3.setOnClickListener {
            iniciarJuego("3")
        }
        boton5.setOnClickListener {
            iniciarJuego("5")
        }
        boton7.setOnClickListener {
            iniciarJuego("7")
        }

        btnExit2.setOnClickListener {
            salir()
            this.finish()
        }
    }

    // Bloquear el funcionamiento del botón físico de retroceso
    override fun onBackPressed() {

    }

    private fun iniciarJuego(variable: String) {
        val intent = Intent (this, juego::class.java)
        intent.putExtra("variableI", variable)
        intent.putExtra("nombre", nombreJugador)
        startActivity(intent)
        this.finish()
    }

    private fun salir() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
