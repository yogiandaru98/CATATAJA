package com.kelompok2.catataja.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.kelompok2.catataja.Model.Notes;
import com.kelompok2.catataja.R;
import com.kelompok2.catataja.ViewModel.NotesViewModel;
import com.kelompok2.catataja.databinding.ActivityInsertNotesBinding;
import com.kelompok2.catataja.databinding.ActivityUpdateNotesBinding;
//import com.kelompok2.catataja.databinding.ActivityUpdateNotesBinding;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Toast;

import java.util.Date;

public class UpdateNotesActivity extends AppCompatActivity {

    ActivityUpdateNotesBinding binding;
    String priority = "1";
    String stitle, ssubtitle, snotes, spriority;
    NotesViewModel notesViewModel;
    int iid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityUpdateNotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        iid = getIntent().getIntExtra("id", 0);
        stitle = getIntent().getStringExtra("title");
        ssubtitle = getIntent().getStringExtra("subtitle");
        spriority = getIntent().getStringExtra("priority");
        snotes = getIntent().getStringExtra("note");

        binding.upTitle.setText(stitle);
        binding.upSubtitle.setText(ssubtitle);
        binding.upNotes.setText(snotes);

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);

        binding.greenPriority.setOnClickListener(view -> {

            binding.greenPriority.setImageResource(R.drawable.ic_baseline_check_24);
            binding.yellowPriority.setImageResource(0);
            binding.redPriority.setImageResource(0);
            priority = "1";
        });
        binding.yellowPriority.setOnClickListener(view -> {

            binding.greenPriority.setImageResource(0);
            binding.yellowPriority.setImageResource(R.drawable.ic_baseline_check_24);
            binding.redPriority.setImageResource(0);
            priority = "2";
        });
        binding.redPriority.setOnClickListener(view -> {
            binding.greenPriority.setImageResource(0);
            binding.yellowPriority.setImageResource(0);
            binding.redPriority.setImageResource(R.drawable.ic_baseline_check_24);
            priority = "3";
        });

        binding.updateNotesBtn.setOnClickListener(v -> {
           String title = binding.upTitle.getText().toString();
           String subtitle = binding.upSubtitle.getText().toString();
           String notes = binding.upNotes.getText().toString();

            UpdateNotes(title, subtitle, notes);
        });

    }

    private void UpdateNotes(String title, String subtitle, String notes) {
        Date date = new Date();
        CharSequence sequence= DateFormat.format("MMM d, yyyy", date.getTime());

        Notes updateNotes = new Notes();
        updateNotes.id = iid;
        updateNotes.notesTitle=title;
        updateNotes.notesSubtitle=subtitle;
        updateNotes.notes=notes;
        updateNotes.notesDate=sequence.toString();
        updateNotes.notesPriority=priority;

        notesViewModel.updateNotes(updateNotes);

        Toast.makeText(this, "Catatan Berhasil Diedit", Toast.LENGTH_SHORT).show();

        finish();
    }
}