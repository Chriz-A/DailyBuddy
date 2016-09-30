package de.ur.mi.android.dailybuddy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class Notizen extends AppCompatActivity {

    private ListView noteList;
    private ArrayList<String> notes = new ArrayList<String>();
    private NoteAdapter noteAdapter;
    private String noteText = "";
    private NoteDatabase db;
    private TextView noNotes;
    private boolean positionAvailable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notizen);
        setActionBarColor();
        setDB();
        setNoteAdapter();
        addNewNote(noteText);
        createNewNote();
        openNote();
        noteList = (ListView) findViewById(R.id.Notizen);
        noteList.setAdapter(noteAdapter);
        removeListItem();
        updateList();
    }

    private void openNote() {
        noteList = (ListView) findViewById(R.id.Notizen);
        noteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                positionAvailable = true;
                String fullText = notes.get(position);
                Intent i = new Intent(Notizen.this, AddNote.class);
                i.putExtra("fullNote", fullText);
                i.putExtra("listItem", position);
                startActivity(i);
            }
        });
    }

    private void removeListItem() {
        noteList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                removeNote(position);
                Toast.makeText(getApplicationContext(), R.string.notiz_gelöscht,
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void createNewNote() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notizen.this, AddNote.class);
                startActivity(i);
            }
        });
    }

    private void setActionBarColor() {
        ActionBar ab = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(getResources().getString(0+R.color.green)));
        ab.setBackgroundDrawable(colorDrawable);
    }


    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();
    }

    private void setDB() {
        db = new NoteDatabase(this);
        db.open();
    }

    private void setNoteAdapter() {
        ListView list = (ListView) findViewById(R.id.Notizen);
        noteAdapter = new NoteAdapter(this, notes);
        list.setAdapter(noteAdapter);
    }


    private void updateList() {
        notes.clear();
        notes.addAll(db.getAllNotes());
        noNotes = (TextView) findViewById(R.id.notes_not_existing);
        ListView list = (ListView) findViewById(R.id.Notizen);
        list.setEmptyView(noNotes);
        noteAdapter.notifyDataSetChanged();

    }

    private void addNewNote(String noteText) {
        Bundle bundle = getIntent().getExtras();
            if (getIntent().getStringExtra("TextNote") != null) {
                noteText = bundle.getString("TextNote");
                if (positionAvailable) {
                    int position = bundle.getInt("position");
                    removeNote(position);
                }
                positionAvailable = false;
                addNote(noteText);
            }
    }

    private void removeNote(int position) {
        db.removeNote(notes.get(position));
        notes.remove(notes.get(position));
        noteAdapter.notifyDataSetChanged();

    }
    private void addNote(String noteText) {
        db.insertNote(noteText);
        updateList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        switch (id){
            case R.id.home:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                return true;

            case R.id.kalenderansicht_abrufen:
                i = new Intent(this, Kalender.class);
                startActivity(i);
                return true;

            case R.id.notizfunktion_aufrufen:
                i = new Intent(this, Notizen.class);
                startActivity(i);
                return true;

            case R.id.wetterinformationen_abrufen:
                i = new Intent(this, Wetter.class);
                startActivity(i);
                return true;

            case R.id.rechnerfunktion_aufrufen:
                i = new Intent(this, Rechner.class);
                startActivity(i);
                return true;

            case R.id.stopwatch:
                i = new Intent(this, StopWatch.class);
                startActivity(i);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
