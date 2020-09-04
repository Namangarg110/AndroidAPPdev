package naman.killtime.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{


    private EditText mWebsiteEditText;
    private EditText mLocationEdittext;
    private EditText mShareEdittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsiteEditText=findViewById(R.id.website_edittext);
        mLocationEdittext=findViewById(R.id.location_edittext);
        mShareEdittext=findViewById(R.id.website_share);


    }

    public void openWebsite(View view)
    {
        String url = mWebsiteEditText.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW,webpage);

        if (intent.resolveActivity(getPackageManager()) !=  null)
        {
            startActivity(intent);
        }
        else
        {
            Log.d("ImplicidIntents","Cant Handle This");
        }
    }

    public void openLocation(View view)
    {
        String location =mLocationEdittext.getText().toString();
        Uri loc=Uri.parse("geo:0,0?q=" + location);
        Intent intent = new Intent(Intent.ACTION_VIEW,loc);

        if (intent.resolveActivity(getPackageManager())!=null)
        {
            startActivity((intent));
        }
        else
        {
            Log.d("ImplicidIntentLOC","CANT HANDLE");
        }
    }

    public void openShare(View view)
    {
        String  share_txt = mShareEdittext.getText().toString();
        String mimeType="text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share This Text With:")
                .setText(share_txt)
                .startChooser();
    }
}