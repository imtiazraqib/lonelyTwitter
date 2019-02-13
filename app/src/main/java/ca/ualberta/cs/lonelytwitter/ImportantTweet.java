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

import java.util.Date;
import java.util.UUID;

/**
 * This represents a tweet and is mainly used to instantiate the abstract Tweet object
 *
 * @author Imtiaz Raqib
 * @version 1.0
 * @see Tweet
 * @since 1.0
 */
public class ImportantTweet extends Tweet implements Tweetable {

    public ImportantTweet() {

    }

    public ImportantTweet(String message){
        super(message);
    }

    public ImportantTweet(String message, Date date) {
        super(message, date);
    }


    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }
}