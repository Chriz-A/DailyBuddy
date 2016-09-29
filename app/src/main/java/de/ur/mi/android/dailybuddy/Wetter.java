package de.ur.mi.android.dailybuddy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Chris on 23.08.2016.
 */
public class Wetter extends AppCompatActivity  {


    private static final String CITY = "name";
    private static final String TEMPERATURE = "temp";
    private static final String HUMIDITY = "humidity";
    private static final String WINDSPEED = "speed";
    private static final String MINTEMP = "temp_min";
    private static final String MAXTEMP = "temp_max";
    private static final String SUNRISE = "sunrise";
    private static final String SUNSET = "sunset";


    private TextView city;
    private TextView description;
    private TextView temperature;
    private TextView humidity;
    private TextView windspeed;
    private TextView minTemp;
    private TextView maxTemp;
    private TextView sunrise;
    private TextView sunset;
    private TextView icon;
    private EditText place;
    private Button search_place;
    private String address = "";
    private final static String ADDRESS_START = "http://api.openweathermap.org/data/2.5/weather?q=";
    private final String ADDRESS_END = "&units=metric&APPID=107470e295d6b8a56c3d6100ea1a28a4&lang=de";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wetter);
        setActionBarColor();

        place = (EditText) findViewById(R.id.search_place);

        search_place = (Button) findViewById(R.id.button_search);
        new WetterTask().execute(ADDRESS_START + "berlin" + ADDRESS_END);
        search_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
               // address="";
                address = place.getText().toString().toLowerCase().trim();
                new WetterTask().execute(ADDRESS_START + address + ADDRESS_END);
            }
        });
    }



    private void setActionBarColor() {
        ActionBar ab = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(getResources().getString(0+R.color.orange)));
        ab.setBackgroundDrawable(colorDrawable);
    }

    public class WetterTask extends AsyncTask <String, Integer, String>  {




        //private ArrayList<WetterInfo> wetterInfos;


        //public WetterTask(ArrayList<WetterInfo> wetterInfos) {

            //this.wetterInfos = wetterInfos;

            /**private final Wetter Wetter;

             public WetterTask(Wetter Wetter) {
             this.Wetter = Wetter;*/
        //}
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            city = (TextView) findViewById(R.id.city);
            description = (TextView) findViewById(R.id.description);
            temperature = (TextView) findViewById(R.id.temperature);
            humidity = (TextView) findViewById(R.id.value_humidity);
            windspeed = (TextView) findViewById(R.id.value_wind_speed);

            sunrise = (TextView) findViewById(R.id.value_sunrise);
            sunset = (TextView) findViewById(R.id.value_sunset);

         }

        @Override
        protected String doInBackground(String... params) {
            String jsonString = "";

            try {
                URL url = new URL(params[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                int responseCode = conn.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    InputStream is = conn.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line;
                    while ((line = br.readLine()) != null) {
                        jsonString += line;
                    }
                    br.close();
                    is.close();
                    conn.disconnect();
                } else {
                    throw new IllegalStateException("HTTP response: " + responseCode);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return jsonString;
        }

        @Override
        protected void onPostExecute(String result)  {
            super.onPostExecute(result);
            processJson(result);
        }
            /** String test = result;
             try {
             // parse the json result returned from the service
             JSONObject jsonResult = new JSONObject(test);

             // parse out the temperature from the JSON result
             double temperature = jsonResult.getJSONObject(“main”).getDouble(“temp”);
             temperature = ConvertTemperatureToFarenheit(temperature);

             // parse out the pressure from the JSON Result
             double pressure = jsonResult.getJSONObject(“main”).getDouble(“pressure”);

             // parse out the humidity from the JSON result
             double humidity = jsonResult.getJSONObject(“main”).getDouble(“humidity”);

             // parse out the description from the JSON result
             String description = jsonResult.getJSONArray(“weather”).getJSONObject(0).getString(“description”);

             // set all the fields in the activity from the parsed JSON
             this.Wetter.SetDescription(description);
             this.Wetter.SetTemperature(temperature);
             this.Wetter.SetPressure(pressure);
             this.Wetter.SetHumidity(humidity);
             } catch (JSONException e) {
             e.printStackTrace();
             }
             }

             private double ConvertTemperatureToFarenheit(double temperature) {
             return (temperature – 273)* (9/5) + 32;
             }*/

            private void processJson(String text)  {
            try {


                //JSONArray jsonArray = new JSONArray(text);
                 //for (int i = 0; i < jsonArray.length()-1; i++) {
                 //JSONObject jsonObject = jsonArray.getJSONObject(0);

                JSONObject jsonObject = new JSONObject(text);
                /**JSONArray userArray = jsonObject.getJSONArray("user");
                JSONObject contentObject = userArray.getJSONObject(0);
                String id = contentObject.getString("id");
                temperature.setText(id);*/
            JSONObject weatherObject = jsonObject.getJSONArray("weather").getJSONObject(0);
                String valueDescription = weatherObject.getString("description");
                description.setText(valueDescription);
                JSONObject mainObject = jsonObject.getJSONObject("main");
                double valueTemperature = mainObject.getDouble(TEMPERATURE);
                temperature.setText(String.valueOf(Math.round(valueTemperature))+" °C");
                String valueCity = jsonObject.getString(CITY);
                city.setText(String.valueOf(valueCity));
                int valueHumidity = mainObject.getInt(HUMIDITY);
                humidity.setText(String.valueOf(valueHumidity) + "%");
                JSONObject windObject = jsonObject.getJSONObject("wind");
                double valueWindspeed = windObject.getDouble(WINDSPEED);
                windspeed.setText(String.valueOf(Math.round(valueWindspeed)) + " km/h");
                JSONObject sysObject = jsonObject.getJSONObject("sys");
                String valuesCountry = sysObject.getString("country");
                if (valuesCountry.equals("DE")) {
                    long valueSunrise = sysObject.getLong(SUNRISE);
                    Date date = new Date(valueSunrise * 1000);
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    //sdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
                    String formattedDate = sdf.format(date);
                    sunrise.setText(formattedDate + " Uhr");
                } else {
                    sunrise.setText("--:--");
                }
                if (valuesCountry.equals("DE")) {
                    long valueSunset = sysObject.getLong(SUNSET);
                    Date date = new Date(valueSunset * 1000);
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    //sdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
                    String formattedDate = sdf.format(date);
                    sunset.setText(formattedDate + " Uhr");
                 } else {
                    sunset.setText("--:--");
                }
               /** JSONObject windObject = jsonObject.getJSONObject("wind");
                JSONObject sysObject = jsonObject.getJSONObject("sys");
                String valueCity = jsonObject.getString(CITY);
                double valueTemperature = mainObject.getDouble(TEMPERATURE);
                int valueHumidity = mainObject.getInt(HUMIDITY);
                double valueWindspeed = jsonObject.getDouble(WINDSPEED);
                double valueMinTemp = mainObject.getDouble(MINTEMP);
                double valueMaxTemp = mainObject.getDouble(MAXTEMP);
                int valueSunrise = sysObject.getInt(SUNRISE);
                int valueSunset = sysObject.getInt(SUNSET);


                city.setText(valueCity);
                temperature.setText(String.valueOf(valueTemperature));
                humidity.setText(valueHumidity);
                windspeed.setText(String.valueOf(valueWindspeed));
                minTemp.setText(String.valueOf(valueMinTemp));
                maxTemp.setText(String.valueOf(valueMaxTemp));
                sunrise.setText(valueSunrise);
                sunset.setText(valueSunset);



*/
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }




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
