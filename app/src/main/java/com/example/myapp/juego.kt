package com.example.myapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_juego.*

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class juego : AppCompatActivity(), View.OnClickListener{

    private var valorin = 0
    private var valorout = 3
    private var input: ImageView? = null
    private var output: ImageView? = null
    private var rock: Button? = null
    private var paper: Button? = null
    private var scissors: Button? = null
    private var lizard: Button? = null
    private var spock: Button? = null

    var images = intArrayOf(R.drawable.piedra, R.drawable.papel, R.drawable.tijera, R.drawable.lagartija, R.drawable.spock)
    var userinput = 0

    override fun onCreate(savedInstanceState: Bundle?)  {

        super.onCreate(savedInstanceState)
        
        setContentView(R.layout.activity_juego)
        input = findViewById(R.id.iv_input)
        output = findViewById(R.id.iv_output)
        rock = findViewById(R.id.btn_piedra)
        paper = findViewById(R.id.btn_papel)
        scissors = findViewById(R.id.btn_tijera)
        lizard = findViewById(R.id.btn_lagartija)
        spock = findViewById(R.id.btn_spock)

        rock?.setOnClickListener(this)
        paper?.setOnClickListener(this)
        scissors?.setOnClickListener(this)
        lizard?.setOnClickListener(this)
        spock?.setOnClickListener(this)

        btnExit.setOnClickListener {
            jugar()
            this.finish()
        }

    }

    // Bloquear el funcionamiento del botón físico de retroceso
    override fun onBackPressed() {

    }

    // Función encargada de mostrar la opción del jugador al presionar cualquiera
    // de los 5 botones para dar inicio a la jugada
    override fun onClick(v: View) {
        val id = v.id
        when (id) {
            R.id.btn_piedra -> {
                userinput = 1
                input?.setBackgroundResource(R.drawable.piedra)
                setOutput()
            }
            R.id.btn_papel -> {
                userinput = 2
                input?.setBackgroundResource(R.drawable.papel)
                setOutput()
            }
            R.id.btn_tijera -> {
                userinput = 3
                input?.setBackgroundResource(R.drawable.tijera)
                setOutput()
            }
            R.id.btn_lagartija -> {
                userinput = 4
                input?.setBackgroundResource(R.drawable.lagartija)
                setOutput()
            }
            R.id.btn_spock -> {
                userinput = 5
                input?.setBackgroundResource(R.drawable.spock)
                setOutput()
            }
        }
    }

    // Función encargada de generar de manera aleatoria la opción de juego de la IA
    // genera un valor de entre 0 a 4
    private fun setOutput() {
        val imageId = (Math.random() * images.size ).toInt()
        output?.setBackgroundResource(images[imageId])
        checkResult(imageId)
    }


    // Se encarga de evaluar las jugadas de las opciones seleccionadas de ambos lados
    // para poder proceder a determinar el estado del turno.
    private fun checkResult(imageId: Int) {
        if (userinput === 1 && imageId == 0) { // Jugadas Piedra
            showResult(2)
        } else if (userinput === 1 && imageId == 1) {
            showResult(0)
        } else if (userinput === 1 && imageId == 2) {
            showResult(1)
        } else if (userinput == 1 && imageId == 3){
            showResult(1)
        } else if (userinput == 1 && imageId == 4){
            showResult(0)
        } else if (userinput === 2 && imageId == 0) {  // Jugadas-Papel
            showResult(1)
        } else if (userinput === 2 && imageId == 1) {
            showResult(2)
        } else if (userinput === 2 && imageId == 2) {
            showResult(0)
        } else if (userinput === 2 && imageId == 3) {
            showResult(0)
        } else if (userinput === 2 && imageId == 4) {
            showResult(1)
        } else if (userinput === 3 && imageId == 0) { // Jugadas-Tijeras
            showResult(0)
        } else if (userinput === 3 && imageId == 1) {
            showResult(1)
        } else if (userinput === 3 && imageId == 2) {
            showResult(2)
        } else if (userinput === 3 && imageId == 3) {
            showResult(1)
        } else if (userinput === 3 && imageId == 4) {
            showResult(0)
        } else if (userinput === 4 && imageId == 0) { // Jugadas-Lagartija
            showResult(0)
        } else if (userinput === 4 && imageId == 1) {
            showResult(1)
        } else if (userinput === 4 && imageId == 2) {
            showResult(0)
        } else if (userinput === 4 && imageId == 3) {
            showResult(2)
        } else if (userinput === 4 && imageId == 4) {
            showResult(1)
        } else if (userinput === 5 && imageId == 0) { // Jugadas-spock
            showResult(1)
        } else if (userinput === 5 && imageId == 1) {
            showResult(0)
        } else if (userinput === 5 && imageId == 2) {
            showResult(1)
        } else if (userinput === 5 && imageId == 3) {
            showResult(0)
        } else if (userinput === 5 && imageId == 4) {
            showResult(2)
        }
    }


    // Dependiendo de la elección del usuario y la opción generada para la IA
    // después de ser evaluadas las opciones se determinará el resultado del turno.
    private fun showResult(result: Int) {
        when(result){
            0-> Toast.makeText(applicationContext, "PIERDE", Toast.LENGTH_SHORT).show()
            1-> Toast.makeText(applicationContext, "GANA", Toast.LENGTH_SHORT).show()
            else-> Toast.makeText(applicationContext, "EMPATE", Toast.LENGTH_SHORT).show()
        }
        valorin ++
        Toast.makeText(applicationContext, "Seleccione otra opción", Toast.LENGTH_SHORT).show()
        if (valorin == valorout){
            jugar()
        }
    }

    private fun jugar() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
