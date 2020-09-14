package naman.killtime.mavik1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

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
        numbers.add(new words("red", "weṭeṭṭi",R.drawable.color_red));
        numbers.add(new words("mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow));
        numbers.add(new words("dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow));
        numbers.add(new words("green", "chokokki",R.drawable.color_green));
        numbers.add(new words("brown", "ṭakaakki",R.drawable.color_brown));
        numbers.add(new words("gray", "ṭopoppi",R.drawable.color_gray));
        numbers.add(new words("black", "kululli",R.drawable.color_black));
        numbers.add(new words("white", "kelelli",R.drawable.color_white));


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

        wordsAdapter wordAdapter = new wordsAdapter(this, numbers,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }
}