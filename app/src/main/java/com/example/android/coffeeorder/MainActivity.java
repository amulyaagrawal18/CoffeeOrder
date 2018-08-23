package com.example.android.coffeeorder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    public static String message="";
    int quantity=1;
    public static String n="";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment(View v)
    {
        quantity= quantity+1;
        if(quantity>100)
        {
            quantity=100;
            Toast.makeText(MainActivity.this, "Sorry, you can't have more than 100 coffees", Toast.LENGTH_LONG).show();
        }
        display1(quantity);
    }
    public void decrement(View v)
    {
        quantity= quantity-1;
        if(quantity<1) {
            quantity = 1;
            Toast.makeText(MainActivity.this, "Sorry, you can't have less than 1 coffee", Toast.LENGTH_LONG).show();
        }
        display1(quantity);
    }
    public void details(View v)
    {
        EditText name = (EditText) findViewById(R.id.name);
        n = name.getText().toString();
        CheckBox cream= (CheckBox)findViewById(R.id.whipped_cream);
        Boolean isWhipped= cream.isChecked();
        CheckBox choco= (CheckBox)findViewById(R.id.whipped_cream);
        Boolean isChoco= choco.isChecked();
        int total = quantity * 5;
        if (isWhipped) {
            total = total + (quantity * 1);
        }
        if (isChoco) {
            total = total + (quantity * 2);
        }
        message = createOrderSummary(quantity, isChoco, isWhipped, n, total);
        Intent detailInt= new Intent(MainActivity.this,details.class);
        startActivity(detailInt);
    }
    public void display1(int d)
    {
        TextView quan= (TextView)findViewById(R.id.quantity_textView);
        quan.setText(""+d);
    }
    public String createOrderSummary(int q, Boolean isChoco, Boolean isWhipped, String name, int t)
    {
        String priceMessage="";
        priceMessage = "Name: "+ name;
        priceMessage+="\nAdd Whipped cream? "+isWhipped;
        priceMessage+= "\n Add Chocolate?" + isChoco;
        priceMessage+= "\n Quantity:" + q ;
        priceMessage+="\nTotal: $" + t;
        priceMessage+= "\n Thank You!";
        return (priceMessage);
    }
}
