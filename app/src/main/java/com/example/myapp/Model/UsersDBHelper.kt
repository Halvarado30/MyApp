package com.example.myapp.Model

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import kotlin.collections.ArrayList
import com.example.myapp.Model.UserModel as UserModel

class UsersDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_DELETE_ENTRIES)
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insertUser(user: UserModel): Boolean {

        val db = writableDatabase


        val values = ContentValues()
        values.put(DBContract.UserEntry.COLUMN_NOMBRE, user.nombre)
        values.put(DBContract.UserEntry.COLUMN_PUNTOS, user.puntos)


        db.insert(DBContract.UserEntry.TABLE_NOMBRE, null, values)

        return true
    }

    @Throws(SQLiteConstraintException::class)
    fun updateUser(user: UserModel): Boolean {

        val db = writableDatabase


        val values = ContentValues()
        values.put(DBContract.UserEntry.COLUMN_NOMBRE, user.nombre)
        values.put(DBContract.UserEntry.COLUMN_PUNTOS, user.puntos)


        val update = db.update(DBContract.UserEntry.TABLE_NOMBRE,values, "nombre = '${user.nombre}'", null )
        println("VALOR UPDATE  $update")

        return true
    }


    @SuppressLint("Recycle")
    fun readAllUsers(nombre: String) : ArrayList<com.example.myapp.Model.UserModel> {
        val users = ArrayList<com.example.myapp.Model.UserModel>()
        val db = writableDatabase
        val cursor: Cursor?
        try {
            cursor = db.rawQuery("select * from " + DBContract.UserEntry.TABLE_NOMBRE + " WHERE " + DBContract.UserEntry.COLUMN_NOMBRE + "='" + nombre + "'", null)
        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }


        var nombre: String
        var puntaje: Int

        if (cursor!!.moveToFirst()) {

            while (!cursor.isAfterLast) {

                nombre = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_NOMBRE))
                puntaje = cursor.getInt(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_PUNTOS))

                users.add(com.example.myapp.Model.UserModel(nombre, puntaje))
                cursor.moveToNext()
            }
        }
        return users
    }


    @SuppressLint("Recycle")
    fun Todos(): ArrayList<com.example.myapp.Model.UserModel> {
        val users = ArrayList<com.example.myapp.Model.UserModel>()
        val db = writableDatabase
        val cursor: Cursor?
        try {
            cursor = db.rawQuery("select * from " + DBContract.UserEntry.TABLE_NOMBRE, null)
        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }


        var nombre: String
        var puntaje: Int

        if (cursor!!.moveToFirst()) {

            while (!cursor.isAfterLast) {

                nombre = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_NOMBRE))
                puntaje = cursor.getInt(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_PUNTOS))

                users.add(com.example.myapp.Model.UserModel(nombre, puntaje))
                cursor.moveToNext()
            }
        }
        return users
    }

    companion object {

        val DATABASE_VERSION = 1
        val DATABASE_NAME = "PPTLS.db"

        private val SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DBContract.UserEntry.TABLE_NOMBRE + " (" +
                    DBContract.UserEntry.COLUMN_NOMBRE + " TEXT," +
                    DBContract.UserEntry.COLUMN_PUNTOS + " TEXT)"

        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DBContract.UserEntry.TABLE_NOMBRE
    }

}