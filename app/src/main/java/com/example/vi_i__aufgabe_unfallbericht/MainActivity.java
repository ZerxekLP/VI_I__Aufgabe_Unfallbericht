package com.example.vi_i__aufgabe_unfallbericht;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<Incident> ap;
    ListView lv;
    LinkedList<Incident> ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 134);
        Log.d("TAG", "onCreate: "+ checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE));
        try {
            FileOutputStream count = openFileOutput("count.txt", MODE_PRIVATE);
            PrintWriter pw = new PrintWriter(count);
            pw.write(fileList().length-1 + "");
            pw.close();
            count.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ap = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lv = findViewById(R.id.listView);
        lv.setAdapter(ap);
        ll = new LinkedList<>();

        Intent returnedItem = getIntent();
        Bundle bundle = returnedItem.getExtras();
        if(bundle != null){
            Incident returendIncident = (Incident) bundle.getSerializable("returendItem");

            for (int i = 0; i < ll.size(); i++) {
                if(ll.get(i).id == returendIncident.id){
                    //ll.get(i).
                }
            }
        }



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Incident selectedItem = ap.getItem(i);

                Intent intent = new Intent(MainActivity.this, AddingIncident.class);
                intent.putExtra("selectedItem", selectedItem);
                startActivity(intent);
            }
        });


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
        br.close();
        for (int i = 1; i < currantPositon ; i++) {
            ObjectInputStream ois = new ObjectInputStream(openFileInput("" + i));

            Object a = ois.readObject();
            if( a != null){
                ap.add((Incident) a);
                //ll.add(a)
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


}