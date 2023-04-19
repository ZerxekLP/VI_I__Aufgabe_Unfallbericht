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

    public Incident(int id, String dayOfIncident, String time, Place place, boolean injured, boolean otherDamage) {
        this.id = id;
        this.dayOfIncident = dayOfIncident;
        this.time = time;
        this.place = place;
        this.injured = injured;
        this.otherDamage = otherDamage;
    }

    @Override
    public String toString() {
        return id + "";
    }
}
