/*
 * Copyright 2019 TEAM07
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


/**
 * This class represents the current mood of a tweet
 * @author Imtiaz Raqib
 * @version 1.0
 * @see moodHappy
 * @see moodSad
 * @since 1.0
 */
public abstract class currentMood {

    private Date date;

    // Setting up the constructor function

    /**
     * This is a constructor that gets the date already set by default when a mood has been set
     * @param date
     */
    public currentMood(Date date) {
        this.date = new Date();
    }

    // Setting up the Setter

    /**
     * Sets the date when the mood is set
     *
     * @param dateToSet
     */
    public void setDate(Date dateToSet) {
        date = dateToSet;
    }

    /**
     * Gets the date when the current mood was initially set
     *
     * @return date
     */
    // Setting up the Getter
    public Date getDate() {
        return date;
    }

    // This is a format method that allows for each mood class to return their respective moods

    /**
     * This is a format method that is used by other classes to return a string that showcases
     * what mood they represent
     *
     * @return String
     */
    public abstract String whatMood();

}