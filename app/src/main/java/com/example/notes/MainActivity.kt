package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Inotes {

    lateinit var viewModel:noteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //calling the viewmodel from a differnt class

        recyclerview.layoutManager=LinearLayoutManager(this)

        val adapter= notesadapter(this,this)

        recyclerview.adapter=adapter


  viewModel=ViewModelProvider(this,
  ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(noteViewModel::class.java)

        viewModel.allnotes.observe(this, Observer{list->
            list?.let {
                adapter.updatelist(it)
            }
        })

    }

    override fun onClicked(note: Note) {
     viewModel.deleteNote(note)
        Toast.makeText(this,"Note Deleted",Toast.LENGTH_SHORT).show()
    }
    fun submitdata(view: View)
    {
        val notetext=edittext.text.toString()
        if(notetext.isNotEmpty())
        {
            viewModel.insertNote(Note(notetext))
            Toast.makeText(this,"Note added",Toast.LENGTH_SHORT).show()
        }
    }
}