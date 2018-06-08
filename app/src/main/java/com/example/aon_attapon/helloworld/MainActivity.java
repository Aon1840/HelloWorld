package com.example.aon_attapon.helloworld;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvHello, tvResult;
    EditText editText1, editText2;
    Button btnCopy, btnCalculate;
    RadioGroup rgOperator;
    CustomViewGroup viewGroup1, viewGroup2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x; //screen width
        int height = size.y; //screen height

        Toast.makeText(MainActivity.this, "Width = " + width + ", Height = " + height, Toast.LENGTH_LONG).show();
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
        viewGroup1 = (CustomViewGroup) findViewById(R.id.viewGroup1);
        viewGroup2 = (CustomViewGroup) findViewById(R.id.viewGroup2);

        viewGroup1.setButtonText("Hello");
        viewGroup2.setButtonText("World");

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val1 = 0;
                int val2 = 0;
                int sum = 0;

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
                Log.d("Calculation", "Result = " + sum);
                Toast.makeText(MainActivity.this, "Result = " + sum, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("result",sum);

                //Playground
                Coordinate c1 = new Coordinate();
                c1.x = 5;
                c1.y = 10;
                c1.z = 20;
                Bundle bundle = new Bundle();
                bundle.putInt("x", c1.x);
                bundle.putInt("y", c1.y);
                bundle.putInt("z", c1.z);
                intent.putExtra("cBundle",bundle);

                //Serializable Lab
                CoordinateSerializeble c2 = new CoordinateSerializeble();
                c2.x = 5;
                c2.y = 10;
                c2.z = 20;
                intent.putExtra("cSerializable",c2);

                //Parcelable
                CoordinateParcelable c3 = new CoordinateParcelable();
                c3.x = 5;
                c3.y = 10;
                c3.z = 20;
                intent.putExtra("cParcelable", c3);

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //handle click button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Toast.makeText(MainActivity.this, "onOptionItemSelected is running", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //save all thingut

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //restore all thing from method onSaveInstanceState

    }
}
