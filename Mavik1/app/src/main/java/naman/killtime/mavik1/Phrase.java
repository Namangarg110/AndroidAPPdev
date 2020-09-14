package naman.killtime.mavik1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrase extends AppCompatActivity {
    MediaPlayer mMediaPlayer = new MediaPlayer();
    private MediaPlayer.OnCompletionListener mCompletionListner = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
//                        Toast.makeText(MainActivity.this,"I'm Done",Toast.LENGTH_SHORT).show();

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

//        String[] num = new String[10];
//        num[0]="one";
//        num[1]="two";
//        num[2]="three";
//        num[3]="four";
//        num[4]="five";
//        num[5]="six";
//        num[6]="seven";
//        num[7]="eight";
//        num[8]="nine";
//        num[9]="ten";

        final ArrayList<words> numbers=  new ArrayList<words>();
        numbers.add(new words("Where are you going?", "minto wuksus",R.raw.phrase_where_are_you_going));
        numbers.add(new words("What is your name?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        numbers.add(new words("My name is...", "oyaaset...",R.raw.phrase_my_name_is));
        numbers.add(new words("How are you feeling?", "michәksәs?",R.raw.phrase_how_are_you_feeling));
        numbers.add(new words("I’m feeling good.", "kuchi achit",R.raw.phrase_im_feeling_good));
        numbers.add(new words("Are you coming?", "әәnәs'aa?",R.raw.phrase_are_you_coming));
        numbers.add(new words("Yes, I’m coming.", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        numbers.add(new words("I’m coming.", "әәnәm",R.raw.phrase_im_coming));
        numbers.add(new words("Let’s go.", "yoowutis",R.raw.phrase_lets_go));
        numbers.add(new words("Come here.", "әnni'nem",R.raw.phrase_come_here));

        //Log.v("Number Activity ", "Word at index 0 : " + numbers.get(0));
        // now let's add some views to number activity dynamically!! yay

//        LinearLayout rootView = findViewById(R.id.root_view); // stored root layout in a variable
//
//        int index=0;
//        while (index<numbers.size())
//        {
//            TextView words = new TextView(this);
//            words.setText(numbers.get(index));
//            words.setTextSize();
//            rootView.addView(words);
//            index++;
//        }

//        ArrayAdapter<words> itemsAdapter = new ArrayAdapter<words>(this, R.layout.list_items, numbers);
//
//        ListView listView = (ListView) findViewById(R.id.list);
//
//        listView.setAdapter(itemsAdapter);

        wordsAdapter wordAdapter = new wordsAdapter(this, numbers,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                words word = numbers.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(Phrase.this,word.getAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListner);
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
        super.onStop();
        releaseMediaPlayer();
    }
}