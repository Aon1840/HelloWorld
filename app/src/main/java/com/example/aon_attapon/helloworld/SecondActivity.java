package com.example.aon_attapon.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    int sum = 0;
    EditText editTextSecond;

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

        editTextSecond = (EditText) findViewById(R.id.editTextSecond);


        //Lab90 Terminate Activity
        Button btnOK = (Button) findViewById(R.id.btnOK);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retunIntent = new Intent();

                //getText from Editext
                String res = editTextSecond.getText().toString();
                retunIntent.putExtra("result",res);
                setResult(RESULT_OK,retunIntent);


                finish();
            }
        });

    }


}
