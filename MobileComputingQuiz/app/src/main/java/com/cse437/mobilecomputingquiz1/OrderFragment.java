package com.cse437.mobilecomputingquiz1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {

    TextView OrderNum;
    TextView OrderDetails;
    TextView OrderDateTv;
    List<String> OrderArrival;
    List<String> OrderDetailslv;

    Button BackBtn;




    public OrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_order, container, false);

        BackBtn=view.findViewById(R.id.BackBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new TrackerScreenFragment(),null).commit();
            }
        });
        OrderArrival=Arrays.asList(getResources().getStringArray(R.array.order_arrivalDate));
        OrderDetailslv=Arrays.asList(getResources().getStringArray(R.array.order_details));

        OrderDateTv=view.findViewById(R.id.OrderDateTv);
        OrderNum =view.findViewById(R.id.OrderNumTv);
        OrderDetails=view.findViewById(R.id.OrderDetailsTv);


        int PositionSelected = MainActivity.PositionSelected;
        OrderNum.setText(TrackerScreenFragment.Orders.get(PositionSelected));
        OrderDateTv.setText(OrderArrival.get(PositionSelected));
        OrderDetails.setText(OrderDetailslv.get(PositionSelected));





        return view;
    }



}
