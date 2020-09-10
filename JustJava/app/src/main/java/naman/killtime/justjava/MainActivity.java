package naman.killtime.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
        TextView placeorder =findViewById(R.id.final_order);
        placeorder.setText(String.format(getString(R.string.final_label), count,cost));
    }


}