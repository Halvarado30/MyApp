package com.example.myapp.Model


import android.provider.BaseColumns

object DBContract {

    class UserEntry : BaseColumns {
        companion object {
            val TABLE_NOMBRE = "jugador"
            val COLUMN_NOMBRE = "nombre"
            val COLUMN_PUNTOS = "puntos"
        }
    }
}