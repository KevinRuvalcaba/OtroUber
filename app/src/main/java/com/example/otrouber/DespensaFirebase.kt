package com.example.otrouber

import android.util.Log
import com.example.otrouber.modelo.Item
import com.google.firebase.database.*

class DespensaFirebase {
    private lateinit var database: DatabaseReference
    constructor(){
        database = FirebaseDatabase.getInstance().reference
    }
    fun cargaFirebaseDummy(){
        val items: List<Item> = mutableListOf(
            Item("", "Leche", 15),
            Item("", "Pan", 1),
            Item("", "Pasta", 15),
            Item("", "Arroz", 3),
            Item("", "Frijol", 5)
        )
        items.forEach{
            val key = database.child("despensa").push().key
            //it.id = key
            database.child("despensa").child(key!!).setValue(it)
        }


    }
//Completa los siguientes métodos
    // y crea una pequeña interfaz en la app
    // para probar cada método.
    // Todas las salidas se ven en consola
    // Pueden usar: https://firebase.google.com/docs/database/android/start

    fun cargaUnItem(item: Item){
        val key = database.child("despensa").push().key
        if (key != null) {
            item.id = key
        }
        database.child("despensa").child(key!!).setValue(item)
        Log.d("holaaaaa", database.child("despensa").orderByKey().toString())

    }


    fun borraUnItem( key: String){
        database.child("despensa").child(key).removeValue()
    }

    fun borraTodo( ){

        database.child("despensa").removeValue()
    }

    fun modificaUnItem( desc: String, nuevaCantidad: Int){
            database.child("despensa").orderByChild("descripcion").equalTo(desc).addListenerForSingleValueEvent( object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.children
                println("$value")
                value.forEach{
                    Log.d("test", "Value is: ${it.getValue(object: GenericTypeIndicator<Item>(){})?.id}")
                    val idName = it.getValue(object: GenericTypeIndicator<Item>(){})?.id
                    database.child("despensa").child(idName!!).child("cantidad").setValue(nuevaCantidad)
                }


                //Log.d("test", "Value is: $value")
            }
                override fun onCancelled(error: DatabaseError) {
                    // Failed to read value
                    Log.w("TAG", "Failed to read value.", error.toException())
                }
        })
        Log.d("test","WOOOOOOOOW")

    }
    /*
    fun obtenTodos( ){
        // Read from the database
        database.child("despensa").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.value
                println("$value")
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

    }
    */

    fun obtenTodos( ){
        val itemList = database.child("despensa").limitToFirst(10)

    }
}