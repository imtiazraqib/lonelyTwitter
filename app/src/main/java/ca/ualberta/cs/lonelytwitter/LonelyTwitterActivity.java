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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static android.content.ContentValues.TAG;

/**
 * This is the main Activity class
 *
 * @author Imtiaz Raqib
 * @version 1.0
 * @see Tweet
 * @see ImportantTweet
 * @see NormalTweet
 * @since 1.0
 */

public class LonelyTwitterActivity extends Activity {

    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView oldTweetsList;
    private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
    private ArrayAdapter<Tweet> adapter;



    /**
     * Called when the activity is first created.
     *
     * It gets the text that was written by the user using the body tag. It also implements the
     * button for "Save" and "Clear".
     * This method also views the Old Tweets that have been previously saved and not cleared by the
     * user.
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		/*
		To find anything in drawable folder, use R.id.theIDofTheObject
		 */
        bodyText = findViewById(R.id.body);

        Button saveButton = findViewById(R.id.save);
        final Button clearButton = findViewById(R.id.clear);

        oldTweetsList = findViewById(R.id.oldTweetsList);

        saveButton.setOnClickListener(new View.OnClickListener() {

            /**
             * This is associated with a Listener to check when the "Save" button is pressed
             * @param v
             */
            public void onClick(View v) {
                setResult(RESULT_OK);
                String text = bodyText.getText().toString();

                NormalTweet newTweet = new NormalTweet(text);
                tweetList.add(newTweet);

                adapter.notifyDataSetChanged();

                saveInFile();

                //saveInFile(text, new Date(System.currentTimeMillis()));
				/*
				This closes the app every time something is saved in the app
				 */
                //finish();

            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {

            /**
             * This is associated with a Listener to check when the "Clear" button is pressed
             * @param v
             */
            public void onClick(View v) {
                setResult(RESULT_OK);

                adapter.clear();
                oldTweetsList.setAdapter(adapter);

                tweetList.clear();
                saveInFile();
            }
        });

        // ----------------------------------------------------------------------------------------

		/* Based on the Tweet class created for Lab 1
		This is taking use of the constructor function
		 */
//		Tweet firstTweet = new Tweet();
//		Tweet secondTweet = new Tweet();
//        Tweet thirdTweet = new Tweet();
//
//		firstTweet.setMessage("This is the first message");
//        secondTweet.setMessage("This is the second message");
//
//        /*
//        This is explaining the OVER-RIDING method functionality of Java
//        based on the syntax, the javac compiler will decide which instance of the method to use
//         */
//        thirdTweet.setMessage("First Message", "Second Message");
//
//        // Printing the output
//        String temp = firstTweet.getMessage();
//        String temp2 = secondTweet.getMessage();
//        System.out.println(temp);
//        System.out.println(temp2);
//
//        //Printing the output using Log
//        Log.i("The message is", temp);
//        Log.i("The message is", temp2);
//
//        /*
//        Depicting the functionality of Inheritance
//        */
//        ImportantTweet fourthTweet = new ImportantTweet();
//        fourthTweet.setMessage("Hello", "This is the Messsage");

        // ----------------------------------------------------------------------------------------
    }

    /**
     * This method overrides the onStart y default of the activity to make sure the old tweets that
     * were saved in the file by saveInFile() get loaded up and displayed as a List view.
     */
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

        loadFromFile();
		/*
		Adapter is a binder between arrays
		This will call toString which will give back the string ID
		 */
        adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweetList);

        oldTweetsList.setAdapter(adapter);

        /*
        Referencing the FireBase database
         */
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    ImportantTweet tweet = data.getValue(ImportantTweet.class);
                    if (tweet != null) {
                        Log.d(TAG, tweet.getMessage());
                    }
                }
            }

            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    /**
     * This method implements loading the saved tweets by clicking on the save button and displaying
     * them as a list view.
     *
     * This method uses Google's GSON library for persistent data storage.
     *
     * @throws FileNotFoundException e
     */
    private void loadFromFile() {

        //ArrayList<String> tweets = new ArrayList<String>();

        try {
//			FileInputStream fis = openFileInput(FILENAME);
//			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
//			String line = in.readLine();
//			while (line != null) {
//				tweets.add(line);
//				line = in.readLine();

            FileReader in = new FileReader(new File(getFilesDir(), FILENAME));
            Gson gson = new Gson();

            /*
            https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            on Jan 16, 2019
             */
            Type type = new TypeToken<ArrayList<ImportantTweet>>() {
            }.getType();
            tweetList = gson.fromJson(in, type);


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        //return tweets.toArray(new String[tweets.size()]);

    }

    /**
     * This method implements saving the new tweets by clicking on the save button and displaying
     * them as a list view.
     *
     * This method uses Google's GSON library for persistent data storage.
     *
     * @throws FileNotFoundException e
     */
    private void saveInFile() {
        try {

//			FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_APPEND);
//			fos.write(new String(date.toString() + " | " + text)	.getBytes());
//			fos.close();

            /*
            Better than FileOutputStream
            Get the directory of the application and create a file there
             */
            FileWriter out = new FileWriter(new File(getFilesDir(), FILENAME));

            /*
            Converts an object to JSON format
             */
            Gson gson = new Gson();
            gson.toJson(tweetList, out);
            out.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}