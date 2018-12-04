package com.cse437.mobcomputinglab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    Button btn;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              intent  = new Intent(getApplicationContext(),MyService.class);
                Log.i("MINA","Button 1 clicked and will start service" );
              startService(intent);
                Log.i("MINA","Service started" );
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MINA","Stop button will be clicked and should stop" );
                stopService(intent);
                Log.i("MINA","Stop service");
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }
}
