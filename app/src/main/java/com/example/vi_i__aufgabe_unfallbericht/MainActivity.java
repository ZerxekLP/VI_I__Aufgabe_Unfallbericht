package com.example.vi_i__aufgabe_unfallbericht;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<Incident> ap;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ap = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lv = findViewById(R.id.listView);
        lv.setAdapter(ap);

        Button addbuttonmain = (Button) findViewById(R.id.addbuttonmain);
        addbuttonmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addbuttonmainclicked(view);
            }
        });
//demo



    }



    @Override
    protected void onResume() {
        super.onResume();
        try {
            intoListView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void intoListView() throws IOException, ClassNotFoundException {

        BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("count.txt")));
        int currantPositon = Integer.parseInt(br.readLine());
        for (int i = 1; i < currantPositon ; i++) {
            ObjectInputStream ois = new ObjectInputStream(openFileInput("" + i));

            Object a = ois.readObject();
            if( a != null){
                ap.add((Incident) a);
            }

        }
        ap.notifyDataSetChanged();


        /*
        String[] files = fileList();
        File path = getFilesDir();
        for (String file: files) {
            if(!file.equals("count.txt")) {
                String string = path.getPath() + "/" + file;
                ll.add(string);
                ap.notifyDataSetChanged();

            }
        }

         */
    }



    public void onButtonClick(View view) {
        Intent intent = new Intent(this, AddingIncident.class);
        startActivity(intent);
    }

    public void  addbuttonmainclicked(final View source){

    }

}