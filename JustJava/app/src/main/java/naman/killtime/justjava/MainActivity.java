package naman.killtime.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count=0;
    int cost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void submitOrder(View view) {

        price(count);
        placeOrder();
    }

    public void display(int number)
    {
        TextView quantity =findViewById(R.id.number);
        quantity.setText(""+count);

    }

    public void price(int number)
    {
        TextView priceText = findViewById(R.id.price);
        priceText.setText("$"+number*5);
        cost = number*5;
    }

    public void increment(View view)
    {
        count++;
        display(count);

    }
    public void decrement(View view)
    {
        count--;
        display(count);

    }
    public void placeOrder()
    {
        EditText name = findViewById(R.id.name);
        String Name = name.getText().toString();
        CheckBox wpdCream = findViewById(R.id.Whipped_Cream);
        boolean whipped =wpdCream.isChecked();
        TextView placeorder =findViewById(R.id.final_order);
//        if (!whipped) {
//            placeorder.setText(String.format(getString(R.string.final_label), Name,count, cost));
//        }
//        else
//        {
//            placeorder.setText(String.format(getString(R.string.final_wpd),Name, count, cost+count));
//        }


        String addresses= "namangarg110@gmail.com",subject=name+"'s Order",attachment;
        if (whipped)
        {
            attachment = String.format("Thank you! \n Name : " +name +" \n You Ordered "+ count +" Coffee with Whipped Cream !! \\n Your Amount = $"+cost+count).toString();
        }
        else
        {
            attachment = String.format("Thank you! \n Name : " +name +" \n You Ordered "+ count +" Coffee!! \\n Your Amount = $"+count).toString();
        }
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "JUST JAVA ORDER FOR "+name);
        intent.putExtra(Intent.EXTRA_TEXT, attachment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        }
    }


