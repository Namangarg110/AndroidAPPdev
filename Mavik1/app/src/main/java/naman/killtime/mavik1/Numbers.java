package naman.killtime.mavik1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

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

        ArrayList<words> numbers=  new ArrayList<words>();
        numbers.add(new words("one","lutti"));
        numbers.add(new words("two","otiiko"));
        numbers.add(new words("three","tolookusu"));
        numbers.add(new words("four","oyyisa"));
        numbers.add(new words("five","massokka"));
        numbers.add(new words("six","temmokka"));
        numbers.add(new words("seven","kenekaku"));
        numbers.add(new words("eight","kawinta"));
        numbers.add(new words("nine","wo'e"));
        numbers.add(new words("ten","na'aacha"));

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

        wordsAdapter wordAdapter = new wordsAdapter(this, numbers);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

    }
}