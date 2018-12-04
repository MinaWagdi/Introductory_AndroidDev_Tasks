package com.cse437.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button cairo,alex,aswan;
    TextView info_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        cairo = new Button();
//        alex = new Button();
//        aswan= new Button();
        cairo= findViewById(R.id.CairoBtn);
        alex= findViewById(R.id.AlexBtn);
        aswan= findViewById(R.id.AswanBtn);

        info_text=findViewById(R.id.info_text);

        try {
            if (savedInstanceState != null) {
                String retrieved_info = savedInstanceState.getString("INFO_CITY");
                info_text.setText(retrieved_info);
            }
        }catch(Exception ex){
            Log.i("MINAS_AWESOME","exception when trying to retrieve the saved State is "+ex.getClass());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        try {
            outState.putString("INFO_CITY", info_text.getText().toString());
        }catch (Exception ex){
            Log.i("MINAS_AWESOME","exception when trying to save the state is "+ex.getClass());
        }


    }



    public void showCairoInfo(View v){
        info_text.setText(R.string.cairo_info);
    }

    public void showAlexInfo(View v){
        info_text.setText(R.string.alex_info);
    }

    public void showAswanInfo(View v){
        info_text.setText(R.string.aswan_info);
    }
}
