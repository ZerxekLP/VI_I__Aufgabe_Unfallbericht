package com.example.vi_i__aufgabe_unfallbericht;

import java.io.Serializable;

public class Place implements Serializable {
    String place;
    int postelCode;
    String street;
    String nr;

    public Place(String place, int postelCode, String street, String nr) {
        this.place = place;
        this.postelCode = postelCode;
        this.street = street;
        this.nr = nr;
    }

    @Override
    public String toString() {
        return "Place{" +
                "place='" + place + '\'' +
                ", postelCode=" + postelCode +
                ", street='" + street + '\'' +
                ", nr='" + nr + '\'' +
                '}';
    }
}
