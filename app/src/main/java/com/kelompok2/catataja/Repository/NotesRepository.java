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
    public LiveData<List<Notes>> hightolow;
    public LiveData<List<Notes>> lowtohigh;


//    NotesDatabase database = NotesDatabase.getDatabaseInstance();

    public NotesRepository(Application application){
        NotesDatabase database = NotesDatabase.getDatabaseInstance(application);
        notesDao = database.notesDao();
        getallNotes = notesDao.getallNotes();
        hightolow = notesDao.hightoLow();
        lowtohigh = notesDao.lowtoHigh();



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
