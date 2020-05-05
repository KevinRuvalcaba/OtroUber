package com.example.otrouber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.otrouber.modelo.Item

class MainActivity : AppCompatActivity() {

    private var despensaFirebase : DespensaFirebase =
        DespensaFirebase()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //despensaFirebase.cargaFirebaseDummy()
    }
    fun agregaItem(view: View){
        despensaFirebase.cargaUnItem(Item("", "Leche", 15))
    }

    fun showAll(view: View){
        despensaFirebase.obtenTodos()
    }

    fun deleteOne(view: View){
        //despensaFirebase.borraUnItem()
    }

    fun deleteAll(view: View){
        despensaFirebase.borraTodo()
    }

    override fun onResume() {
        super.onResume()
    }
    fun obternerTodo(view: View){
        despensaFirebase.obtenTodos()
    }

}
