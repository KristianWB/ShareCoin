package com.example.sharecoin;

import java.util.ArrayList;
import java.util.Date;

public class Block
{
    //En datatype, af typen string
    public String hash;
    //En datatype, af typen string
    public String previousHash;
    //En datatype, af typen string
    private String data; //our data will be a simple message.
    //En datatype af long
    private long timeStamp; //as number of milliseconds since 1/1/1970.

    private int nonce;

    //Block Constructor.
    public Block(String data,String previousHash )
    {
        //Sætter lokalvariabel ligemeget klassevariabel
        this.data = data;
        this.previousHash = previousHash;

        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }




     //En String metode
    //Beregn hash på baggrund af block indholdet
    public String calculateHash()
    {
        //Den laver en String hash med tre parametre med brug af en algoritme

        //StringUtil er en klasse med en masse værktøjs metoder, fx applySha256,
        // som er en hash metode som tager en string og laver den om ved at bruge sha256 algoritmen
        String calculatedhash = StringUtil.applySha256
                (
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        data
        );
        return calculatedhash;
    }

    public void mineBlock(int difficulty)
    {

        //Opretter en ny strıng, med en array char som er størrelsen af int, hvor alt bliver  erstattet af en 0
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        //Så længe at den første del af hash, fra 0 til difficulty ikke er ens med target ,
        // så kører hvad der er inde i while løkken
        while(!hash.substring( 0, difficulty).equals(target))
        {

            nonce ++;

            hash = calculateHash();

        }

        System.out.println("Block Mined!!! : " + hash);

    }

}
