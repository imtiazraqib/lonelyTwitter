package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class moodSad extends currentMood {

    // Constructor
    public moodSad(Date date) {
        super(date);
    }

    // Setter inherited from the parent currentMood
    // Getter inherited from the parent currentMood

    // Format method to return the mood
    public String whatMood() {
        return "I am sad... boohoo";
    }
}
