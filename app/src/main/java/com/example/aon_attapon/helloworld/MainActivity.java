package com.example.aon_attapon.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvHello, tvResult;
    EditText editText1, editText2;
    Button btnCopy, btnCalculate;
    RadioGroup rgOperator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
//        tvHello = (TextView) findViewById(R.id.tvHello);
//        tvHello.setText(Html.fromHtml("<b>Attapon</b>"));
//
//        editText2 = (EditText) findViewById(R.id.editText2);
//
//        btnCopy = (Button) findViewById(R.id.btnCopy);
//
//        editText2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE){
//                    //Copy text in EditText to TextView
//                    tvHello.setText(editText2.getText());
//                    return true;
//                }
//                return false;
//            }
//        });
//
//        btnCopy.setOnClickListener(this);


//        -------------------------------- Start Mash up here --------------------------------------
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        rgOperator = (RadioGroup) findViewById(R.id.rgOperator);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val1 = 0;
                int val2 = 0;
                int sum=0;

                try {
                    val1 = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException n) {

                }

                try {
                    val2 = Integer.parseInt(editText2.getText().toString());
                } catch (NumberFormatException n) {

                }

                switch (rgOperator.getCheckedRadioButtonId()) {
                    case R.id.rbPlus:
                        sum = val1 + val2;
                        break;

                    case R.id.rbMinus:
                        sum = val1 - val2;
                        break;

                    case R.id.rbMultiply:
                        sum = val1 * val2;
                        break;

                    case R.id.rbDivide:
                        sum = val1 / val2;
                        break;
                }

                tvResult.setText(sum + "");
            }
        });
    }


//    @Override
//    public void onClick(View v) {
//        if (v == btnCopy){
//            tvHello.setText(editText2.getText());
//        }
//    }

//    New object for onClickListener
//    View.OnClickListener onClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            tvHello.setText(editText2.getText());
//        }
//    }
}
