package com.example.android.coffeeorder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.android.coffeeorder.MainActivity.message;
import static com.example.android.coffeeorder.MainActivity.n;
public class details extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill);
        TextView billText= (TextView)findViewById(R.id.billText);
        billText.setText(message);
    }
    public void submitOrder(View view)
    {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Your coffee order for " + n);
        intent.putExtra(Intent.EXTRA_TEXT, "" + message);
        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }
}
