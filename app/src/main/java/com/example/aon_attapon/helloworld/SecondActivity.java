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

        Bundle bundle = intent.getBundleExtra("cBundle");
        int x = bundle.getInt("x");
        int y = bundle.getInt("y");
        int z = bundle.getInt("z");

        CoordinateSerializeble c2 = (CoordinateSerializeble) intent.getSerializableExtra("cSerializable");

        CoordinateParcelable c3 = intent.getParcelableExtra("cParcelable");

        inintInstance();
    }

    private void inintInstance() {
        TextView tvResult_Second = (TextView) findViewById(R.id.tvResult_Second);
        tvResult_Second.setText(sum+"");
    }
}
