package com.example.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Appendable
import java.text.Normalizer

class noteViewModel(application:Application) :AndroidViewModel(application) {

    private val repo:NoteRepository
    val allnotes :LiveData<List<Note>>


    init{
        val Dao =NoteDataBase.getDatabase(application).getNoteDao()
        repo= NoteRepository(Dao)
        allnotes=repo.allnotes
    }

    fun deleteNote(note:Note)=viewModelScope.launch(Dispatchers.IO){
    repo.deletenote(note)

    }

    fun insertNote(note:Note)=viewModelScope.launch(Dispatchers.IO){
        repo.insertnote(note)
    }
}