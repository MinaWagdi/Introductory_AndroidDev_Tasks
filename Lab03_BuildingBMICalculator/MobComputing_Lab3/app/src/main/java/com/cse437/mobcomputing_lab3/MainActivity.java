package com.cse437.mobcomputing_lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText weight;
    EditText height;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        weight = findViewById(R.id.editText);
        height = findViewById(R.id.editText2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double w = Integer.parseInt(weight.getText().toString());
                    Log.i("info", "the w is " + w);
                    double h = Integer.parseInt(height.getText().toString());
                    Log.i("info", "the h is " + h);
                    double BMI = (w / h) / h;
                    Log.i("info", "the bmi is " + BMI);

                    Intent intent = new Intent(getApplicationContext(), SHOW_BMI.class);
                    intent.putExtra("bmi", ""+BMI);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "One or more of your entries is wrong, re-enter please", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
