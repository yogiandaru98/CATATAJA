package com.kelompok2.catataja.Dao;


import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.kelompok2.catataja.Model.Notes;

@androidx.room.Dao
public interface NotesDao {
    @Query("SELECT * FROM Notes_Database")
    List<Notes> getallNotes();

    @Insert
    void insertNotes(Notes... notes);

    @Query("DELETE FROM Notes_Database WHERE id=:id")
    void deleteNotes(int id);

    @Update
    void insertNotes(Notes notes);


}
