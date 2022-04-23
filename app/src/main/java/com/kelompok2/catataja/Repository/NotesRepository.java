package com.kelompok2.catataja.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.kelompok2.catataja.Dao.NotesDao;
import com.kelompok2.catataja.Database.NotesDatabase;
import com.kelompok2.catataja.Model.Notes;

import java.util.List;

public class NotesRepository {

    public NotesDao notesDao;
    public LiveData<List<Notes>> getallNotes;


//    NotesDatabase database = NotesDatabase.getDatabaseInstance();

    public NotesRepository(Application application){
        NotesDatabase database = NotesDatabase.getDatabaseInstance(application);
        notesDao = database.notesDao();
        getallNotes = notesDao.getallNotes();



    }

    public void insertNotes(Notes notes){
        notesDao.insertNotes(notes);
    }
    public void deleteNotes(int id){
        notesDao.deleteNotes(id);
    }
    public void updateNotes(Notes notes){
        notesDao.updateNotes(notes);
    }

}
