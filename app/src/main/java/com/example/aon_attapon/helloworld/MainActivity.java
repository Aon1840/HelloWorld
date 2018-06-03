package com.example.aon_attapon.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvHello = (TextView) findViewById(R.id.tvHello);
        tvHello.setText(Html.fromHtml("<b>Attapon</b>"));

        final EditText editText2 = (EditText) findViewById(R.id.editText2);

        Button btnCopy = (Button) findViewById(R.id.btnCopy);

        editText2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    //Copy text in EditText to TextView
                    tvHello.setText(editText2.getText());
                    return true;
                }
                return false;
            }
        });

        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHello.setText(editText2.getText());
            }
        });
    }
}
