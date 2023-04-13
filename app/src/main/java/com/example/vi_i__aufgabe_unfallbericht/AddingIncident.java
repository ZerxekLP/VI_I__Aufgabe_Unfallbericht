package com.example.vi_i__aufgabe_unfallbericht;

import androidx.appcompat.app.AppCompatActivity;

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
        System.out.println(currantPositon);
        br.close();

        /*
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(openFileOutput("count.txt", MODE_PRIVATE)));
        bw.write("2");//loescht altes nicht heraus
        bw.close();

         */

        TextView dayOfIncident = findViewById(R.id.dayOfIncident);
        Incident currantIncident = new Incident(currantPositon, String.valueOf(dayOfIncident.getText()));

        ObjectOutputStream oos = new ObjectOutputStream(openFileOutput(currantPositon + "", MODE_PRIVATE));
    }
}