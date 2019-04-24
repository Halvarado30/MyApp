package com.example.myapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_juego.*
import kotlinx.android.synthetic.main.activity_registro_usuario.*

class Registro_usuario : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_usuario)


        val siguiente: Button = findViewById(R.id.btnJugar)

        fun jugar() {

            val intent = Intent(this, main_game::class.java)
            val nombreg: String = etNombre.text.toString()
            intent.putExtra("nombre", nombreg)
            this.startActivity(intent)
        }
        btnExit3.setOnClickListener {
            jugarA()
            this.finish()
        }
        siguiente.setOnClickListener {
            jugar()
            this.finish()
        }


    }

    // Bloquear el funcionamiento del botón físico de retroceso
    override fun onBackPressed() {

    }

    private fun jugarA() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
