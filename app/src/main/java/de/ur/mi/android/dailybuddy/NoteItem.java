package de.ur.mi.android.dailybuddy;

/**
 * Created by Chris on 25.09.2016.
 */
public class NoteItem {


    private int id;
    private String title;



    public NoteItem(String title){
        this.title = title;
        id = -1;
    }

    public String getTitle(){
        return title;
    }
}
