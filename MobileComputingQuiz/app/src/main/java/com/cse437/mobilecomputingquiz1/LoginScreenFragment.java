package com.cse437.mobilecomputingquiz1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginScreenFragment extends Fragment {

    Button LoginBtn;
    EditText email_edit;
    EditText password_edit;





    public LoginScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login_screen, container, false);

        LoginBtn = view.findViewById(R.id.LoginBtn);
        email_edit = view.findViewById(R.id.email_text);
        password_edit = view.findViewById(R.id.password_text);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.prefs.edit().putInt("MINA",MainActivity.HasLogOut).apply();
                String email = email_edit.getText().toString();
                String password = password_edit.getText().toString();

                if(email.equalsIgnoreCase("quiz@mytracker.com")&&password.equalsIgnoreCase("123456")){
                    if(savedInstanceState!=null){
                        return;
                    }else{
                        MainActivity.HasLogOut=0;
                        MainActivity.prefs.edit().putInt("MINA",MainActivity.HasLogOut).apply();
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new TrackerScreenFragment(),null).commit();
                    }
                }
                else{
                    Toast.makeText(getContext(),"Email and password combination don't match",Toast.LENGTH_LONG).show();
                }
            }
        });



        return view;
    }

}
