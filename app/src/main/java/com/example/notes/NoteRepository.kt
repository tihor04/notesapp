package com.example.notes

import android.app.AsyncNotedAppOp
import androidx.lifecycle.LiveData

class NoteRepository(private val NoteDao:notesdao) {

 //this fun help us get all the node in our database
    val allnotes : LiveData<List<Note>>   =   NoteDao.getAll()


    //if we find any data form the source that is not in the local database then we append it from here
    suspend fun insertnote(note:Note)
    {
        NoteDao.insert(note)
    }

    suspend fun  deletenote(note:Note)
    {
        NoteDao.delete(note)
    }

}