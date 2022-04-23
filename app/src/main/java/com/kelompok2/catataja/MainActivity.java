package com.kelompok2.catataja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kelompok2.catataja.Activity.InsertNotesActivity;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton newNotesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newNotesBtn = findViewById(R.id.newNotesBtn);

        newNotesBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, InsertNotesActivity.class)));

    }
}