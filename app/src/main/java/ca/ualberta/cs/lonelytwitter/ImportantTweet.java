package ca.ualberta.cs.lonelytwitter;

/*
Created by Imtiaz Raqib on January 09, 2019
*/

/*
 This is inheritance.
 ImportantTweet will have the same attributes as Tweet

 To have a class inherit attributes of another class, we need to say it EXTENDS that class

 if we make the Tweet class as "ABSTRACT", it cannot be instantiated as new Tweet(); therefore it
 has to be inherited by another class. Thus, we use ImportantTweet() instead
 Abstract forces the developer that you are sharing the code with to implement something, otherwise\
 it will not work.
*/
public class ImportantTweet extends Tweet {

    public void ImportantTweet(String message) {

        this.message = message;
    }

    public void setMessage(String firstMessage, String secondMessage) {

        message = firstMessage;
        message2 = secondMessage;
    }
}
