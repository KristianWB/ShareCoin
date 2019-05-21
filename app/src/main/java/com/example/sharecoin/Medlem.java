package com.example.sharecoin;

public class Medlem implements MedlemImpl {

    private String virksomhedsnavn;
    private int cvr;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelefonNummer() {
        return telefonNummer;
    }

    public void setTelefonNummer(int telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    private String adresse;
    private int telefonNummer;

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    private int password;

    public String getVirksomhedsnavn() {
        return virksomhedsnavn;
    }

    public void setVirksomhedsnavn(String virksomhedsnavn) {
        this.virksomhedsnavn = virksomhedsnavn;
    }

    public int getCvr() {
        return cvr;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }



    @Override
    public void opretMedlemmer(String virksomhedsnavn, int cvr)
    {

    }

    @Override
    public void opdatereMedlemmer(String virksomhedsnavn, int cvr)
    {

    }

    @Override
    public void sletMedlemmer(int cvr)
    {

    }
}
