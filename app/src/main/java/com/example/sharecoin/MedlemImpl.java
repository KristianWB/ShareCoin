package com.example.sharecoin;

public interface MedlemImpl {
    void opretMedlemmer(String virksomhedsnavn,int cvr);
    void opdatereMedlemmer(String virksomhedsnavn,int cvr);
    void sletMedlemmer(int cvr);

}
