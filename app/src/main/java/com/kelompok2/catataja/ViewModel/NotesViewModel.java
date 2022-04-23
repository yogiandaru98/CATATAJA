package com.kelompok2.catataja.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.kelompok2.catataja.Model.Notes;
import com.kelompok2.catataja.Repository.NotesRepository;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {

    public NotesRepository repository;
    public LiveData<List<Notes>> getallNotes;

    public NotesViewModel(Application application) {
        super(application);

        repository=new NotesRepository(application);
        getallNotes=repository.getallNotes;


    }

    public void insertNotes(Notes notes){
        repository.insertNotes(notes);
    }
    public void deleteNotes(int id){
        repository.deleteNotes(id);
    }
    public void updateNotes(Notes notes){
        repository.updateNotes(notes);
    }

}
