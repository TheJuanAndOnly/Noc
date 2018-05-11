package com.trichlapcitribagetky;

public class Email {

    private String odosielatel;
    private String prijemca;
    private int priorita;
    private float velkost;
    private int datum;
    private float cas;

    public Email(String odosielatel, String prijemca, int priorita, float velkost, int datum, float cas) {
        this.odosielatel = odosielatel;
        this.prijemca = prijemca;
        this.priorita = priorita;
        this.velkost = velkost;
        this.datum = datum;
        this.cas = cas;
    }

    public String getOdosielatel() {
        return odosielatel;
    }

    public void setOdosielatel(String odosielatel) {
        this.odosielatel = odosielatel;
    }

    public String getPrijemca() {
        return prijemca;
    }

    public void setPrijemca(String prijemca) {
        this.prijemca = prijemca;
    }

    public int getPriorita() {
        return priorita;
    }

    public void setPriorita(int priorita) {
        this.priorita = priorita;
    }

    public float getVelkost() {
        return velkost;
    }

    public void setVelkost(float velkost) {
        this.velkost = velkost;
    }

    public int getDatum() {
        return datum;
    }

    public void setDatum(int datum) {
        this.datum = datum;
    }

    public float getCas() {
        return cas;
    }

    public void setCas(float cas) {
        this.cas = cas;
    }
}
