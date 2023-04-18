package com.example.vi_i__aufgabe_unfallbericht;

import java.io.Serializable;
import java.util.Date;

public class Incident implements Serializable {
    int id;
    String dayOfIncident;
    String time;
    Place place;

    boolean injured;
    boolean otherDamage;

    public Incident(int id, String dayOfIncident, String time, Place place) {
        this.id = id;
        this.dayOfIncident = dayOfIncident;
        this.time = time;
        this.place = place;

    }

    @Override
    public String toString() {
        return id + "";
    }
}
