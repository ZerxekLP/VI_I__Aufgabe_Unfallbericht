package com.example.vi_i__aufgabe_unfallbericht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        //hinzufügen Button
        Button addbutton = (Button) findViewById(R.id.addbutton);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addbuttonclicked(view);
            }
        });




    }

    public void onFinishedClick(View view) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("count.txt")));
        int currantPositon = Integer.parseInt(br.readLine());

        TextView dayOfIncident = findViewById(R.id.dayOfInsident);
        TextView time = findViewById(R.id.time);
        TextView place = findViewById(R.id.place);
        TextView postalCode = findViewById(R.id.postalCcode);
        TextView street = findViewById(R.id.street);
        TextView nr = findViewById(R.id.nr);
        RadioButton injuredRB = findViewById(R.id.injured);
        RadioButton otherDamageRB = findViewById(R.id.otherDamage);

        System.out.println(injuredRB.getText());


        Incident currantIncident = new Incident(currantPositon, String.valueOf(dayOfIncident.getText()), String.valueOf(time.getText()),
                new Place(String.valueOf(place.getText()), Integer.parseInt(String.valueOf(postalCode.getText())),
                        String.valueOf(street.getText()), String.valueOf(nr.getText())));



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

    public void addbuttonclicked(final View source){

    }
}