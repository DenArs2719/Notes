package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    private RecyclerView recyclerViewNotes;

    ///create ArrayList,who will contain notes
    private ArrayList<Note> notes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
        notes.add(new Note("Brush","make","Monday",2));
        notes.add(new Note("Football","play","Friday",1));
        notes.add(new Note("Hokey","play","Sunday",3));
        NotesAdapter adapter = new NotesAdapter(notes);

        ///set recyclerView Layout like Linear
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));

        ///set adapter
        recyclerViewNotes.setAdapter(adapter);
    }
}