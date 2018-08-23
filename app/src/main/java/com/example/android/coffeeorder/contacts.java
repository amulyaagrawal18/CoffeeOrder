package com.example.android.coffeeorder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class contacts extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
    }
    public void phone(View view)
    {
        Intent ph = new Intent(Intent.ACTION_DIAL);
        ph.setData(Uri.parse("tel: 9205871191"));
        if (ph.resolveActivity(getPackageManager()) != null) {
            startActivity(ph);
        }
    }
    public void locate(View view)
    {
        Intent loc = new Intent(Intent.ACTION_VIEW);
        loc.setData(Uri.parse("geo: 25.3147935,82.9890697"));
        if (loc.resolveActivity(getPackageManager()) != null) {
            startActivity(loc);
        }
    }
    public void menu(View view)
    {
        Intent menu= new Intent(contacts.this,MainActivity.class);
        startActivity(menu);
    }
}
