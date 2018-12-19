package com.cse437.mobilecomputingquiz1;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrackerScreenFragment extends Fragment {

    public static ListView OrderListView;
    public static ArrayAdapter ListViewAdapter;
    public static List<String> Orders;
    Button LogoutBtn;


    public TrackerScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tracker_screen, container, false);
        LogoutBtn=view.findViewById(R.id.Logout);
        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.HasLogOut=1;
                MainActivity.prefs.edit().putInt("MINA",MainActivity.HasLogOut).apply();
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new LoginScreenFragment(),null).commit();
            }
        });


        Orders = Arrays.asList(getResources().getStringArray(R.array.orders));
        ListViewAdapter= new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,Orders);
        OrderListView=(ListView) view.findViewById(R.id.orderListView);
        OrderListView.setAdapter(ListViewAdapter);

        OrderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //onMessageSendListener.onMessageSend(""+position);
                MainActivity.PositionSelected=position;
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new OrderFragment(),null).commit();

            }
        });




        return view;
    }

}
