package com.example.otrouber.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.otrouber.R
import com.example.otrouber.DespensaFirebase
import kotlinx.android.synthetic.main.fragment_alta.*
import kotlinx.android.synthetic.main.fragment_delete_all.*


class DeleteAllFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete_all, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        deleteAll.setOnClickListener {
            val despensaFirebase = DespensaFirebase()
            despensaFirebase.borraTodo()

        }
    }


}
