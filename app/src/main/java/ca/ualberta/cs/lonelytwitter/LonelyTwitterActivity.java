package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<ImportantTweet> tweetList = new ArrayList<ImportantTweet>();
	private ArrayAdapter<ImportantTweet> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		/*
		To find anything in drawable folder, use R.id.theidoftheobject
		 */
		bodyText = (EditText) findViewById(R.id.body);

		Button saveButton = (Button) findViewById(R.id.save);

		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				ImportantTweet tweet = new ImportantTweet();
				tweet.setMessage(text);
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();

                saveInFile();

				//saveInFile(text, new Date(System.currentTimeMillis()));
				/*
				This closes the app every time something is saved in the app
				 */
				//finish();

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

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		loadFromFile();
		/*
		Adapter is a binder between arrays
		This will call toString which will give back the string ID
		 */
		adapter = new ArrayAdapter<ImportantTweet>(this, R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

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
            Type type = new TypeToken<ArrayList<ImportantTweet>>() {}.getType();
            tweetList = gson.fromJson(in, type);


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //return tweets.toArray(new String[tweets.size()]);

    }
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