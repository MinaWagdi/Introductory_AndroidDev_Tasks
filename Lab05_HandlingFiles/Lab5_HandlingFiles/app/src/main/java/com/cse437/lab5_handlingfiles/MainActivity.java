package com.cse437.lab5_handlingfiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "SPLINTER";
    String filename;
    InputStream inputStream;
    String content;
    ArrayAdapter arrayAdapter;
    ListView programs_listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        File file = new File(getApplicationContext().getFilesDir(),"SPLINTER001");

//        try{
//            File directory = getApplicationContext().getFilesDir();
//            Log.i(TAG, "Path is "+directory.getPath());
//            Log.i(TAG, "toString is "+directory.toString());
//            Log.i(TAG, "AbsolutePath is "+directory.getAbsolutePath());
//            Log.i(TAG, "Canonical Path is "+directory.getCanonicalPath());
//            Log.i(TAG, "directory "+directory);
//        }
//        catch(Exception e){
//            Log.i(TAG,"Exception "+e.toString());
//        }

        try{
            filename="handling_files";
            inputStream =getAssets().open("handling_files.txt");

            content="";
            //another way to access the file
//            int i;
//            while ((i= inputStream.read())!=-1){
//                content+=(char)i;
//            }
//            inputStream.close();
//            Log.i(TAG,"Content is "+content);

            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            content=new String(buffer);
            //Log.i(TAG,"Content is "+content);

        } catch (Exception e){
            Log.i(TAG,"Exception !! "+e.toString());
            e.printStackTrace();
        }

        final String[] contentParsed= ParseStringBasedOnSemiColon(content);
//        Log.i(TAG,"Printing content Parsed based on semi colon");
//        for(int i =0;i<contentParsed.length;i++){
//            Log.i(TAG,contentParsed[i]+" Finished");
//        }


        String[] programs = ParseStringBasedOnNewLine(contentParsed[0]);
//        Log.i(TAG,"Printing first part Parsed based  on new line");
//        for(int i =0;i<programs.length;i++){
//            Log.i(TAG,programs[i]+" Finished");
//        }
        programs=removeElement(0,programs);

        programs_listView=(ListView) findViewById(R.id.programs_listView);
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,programs);
        programs_listView.setAdapter(arrayAdapter);

        programs_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    Bundle b = new Bundle();
                    Log.i(TAG,"ID is "+id);
                    Log.i(TAG,"Position is "+position);
//                    String to_send=contentParsed[(int)id+1];
                    String itemClicked = (String)programs_listView.getItemAtPosition(position);
                    Log.i(TAG,"Item clicked is "+itemClicked);
                    int toSend_Index=searchForItem(itemClicked,contentParsed);
                    b.putString(TAG, contentParsed[toSend_Index]);
                    Log.i(TAG,"Sending "+contentParsed[toSend_Index]);
                    b.putInt("ID", position);
                    Intent intent = new Intent(getApplicationContext(), ProgramActivity.class);
                    intent.putExtras(b);
                    startActivity(intent);
                }catch (Exception e){
                    Log.i(TAG,"EXCEPTION "+e.toString());
                    e.printStackTrace();
                }
            }
        });




    }

    public int searchForItem(String program, String[]content){
        for(int i =0;i<content.length;i++){
            if(content[i].contains("Program "+program)){
                return i;
            }
        }
        return 0;
    }

    public static String[] ParseStringBasedOnSemiColon(String c){

        String[]parts = c.split(";");
        return parts;
    }
    public static String[] ParseStringBasedOnNewLine(String c){

        String[]parts = c.split("\\r?\\n");
        return parts;
    }
    public static String[] removeElement(int element,String[] array){
        for(int i = 0; i < array.length; i++){
            if(i == element){
                array = removeElementUsingCollection(array, i);
                break;
            }
        }
        return array;
    }

    public static String[] removeElementUsingCollection( String[] arr, int index ){
        List<String> tempList = new ArrayList<String>(Arrays.asList(arr));
        tempList.remove(index);
        return tempList.toArray(new String[0]);
    }

}
