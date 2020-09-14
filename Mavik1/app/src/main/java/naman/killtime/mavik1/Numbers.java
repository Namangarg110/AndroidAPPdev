package naman.killtime.mavik1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {
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
        numbers.add(new words("one","lutti",R.drawable.number_one,R.raw.number_one));
        numbers.add(new words("two","otiiko",R.drawable.number_two,R.raw.number_two));
        numbers.add(new words("three","tolookusu",R.drawable.number_three,R.raw.number_three));
        numbers.add(new words("four","oyyisa",R.drawable.number_four,R.raw.number_four));
        numbers.add(new words("five","massokka",R.drawable.number_five,R.raw.number_five));
        numbers.add(new words("six","temmokka",R.drawable.number_six,R.raw.number_six));
        numbers.add(new words("seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        numbers.add(new words("eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        numbers.add(new words("nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        numbers.add(new words("ten","na'aacha",R.drawable.number_ten,R.raw.number_ten));

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

        wordsAdapter wordAdapter = new wordsAdapter(this, numbers,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                words word = numbers.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(Numbers.this,word.getAudioResourceId());
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