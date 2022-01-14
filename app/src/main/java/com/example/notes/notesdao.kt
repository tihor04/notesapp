package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.nio.charset.CodingErrorAction.IGNORE

@Dao
interface notesdao {
    @Insert
    suspend  fun insert(note:Note)

    @Delete
   suspend fun delete(note:Note)

    @Query("Select * from notes_table order by id ASC")
    fun getAll():  LiveData<List<Note>>
}