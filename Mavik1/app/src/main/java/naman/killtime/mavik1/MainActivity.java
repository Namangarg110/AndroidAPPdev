package naman.killtime.mavik1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNumbers(View view) {
        Intent numbers = new Intent(this,Numbers.class);
        startActivity(numbers);
    }

    public void openFamily(View view) {
        Intent family = new Intent(this,Family.class);
        startActivity(family);
    }

    public void openColors(View view) {
        Intent colors = new Intent(this,Colors.class);
        startActivity(colors);
    }

    public void openPhrases(View view) {
        Intent phrases = new Intent(this,Phrase.class);
        startActivity(phrases);
    }
}