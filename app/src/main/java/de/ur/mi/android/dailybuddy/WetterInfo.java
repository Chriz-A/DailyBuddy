package de.ur.mi.android.dailybuddy;

/**
 * Created by Chris on 22.09.2016.
 */
public class WetterInfo {

    private String city;
    private int temperature;
    private int humidity;
    private int windspeed;
    private int minTemp;
    private int maxTemp;
    private int sunrise;
    private int sunset;

    public WetterInfo (String city, int temperature, int humidity, int windspeed, int minTemp, int maxTemp, int sunrise, int sunset) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windspeed = windspeed;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public String getCity() {
        return city;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getWindspeed() {
        return windspeed;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getSunrise() {
        return sunrise;
    }

    public int getSunset() {
        return sunset;
    }

}
