package com.cse437.lab5_handlingfiles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ProgramActivity extends AppCompatActivity {
    String content;
    String[] program;
    int ProgramID;
    TextView tv;
    ListView lv;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
        try {
            Bundle b = this.getIntent().getExtras();

            content = b.getString(MainActivity.TAG);
            ProgramID=b.getInt("ID");

//            for(int i =0;i<content.length;i++){
//                Log.i(MainActivity.TAG,content[i]+" Finished");
//            }
            Log.i(MainActivity.TAG,"Recieved : "+content);



            program=MainActivity.ParseStringBasedOnNewLine(content);
            program = MainActivity.removeElement(0,program);

            tv=findViewById(R.id.tv2);
            tv.setText(program[0]);
            program = MainActivity.removeElement(0,program);

//
//            Log.i(MainActivity.TAG,"HELLOW");
//            for(int i =0;i<program.length;i++){
//                Log.i(MainActivity.TAG,program[i]+" Finished");
//            }

            lv=(ListView)findViewById(R.id.lv2);
            arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,program);
            lv.setAdapter(arrayAdapter);

        }catch (Exception e){
            e.printStackTrace();
            Log.i(MainActivity.TAG,"EXCEPTION "+e.toString());
        }









    }
}
