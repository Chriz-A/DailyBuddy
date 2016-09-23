package de.ur.mi.android.dailybuddy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chris on 23.08.2016.
 */
public class Wetter extends AppCompatActivity {

    private ArrayList<WetterInfo> wetterInfos;

    private TextView city;
    private TextView temperature;
    private final static String ADDRESS = "http://api.openweathermap.org/data/2.5/weather?q=regensburg&APPID=107470e295d6b8a56c3d6100ea1a28a4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wetter);
        ActionBar ab = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#ffa500"));
        ab.setBackgroundDrawable(colorDrawable);
        wetterInfos = new ArrayList<WetterInfo>();
        city = (TextView) findViewById(R.id.city);
        temperature = (TextView) findViewById(R.id.temperature);
        WetterInfo p = wetterInfos.get(0);
        city.setText(p.getCity());
        temperature.setText(p.getTemperature());
        new WetterTask(wetterInfos).execute(ADDRESS);
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


        return super.onOptionsItemSelected(item);
    }
}
