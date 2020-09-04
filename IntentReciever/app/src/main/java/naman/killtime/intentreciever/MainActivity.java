package naman.killtime.intentreciever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Uri uri =intent.getData();

        if (uri!=null)
        {
            String uri_str ="URI :"+ uri.toString();
            TextView textView =findViewById(R.id.text_uri_messsage);
            textView.setText(uri_str);
        }
        else
        {
            Log.d("RECIEVER" , "No URI FOUND ");
        }


    }
}