package com.Amr.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("red" ,"weṭeṭṭi" ,R.drawable.color_red, R.raw.color_red));
        words.add(new word("green" , "chokokki" ,R.drawable.color_green,R.raw.color_green));
        words.add(new word("brown" ,"ṭakaakki" ,R.drawable.color_brown, R.raw.color_brown));
        words.add(new word("gray" ,"ṭopoppi" ,R.drawable.color_gray, R.raw.color_gray));
        words.add(new word("black" ,"kululli" ,R.drawable.color_black , R.raw.color_black));
        words.add(new word("white" ,"kelelli" ,R.drawable.color_white, R.raw.color_white));
        words.add(new word("dusty yellow" ,"ṭopiisә" ,R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new word("mustrad yellow" ,"chiwiiṭә" ,R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        ListView listView = (ListView) findViewById(R.id.list);
        WordAdaptor Adapter = new WordAdaptor (this, words , R.color.category_colors);
        listView.setAdapter(Adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                word w = words.get(position); //بياخد من البوزيشين رقمه في الليست جربت احط رقم اشتغل فعلا
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, w.getmMiwokAudio());
                mMediaPlayer.start();
                //Toast.makeText(ColorsActivity.this , toString(position) ,Toast.LENGTH_SHORT).show();
                // Log.d("myTAG", "Value: " + Float.toString(position) );
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                      //  Toast.makeText(ColorsActivity.this, "i'm done ", Toast.LENGTH_SHORT).show();

                        releaseMediaPlayer();
                    }
                });
            }



        });
    }

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
