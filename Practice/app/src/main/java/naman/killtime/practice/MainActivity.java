    package naman.killtime.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

    public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE=
                "naman.killtime.intents.extra.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void helloActivity(View view)
        {
            Intent hello = new Intent(this,message.class);
            String message = " How you doin'? ";
            hello.putExtra(EXTRA_MESSAGE,message);
            startActivity(hello);
        }

        public void byeActivity(View view)
        {
            Intent hello = new Intent(this,message.class);
            String message = " Smelly Cat Smelly Cat  ";
            hello.putExtra(EXTRA_MESSAGE,message);
            startActivity(hello);
        }

        public void nogloryActivity(View view)
        {
            Intent hello = new Intent(this,message.class);
            String message = " We Were on a BREAKKKK!";
            hello.putExtra(EXTRA_MESSAGE,message);
            startActivity(hello);
        }
    }