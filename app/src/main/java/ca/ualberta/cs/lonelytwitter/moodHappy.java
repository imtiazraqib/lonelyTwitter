package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class moodHappy extends currentMood {

    // Constructor if date is mentioned
    public moodHappy(Date date) {
        super(date);
    }

    // Setter inherited from the parent currentMood
    // Getter inherited from the parent currentMood

    // Format method to return mood
    public String whatMood() {
        return "I am Happy!!";
    }
}
