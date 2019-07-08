package com.example.webservice_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void volley_test(View view) {
        Intent intent=new Intent(MainActivity.this,VolleyTest.class);
        startActivity(intent);
    }

    public void parse_test(View view) {
        Intent intent2=new Intent(MainActivity.this,JsonParsing.class);
        startActivity(intent2);
    }
}
