package de.ur.mi.android.dailybuddy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Chris on 24.09.2016.
 */
public class AddNote extends AppCompatActivity {

    private EditText newNote;
    private int position;
    private String fullText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_note);
        setActionBarColor();
        newNote = (EditText) findViewById(R.id.note_text);

        Bundle bundle = getIntent().getExtras();
        if (getIntent().getStringExtra("fullNote") != null) {
            fullText = bundle.getString("fullNote");
            newNote.setText(fullText);
            position = bundle.getInt("listItem");

        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddNote.this, Notizen.class);
               /** if (fullText != "") {
                    i.putExtra("position", position);
                    i.putExtra("TextNote", newNote.getText().toString());
                }*/
                if (newNote.getText().toString() != "") {
                    i.putExtra("TextNote", newNote.getText().toString());
                    i.putExtra("position", position);
                }
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Notiz gespeichert",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setActionBarColor() {
        ActionBar ab = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(getResources().getString(0+R.color.green)));
        ab.setBackgroundDrawable(colorDrawable);
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

       /** if (id == R.id.home) {
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
        }*/


        return super.onOptionsItemSelected(item);
    }

}
