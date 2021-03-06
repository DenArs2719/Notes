package com.example.notes;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.Intent.getIntent;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder>
{
    private ArrayList<Note> notes;

    public NotesAdapter(ArrayList<Note> notes)
    {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        ///get our view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder notesViewHolder, int position)
    {
        ///get our note
        Note note = notes.get(position);
        ///set data
        notesViewHolder.textViewTitle.setText(note.getTitle());
        notesViewHolder.textViewDescription.setText(note.getDescription());
        notesViewHolder.textViewDayOfWeek.setText(R.string.day_of_week+note.getDayOfWeek());
        int colorId = 1;
        int priority;

        priority = note.getPriority();
        switch (priority)
        {
            case 1:
                colorId = notesViewHolder.itemView.getResources().getColor(android.R.color.holo_red_light);
                break;
            case 2:
                colorId = notesViewHolder.itemView.getResources().getColor(android.R.color.holo_orange_light);
                break;
            case 3:
                colorId = notesViewHolder.itemView.getResources().getColor(android.R.color.holo_green_light);
                break;
        }
        notesViewHolder.textViewTitle.setBackgroundColor(colorId);

    }


    @Override
    public int getItemCount()
    {
        return notes.size();
    }

    ///нужен,чтобы не занимать много памяти для элементов,когда будем их прокручивать
    ///needed so as not to take up a lot of memory for elements when we scroll through them
    class NotesViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewDayOfWeek;
        private TextView textViewPriority;

        public NotesViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewDayOfWeek = itemView.findViewById(R.id.textViewDayOfWeek);
            textViewPriority = itemView.findViewById(R.id.textViewPriority);

        }
    }
}
