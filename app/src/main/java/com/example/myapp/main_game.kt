package com.example.myapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main_game.*

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class main_game : AppCompatActivity(), View.OnClickListener  {
    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_game)


        // val botonJugar: Button = findViewById(R.id.btninicio)
        val boton3: Button = findViewById(R.id.btntres)
        val boton5: Button = findViewById(R.id.btncinco)
        val boton7: Button = findViewById(R.id.btnsiete)

        boton3.setOnClickListener { iniciarJuego() }
        boton5.setOnClickListener { iniciarJuego() }
        boton7.setOnClickListener { iniciarJuego() }

        btnExit2.setOnClickListener {
            salir()
            this.finish()
        }
    }

    // Bloquear el funcionamiento del botón físico de retroceso
    override fun onBackPressed() {

    }

    private fun iniciarJuego() {
        val intent = Intent(this, juego::class.java)
        startActivity(intent)
    }
    private fun salir() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
