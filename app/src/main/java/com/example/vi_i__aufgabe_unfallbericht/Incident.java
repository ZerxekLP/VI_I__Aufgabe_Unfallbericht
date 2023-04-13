package com.example.vi_i__aufgabe_unfallbericht;

import java.util.Date;

public class Incident {
    int id;
    String dayOfIncident;
    String time;
    String place;
    int postelCcode;
    String street;
    String nr;
    boolean injured;
    boolean otherDamage;

    public Incident(int id, String dayOfIncident) {
        this.id = id;
        this.dayOfIncident = dayOfIncident;

    }

    @Override
    public String toString() {
        return id + "";
    }
}
