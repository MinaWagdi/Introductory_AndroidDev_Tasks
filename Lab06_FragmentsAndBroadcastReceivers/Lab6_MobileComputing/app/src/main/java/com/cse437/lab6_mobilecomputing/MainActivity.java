package com.cse437.lab6_mobilecomputing;

import android.content.IntentFilter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    MyReciever myReciever;
    IntentFilter filter;
    public static boolean is_fragmentA=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MINA","onCreate");

        filter = new IntentFilter("android.intent.action.TIME_TICK");
        //filter.addAction(getPackageName() + "android.intent.action.TIME_TICK");

        myReciever = new MyReciever();
        registerReceiver(myReciever, filter);

        fragmentManager=getSupportFragmentManager();
        if(findViewById(R.id.fragmentContainer)!=null){
            if(savedInstanceState!=null){
                return;
            }
            else{
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                A_Fragment fragmentA=new A_Fragment();
                fragmentTransaction.add(R.id.fragmentContainer,fragmentA,null);
                fragmentTransaction.commit();

            }
        }
    }

    @Override
    protected  void onResume(){
        registerReceiver(myReciever, filter);
        super.onResume();

    }


    @Override
    protected void onDestroy() {
        unregisterReceiver(myReciever);
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        unregisterReceiver(myReciever);
        super.onPause();
    }
}
