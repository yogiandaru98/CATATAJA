package com.kelompok2.catataja.Dao;


import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.kelompok2.catataja.Model.Notes;

import java.util.List;

@androidx.room.Dao
public interface NotesDao {
    @Query("SELECT * FROM Notes_Database")
    LiveData<List<Notes>>getallNotes();

    @Query("SELECT * FROM Notes_Database ORDER BY notes_priority DESC")
    LiveData<List<Notes>>hightoLow();

    @Query("SELECT * FROM Notes_Database ORDER BY notes_priority ASC")
    LiveData<List<Notes>>lowtoHigh();
//    List<Notes> getallNotes();

    @Insert
    void insertNotes(Notes... notes);

    @Query("DELETE FROM Notes_Database WHERE id=:id")
    void deleteNotes(int id);

    @Update
    void updateNotes(Notes notes);


}
