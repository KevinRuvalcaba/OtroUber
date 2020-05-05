package com.example.otrouber.fragmentos

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.example.otrouber.DespensaFirebase

import com.example.otrouber.R

import kotlinx.android.synthetic.main.fragment_update_one.*

/**
 * A simple [Fragment] subclass.
 */
class UpdateOneFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_one, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        send_update.setOnClickListener {
            val despensaFirebase = DespensaFirebase()
            val nombre = description_edittext.text.toString()
            val cantidad = cantidad_update.text.toString().toInt()
            despensaFirebase.modificaUnItem(nombre, cantidad)
            context!!.hideKeyboard(it)

        }
    }
    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
