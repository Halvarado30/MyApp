package com.example.myapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
        siguiente.setOnClickListener { jugar() }
    }
}
