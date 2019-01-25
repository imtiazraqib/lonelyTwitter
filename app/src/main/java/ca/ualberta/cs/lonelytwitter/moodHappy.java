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
 * This class represent the Happy mood
 *
 * @author Imtiaz Raqib
 * @version 1.0
 * @see currentMood
 * @since 1.0
 */
public class moodHappy extends currentMood {

    // Constructor if date is mentioned

    /**
     * This is the constructor that gets the date from the superclass currentMood
     * @param date
     */
    public moodHappy(Date date) {
        super(date);
    }

    // Setter inherited from the parent currentMood
    // Getter inherited from the parent currentMood

    // Format method to return mood

    /**
     * This is taking the abstract format method from currentMood and returns a string representing
     * its mood
     * @return String
     */
    public String whatMood() {
        return "I am Happy!!";
    }
}
