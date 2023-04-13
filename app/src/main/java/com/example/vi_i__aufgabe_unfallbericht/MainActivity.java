package com.example.vi_i__aufgabe_unfallbericht;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    LinkedList<Incident> ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = new LinkedList<>();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String[] files = fileList();
        File path = getFilesDir();
        for (String file: files) {
            if(!file.equals("count.txt")) {
                String string = path.getPath() + "/" + file;
            }
        }
    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(this, AddingIncident.class);
        startActivity(intent);
    }

    public void fillLinkedList() throws IOException, ClassNotFoundException {

    }
}