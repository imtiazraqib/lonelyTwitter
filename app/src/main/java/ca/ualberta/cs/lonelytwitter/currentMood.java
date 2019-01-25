package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class currentMood {

    private Date date;

    // Setting up the constructor function
    public currentMood(Date date) {
        this.date = new Date();
    }

    // Setting up the Setter
    public void setDate(Date dateToSet) {
        date = dateToSet;
    }

    /**
     *
     * @return date
     */
    // Setting up the Getter
    public Date getDate() {
        return date;
    }

    // This is a format method that allows for each mood class to return their respective moods
    public abstract String whatMood();

}