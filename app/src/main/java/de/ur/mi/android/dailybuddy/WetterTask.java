package de.ur.mi.android.dailybuddy;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Chris on 21.09.2016.
 */
public class WetterTask extends AsyncTask<String, Integer, String> {
    private static final String CITY = "name";
    private static final String TEMPERATURE = "temp";

    private ArrayList<WetterInfo> wetterInfos;


    public WetterTask(ArrayList<WetterInfo> wetterInfos) {

        this.wetterInfos = wetterInfos;

    /**private final Wetter Wetter;

    public WetterTask(Wetter Wetter) {
        this.Wetter = Wetter;*/
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
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
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

    //private void processJson(String text) {
        try {
            JSONArray jsonArray = new JSONArray(result);
            for (int i = 0; i < jsonArray.length()-1; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String city = jsonObject.getString(CITY);
                int temperature = jsonObject.getInt(TEMPERATURE);
                WetterInfo wetterInfo = new WetterInfo(city, temperature);
                wetterInfos.add(i, wetterInfo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
