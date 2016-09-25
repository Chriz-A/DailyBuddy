package de.ur.mi.android.dailybuddy;

/**
 * Created by Chris on 25.09.2016.
 */
public class NoteItem {

    private String textPreview;

    public NoteItem(String textPreview){
        this.textPreview = textPreview;
    }

    public String getTextPreview(){
        return textPreview;
    }
}
