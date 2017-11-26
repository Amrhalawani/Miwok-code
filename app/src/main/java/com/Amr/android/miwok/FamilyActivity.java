package com.Amr.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("mother" ,"әṭa",R.drawable.family_mother ,R.raw.family_mother));
        words.add(new word("father" ,"әpә" ,R.drawable.family_father,R.raw.family_father));
        words.add(new word("son" ,"angsi" ,R.drawable.family_son,R.raw.family_son));
        words.add(new word("daughter" ,"tune" ,R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new word("older brother" ,"taachi" ,R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new word("younger brother" ,"chalitti",R.drawable.family_younger_brother ,R.raw.family_younger_brother));
        words.add(new word("older sister" ,"teṭe" ,R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new word("younger sister" ,"kolliti" ,R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new word("grandmother" ,"ama" ,R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new word("grandfather" ,"paapa" ,R.drawable.family_grandfather,R.raw.family_grandfather));
        ListView listView = (ListView) findViewById(R.id.list);
        WordAdaptor Adapter = new WordAdaptor (this, words , R.color.category_family);
        listView.setAdapter(Adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView , View view, int position , long l) {
                word w= words.get(position);
                releaseMediaPlayer();

                mMediaPlayer= MediaPlayer.create(FamilyActivity.this, w.getmMiwokAudio());
                mMediaPlayer.start();
                Toast.makeText(FamilyActivity.this , Float.toString(position) ,Toast.LENGTH_SHORT).show();
               // Log.d("myTAG", "Value: " + Float.toString(position) );
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                    //    Toast.makeText(FamilyActivity.this, "i'm done ", Toast.LENGTH_SHORT).show();

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
