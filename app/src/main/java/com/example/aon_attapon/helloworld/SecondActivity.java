package com.example.aon_attapon.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        sum = intent.getIntExtra("result",0);
        
        inintInstance();
    }

    private void inintInstance() {
        TextView tvResult_Second = (TextView) findViewById(R.id.tvResult_Second);
        tvResult_Second.setText(sum+"");
    }
}
