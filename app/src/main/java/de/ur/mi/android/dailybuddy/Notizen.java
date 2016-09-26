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
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Chris on 23.08.2016.
 */
public class Notizen extends AppCompatActivity {

    ListView noteList;

    private ArrayList<String> notes;
    private ArrayAdapter<String> noteAdapter;
    private String textContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notizen);
        ActionBar ab = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#2b7b3d"));
        ab.setBackgroundDrawable(colorDrawable);
        notes = new ArrayList<String>();
        noteAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notes);
        Bundle bundle = getIntent().getExtras();
        if (getIntent().getStringExtra("TextContent") != null) {
            textContent = bundle.getString("TextContent");
            addNote(textContent);

        }
        noteList = (ListView) findViewById(R.id.Notizen);
        noteList.setAdapter(noteAdapter);
        noteList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                removeTaskAtPosition(position);
                Toast.makeText(getApplicationContext(), R.string.notiz_gelöscht,
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        noteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                String fullText = notes.get(position);
                Intent i = new Intent(Notizen.this, AddNote.class);
                i.putExtra("fullNote", fullText);
                startActivity(i);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notizen.this, AddNote.class);
                startActivity(i);
            }
        });

    }

    private void removeTaskAtPosition(int position) {

            notes.remove(position);
            noteAdapter.notifyDataSetChanged();

    }

    private void addNote(String textContent) {

            notes.add(textContent);
            noteAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notizen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.home) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.kalenderansicht_abrufen) {
            Intent i = new Intent(this, Kalender.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.notizfunktion_aufrufen) {
            Intent i = new Intent(this, Notizen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.wetterinformationen_abrufen) {
            Intent i = new Intent(this, Wetter.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.rechnerfunktion_aufrufen) {
            Intent i = new Intent(this, Rechner.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.stopwatch) {
            Intent i = new Intent(this, StopWatch.class);
            startActivity(i);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
