package de.ur.mi.android.dailybuddy;

/**
 * Created by Chris on 22.09.2016.
 */
public class WetterInfo {

    private String city;
    private int temperature;

    public WetterInfo (String city, int temperature) {
        this.city = city;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public int getTemperature() {
        return temperature;
    }
}
