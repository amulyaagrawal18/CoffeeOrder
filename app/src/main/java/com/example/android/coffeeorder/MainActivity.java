package com.example.android.coffeeorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment(View v)
    {
        quantity= quantity+1;
        if(quantity>=0)
        {
            display1(quantity);
        }
        else
        {
            display1(0);
        }
    }
    public void decrement(View v)
    {
        quantity= quantity-1;
        if(quantity>=0)
        {
            display1(quantity);
        }
        else
        {
            quantity=0;
            display1(quantity);
        }
    }
    public void submitOrder(View view)
    {
        String message= createOrderSummary(quantity);
        if(quantity>0) {
            display1(quantity);
            display2(message);
        }
        else
        {
            display1(0);
            display2(message);
        }
    }
    public void display1(int d)
    {
        TextView quan= (TextView)findViewById(R.id.quantity_textView);
        quan.setText(""+d);
    }
    public void display2(String m)
    {
        TextView prize= (TextView)findViewById(R.id.display_text_view);
        prize.setText(m);
    }
    public String createOrderSummary(int q)
    {
        String priceMessage="";
        if(quantity>0) {
            priceMessage = "Name: Amulya Agrawal\n Quantity:" + q + "\nTotal: $" + (q * 5) + "\n Thank You!";
        }
        else
        {
            priceMessage = "Name: Amulya Agrawal\n Quantity:" + 0 + "\nTotal: $" + (0 * 5) + "\n Thank You!";
        }
        return (priceMessage);
    }
}
