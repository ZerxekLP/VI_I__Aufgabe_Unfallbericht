package com.example.vi_i__aufgabe_unfallbericht;

import java.util.Date;

public class Incident {
    int id;
    Date dayOfIncident;
    String time;
    String place;
    int postelCcode;
    String street;
    String nr;
    boolean injured;
    boolean otherDamage;

    public Incident(int id, Date dayOfIncident, String time, String place, int postelCcode, String street, String nr, boolean injured, boolean otherDamage) {
        this.id = id;
        this.dayOfIncident = dayOfIncident;
        this.time = time;
        this.place = place;
        this.postelCcode = postelCcode;
        this.street = street;
        this.nr = nr;
        this.injured = injured;
        this.otherDamage = otherDamage;
    }

    @Override
    public String toString() {
        return id + "";
    }
}
