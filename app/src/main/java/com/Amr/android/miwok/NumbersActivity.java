package com.Amr.android.miwok;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<word> words = new ArrayList<word>();

        words.add(new word("One" ,"lutti" ,R.drawable.number_one,R.raw.number_one));
        words.add(new word("two" ,"otiiko" ,R.drawable.number_two,R.raw.number_two));
        words.add(new word("Three" ,"tolookosu" ,R.drawable.number_three,R.raw.number_three));
        words.add(new word("Four" ,"oyyisa" ,R.drawable.number_four,R.raw.number_four));
        words.add(new word("Five" ,"massokka" ,R.drawable.number_five,R.raw.number_five));
        words.add(new word("Six" ,"temmokka",R.drawable.number_six ,R.raw.number_six));
        words.add(new word("Seven" ,"kenekaku",R.drawable.number_seven ,R.raw.number_seven));
        words.add(new word("Eight" ,"kawinta" ,R.drawable.number_eight,R.raw.number_eight));
        words.add(new word("Nine" ,"wo’e",R.drawable.number_nine ,R.raw.number_nine));
        words.add(new word("Ten" ,"na’aacha",R.drawable.number_ten ,R.raw.number_ten));


        /* int i = 0;
        do {
            words.add(String.valueOf(i));
            i++;
        } while ( i <= 99);
        words.add("Two");
        words.add("three");
        words.add("Four");
        words.add("Five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");
        words.add("11");
        words.add("12");
        words.add("13");
        words.add("14");
        words.add("15");
        words.add("16"); */

        // GridView GridView = (GridView) findViewById(R.id.gridview);
        ListView listView = (ListView) findViewById(R.id.list);
        WordAdaptor Adapter = new WordAdaptor (this, words , R.color.category_numbers);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // ananyomes class ( new ...........)
           @Override
          public void onItemClick(AdapterView<?> adapterView , View view,int position , long l) {
                word w= words.get(position); //el position da da lama bados 3ala awel item berga3 (0) eltany berga3 (1) wehakasa
               //fana sawait object (w) be  bel makan ell hados 3aleh we
               //hena el attr beta3 mediaplayer me7tag ( R.raw. ) elly 7assal kattaly words.add( , , , zawdna 4th ) fa
               //dakhal 3ala word class le variable mAudio weba3den ra7 le class getmMiwokAudio() we ha return meno hena
               //words.get(position) من الاخر دي بجيب منها المكان اللي بدوس عليه
               releaseMediaPlayer(); // when i press new song , release the old one .

               Log.d("NumbersActivity", "Current word: " + w);
               mMediaPlayer= MediaPlayer.create(NumbersActivity.this , w.getmMiwokAudio() );
               mMediaPlayer.start();

               //Toast.makeText(NumbersActivity.this , "0000" ,Toast.LENGTH_SHORT).show();
              // Log.d("myTAG", "Value: " + Float.toString(position) );
               mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                   public void onCompletion(MediaPlayer mp) {
                     //  Toast.makeText(NumbersActivity.this, "i'm done ", Toast.LENGTH_SHORT).show();

                       releaseMediaPlayer();
                   }
               });

           }
      });



    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
    @Override
    protected void onStop() {
        super.onStop(); // lifecycle
        releaseMediaPlayer(); // اقفل الصوت لو الuser قفل الصفحة وفتح اي اكتيفتي او برنامج تاني

    }
}
