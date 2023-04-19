package com.example.vi_i__aufgabe_unfallbericht;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityViewCommand;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class witness extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_witness);

        Button okbutton = (Button) findViewById(R.id.okbutton);
        Button cancelbutton = (Button) findViewById(R.id.cancelbutton);
        Button loeschenbutton = (Button) findViewById(R.id.loeschenbutton);

        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                okbuttononlicked(view);
            }
        });

        cancelbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelbuttononlicked(view);
            }
        });

        loeschenbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loeschenbuttononlicked(view);
            }
        });
    }

    public void okbuttononlicked(final View source){

    }

    public void cancelbuttononlicked(final View source){

    }

    public void loeschenbuttononlicked(final View source){

    }
}