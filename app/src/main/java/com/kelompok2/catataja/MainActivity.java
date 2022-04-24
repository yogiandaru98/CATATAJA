package com.kelompok2.catataja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kelompok2.catataja.Activity.InsertNotesActivity;
import com.kelompok2.catataja.Adapter.NotesAdapter;
import com.kelompok2.catataja.ViewModel.NotesViewModel;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton newNotesBtn;
    NotesViewModel notesViewModel;
    RecyclerView notesRecyclerView;
    NotesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newNotesBtn = findViewById(R.id.newNotesBtn);
        notesRecyclerView = findViewById(R.id.notesRecycler);

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);

        newNotesBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, InsertNotesActivity.class)));
        notesViewModel.getallNotes.observe(this, notes -> {
            notesRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            adapter=new NotesAdapter(MainActivity.this, notes);
            notesRecyclerView.setAdapter(adapter);

        });
    }
}