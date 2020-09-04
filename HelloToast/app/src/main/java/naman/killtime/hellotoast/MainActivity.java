package naman.killtime.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    public static String EXTRA_MESSAGE = "naman.killtime.HelloToast.extra.MESSAGE";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public int mCount=0;
    private TextView mShowCount;
    private TextView mPassCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);

    }
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();

    }

    public int countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        return mCount;
    }

    public void launchSecondActivity(View view)
    {
        Log.d(LOG_TAG," SAY HELLO button clicked");
        Intent intent= new Intent(this , SecondActivity.class);
        String Value =Integer.toString(mCount);
        intent.putExtra(EXTRA_MESSAGE,Value);
        startActivity(intent);
    }
}
