package com.example.vi_i__aufgabe_unfallbericht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Date;

public class AddingIncident extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_incident);
    }

    public void onFinishedClick(View view) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("count.txt")));
        int currantPositon = Integer.parseInt(br.readLine());

        TextView dayOfIncident = findViewById(R.id.dayOfInsident);
        Incident currantIncident = new Incident(currantPositon, String.valueOf(dayOfIncident.getText()));

        ObjectOutputStream oos = new ObjectOutputStream(openFileOutput(currantPositon + "", MODE_PRIVATE));
        oos.writeObject(currantIncident);
        oos.close();

        System.out.println(currantPositon);
        br.close();
        currantPositon ++;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(openFileOutput("count.txt", MODE_PRIVATE)));
        bw.write(currantPositon + "");
        bw.close();




        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}