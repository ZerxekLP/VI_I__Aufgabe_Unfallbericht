package com.example.vi_i__aufgabe_unfallbericht;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AddingIncident extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_incident);
    }

    public void onFinishedClick(View view) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("count.txt")));
        int currantPositon = Integer.parseInt(br.readLine());
        System.out.println(currantPositon);

        //Incident currantIncident = new Incident(currantPositon)
        //ObjectOutputStream oos = new ObjectOutputStream(openFileOutput())
    }
}