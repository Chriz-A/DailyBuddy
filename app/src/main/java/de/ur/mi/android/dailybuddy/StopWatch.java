package de.ur.mi.android.dailybuddy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

/**
 * Created by Chris on 25.09.2016.
 */
public class StopWatch extends AppCompatActivity{

    private Chronometer chronometer;
    private TextView time;
    private Button start_pause;
    private Button stop;
    private long stoppedTime;
    private boolean firstStart = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stopwatch);
        setActionBarColor();
        setChronometer();
        start_pause = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        start_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                changeButton();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                resetTime();
            }
        });
    }

    private void setChronometer() {
        chronometer = (Chronometer) findViewById(R.id.time);
    }

    private void resetTime() {
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.stop();
    }

    private void changeButton() {
        String buttonText = start_pause.getText().toString();
        if (buttonText.equals("Start")) {
            if (firstStart){
                start_pause.setText(R.string.pause);
                chronometer.start();
                firstStart = false;
            } else {


                start_pause.setText(R.string.pause);
                //long elapsedTime = SystemClock.elapsedRealtime() - chronometer.getBase();
                chronometer.setBase(chronometer.getBase() + SystemClock.elapsedRealtime() - stoppedTime);
                chronometer.start();
            }
        } else if (buttonText.equals("Pause")){
            start_pause.setText(R.string.start);
            stoppedTime = SystemClock.elapsedRealtime();
            chronometer.stop();

        }
    }

    private void setActionBarColor() {
        ActionBar ab = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(getResources().getString(0+R.color.black)));
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



        return super.onOptionsItemSelected(item);
    }
}
