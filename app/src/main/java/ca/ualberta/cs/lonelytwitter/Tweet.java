package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/*
Created by Imtiaz Raqib on January 09, 2019
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
    public void Tweet(){

        message="";
        date = null;
    }

    public void setMessage(String tweetmessage){

        message = tweetmessage;
    }

    public String getMessage(){

        return message;
    }

    /*
     OVER-RIDING the setMessage method
     This allows us to use the method in multiple different forms.
     Based on the syntax it is called in, javac will use the appropriate instance of the method.
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