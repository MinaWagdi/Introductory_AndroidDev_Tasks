package com.cse437.lab6_mobilecomputing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MINA","onReceive");
        if(MainActivity.is_fragmentA){
            B_Fragment FragmentB=new B_Fragment();
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer,FragmentB,null).commit();
            MainActivity.is_fragmentA=false;
        }
        else{
            A_Fragment fragmentA=new A_Fragment();
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragmentA,null).commit();
            MainActivity.is_fragmentA=true;
        }

    }
}
