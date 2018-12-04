package com.cse437.mobcomputing_lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SHOW_BMI extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__bmi);

        textView=findViewById(R.id.YOUR_BMI);

        Intent intent = getIntent();
        String bmi =intent.getStringExtra("bmi");
        textView.setText(bmi);

    }
}
