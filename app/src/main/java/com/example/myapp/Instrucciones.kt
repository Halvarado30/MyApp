package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_instrucciones.*

class Instrucciones : AppCompatActivity() {

    // Se crea una lista donde se almacenarán las imágenes que contienen las reglas del juego
    var fondo = intArrayOf(R.drawable.piedrarules, R.drawable.papelrules, R.drawable.tijerasrules, R.drawable.lizardrules, R.drawable.spockrules)
    private var position:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instrucciones)


        // Se establece una imagen por defecto al momento de entrar en la opción de INSTRUCCIONES
        iv_Instruccion.setImageResource(fondo[0])
        // Se encargará de mostrar la siguiente imagen de instrucción del juego
          this.btnIntruccion.setOnClickListener {
            position += 1

            // Por defecto el botón de anterior se encuentra invisible
            // al avanzar de la primera imagen este pasa a ser visible para el usuario
            this.btnAnterior.visibility = View.VISIBLE
            iv_Instruccion.setImageResource(fondo[position])

            // Se evalua la instrucción en la que se encuentra el usuario
            // si se encuentra en la última instrucción se ocultará el botón de SIGUIENTE
            // para evitar que el usuario vaya más allá de los límites de la lista
            if ( position == 4) {
                btnIntruccion.visibility = View.INVISIBLE
            }
        }

        // Se encargará de mostrar la imagen anterior de instrucción del juego
        this.btnAnterior.setOnClickListener {
            position -= 1
            iv_Instruccion.setImageResource(fondo[position])

            // Se evalua la instrucción en la que se encuentra el usuario
            // si se encuentra en la primera instrucción se ocultará el botón de ANTERIOR
            // para evitar que el usuario vaya más allá de los límites de la lista
            // y cambiará el estado de visibilidad del botón de ANTERIOR
            if (position == 0 || position == 3){
                btnIntruccion.visibility = View.VISIBLE
            }

            if(position == 0){
                btnAnterior.visibility = View.INVISIBLE
            }
        }

        btnExit.setOnClickListener {
            jugar()
            this.finish()
        }
}
    // Bloquear el funcionamiento del botón físico de retroceso
    override fun onBackPressed() {

    }

    private fun jugar() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        this.finish()
    }
}