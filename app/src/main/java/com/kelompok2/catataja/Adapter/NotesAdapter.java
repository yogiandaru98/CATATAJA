package com.kelompok2.catataja.Adapter;

import static com.kelompok2.catataja.R.*;

import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompok2.catataja.Activity.UpdateNotesActivity;
import com.kelompok2.catataja.MainActivity;
import com.kelompok2.catataja.Model.Notes;
import com.kelompok2.catataja.R;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.notesViewholder> {
    MainActivity mainActivity;
    List<Notes> notes;
    List<Notes> allNotesitem;
    public NotesAdapter(MainActivity mainActivity, List<Notes> notes) {
        this.mainActivity = mainActivity;
        this.notes = notes;
        allNotesitem=new ArrayList<>(notes);
    }

    public void searchNotes(List<Notes> filterredName) {
        this.notes=filterredName;
        notifyDataSetChanged();

    }

    public notesViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new notesViewholder(LayoutInflater.from(mainActivity).inflate(layout.item_notes, parent, false));
    }

    @Override
    public void onBindViewHolder(notesViewholder holder, int position) {

        Notes note = notes.get(position);

        switch (note.notesPriority) {
            case "1":
                holder.notesPriority.setBackgroundResource(drawable.green_shape);
                break;
            case "2":
                holder.notesPriority.setBackgroundResource(drawable.yellow_shape);
                break;
            case "3":
                holder.notesPriority.setBackgroundResource(drawable.red_shape);
                break;
        }

        holder.title.setText(note.notesTitle);
        holder.subtitle.setText(note.notesSubtitle);
        holder.notesDate.setText(note.notesDate);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(mainActivity, UpdateNotesActivity.class);

            intent.putExtra("id", note.id);
            intent.putExtra("title", note.notesTitle);
            intent.putExtra("subtitle", note.notesSubtitle);
            intent.putExtra("priority", note.notesPriority);
            intent.putExtra("note", note.notes);

            mainActivity.startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    static class notesViewholder extends RecyclerView.ViewHolder {
        TextView title, subtitle, notesDate;
        View notesPriority;
        public notesViewholder(View itemView) {
            super(itemView);
        title=itemView.findViewById(R.id.notesTitle);
        subtitle=itemView.findViewById(R.id.notesSubtitle);
        notesDate=itemView.findViewById(R.id.notesDate);
        notesPriority = itemView.findViewById(id.notesPriority);
        }


    }
}
