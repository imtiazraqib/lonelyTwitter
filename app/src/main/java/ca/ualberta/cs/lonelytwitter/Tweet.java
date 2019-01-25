/*
 * Class Name: Tweet
 *
 * Version 1.0
 *
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
 * Represents a tweet
 *
 * @author Imtiaz Raqib
 * @version 1.0
 * @see ImportantTweet
 * @since 1.0
 */

// Declaring the class
public abstract class Tweet {

    // Define Attributes
    // Attributes are like variables
    String message;
    String message2;
    Date date;

    // Defining a method
    /*
    1. Give visibility, i.e., public, private, protected.
    2. What is it returning? Nothing == "void"

    Below is the Constructor function and the methods within the constructor function
     */

    // This is a constructor

    /**
     * This is the constructor for the Tweet abstract class
     */
    public void Tweet(){

        message="";
        date = null;
    }

    /**
     * Takes one string and sets it as a tweet message
     * @param tweetmessage
     */
    public void setMessage(String tweetmessage){

        message = tweetmessage;
    }

    /**
     * It returns the tweet as a string
     * @return String
     */
    public String getMessage(){

        return message;
    }

    /*
     OVER-RIDING the setMessage method
     This allows us to use the method in multiple different forms.
     Based on the syntax it is called in, javac will use the appropriate instance of the method.
      */

    /**
     * Takes two strings and sets it as a tweet message
     * @param tweetmessage
     * @param message2
     */
    public void setMessage(String tweetmessage, String message2){
        message = tweetmessage;
        this.message2 = message2;
    }

    /*
    Checks if the superclass has a method called toString, if YES, then it overrides
    If NO, then it gives a compiling error

    Any class that is explicitly mentioning an "extends", will always extend Objects
    Superclass here is Objects
     */

    /**
     * This provides a string representation of the object that it is used for.
     * Tweets are returned as a String object
     *
     * @return String
     */
    @Override
    public String toString() {
        return message;
    }

}

// ------------------------------------------------------------
// Animal tiger = new Animal();
// Tiger would use all the attributes of Animal()

/*
class Animal{

    String name;
    int height;
    int weight;

    public void Animal(){

        this.name = "basic";
        height = 0;
        weight = 0;

    }

    public void Animal(int h, int w){

        // Similar to self.x in python3 class
        this.height = h;
        this.weight = w;
    }
}

*/
// ------------------------------------------------------------