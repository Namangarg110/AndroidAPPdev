package naman.killtime.mavik1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Family extends AppCompatActivity {

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
        numbers.add(new words("father", "әpә",R.drawable.family_father));
        numbers.add(new words("mother", "әṭa",R.drawable.family_mother));
        numbers.add(new words("son", "angsi",R.drawable.family_son));
        numbers.add(new words("daughter", "tune",R.drawable.family_daughter));
        numbers.add(new words("older brother", "taachi",R.drawable.family_older_brother));
        numbers.add(new words("younger brother", "chalitti",R.drawable.family_younger_brother));
        numbers.add(new words("older sister", "teṭe",R.drawable.family_older_sister));
        numbers.add(new words("younger sister", "kolliti",R.drawable.family_younger_sister));
        numbers.add(new words("grandmother ", "ama",R.drawable.family_grandmother));
        numbers.add(new words("grandfather", "paapa",R.drawable.family_grandmother));

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

        wordsAdapter wordAdapter = new wordsAdapter(this, numbers,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }
}