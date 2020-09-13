package naman.killtime.mavik1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView numbers = findViewById(R.id.numbers);
        TextView family = findViewById(R.id.family);
        TextView colors = findViewById(R.id.colors);
        TextView phrases = findViewById(R.id.phrases);
        numbers.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent number = new Intent(MainActivity.this,Numbers.class);
                startActivity(number);
            }
        });

        family.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent family = new Intent(MainActivity.this,Family.class);
                startActivity(family);
            }
        });

        colors.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent color = new Intent(MainActivity.this,Colors.class);
                startActivity(color);
            }
        });

        phrases.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent phrase = new Intent(MainActivity.this,Phrase.class);
                startActivity(phrase);
            }
        });
    }
}