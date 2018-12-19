package com.cse437.mobilecomputingquiz1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static int PositionSelected;
    public static SharedPreferences prefs;
    public static int HasLogOut=0;

    public static ListView OrderListView;
    public static ArrayAdapter ListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        prefs = this.getSharedPreferences(
                "MINA", Context.MODE_PRIVATE);

        fragmentManager=getSupportFragmentManager();
        if(savedInstanceState!=null){
            return;
        }
        else{

            LoginScreenFragment loginScreenFragment= new LoginScreenFragment();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            int loggedOut=prefs.getInt("MINA",1 );
            if(loggedOut==1){
                fragmentTransaction.add(R.id.fragmentContainer,loginScreenFragment,null);
            }
            else{
                fragmentTransaction.add(R.id.fragmentContainer,new TrackerScreenFragment(),null);
            }

            fragmentTransaction.commit();

        }
    }
}
