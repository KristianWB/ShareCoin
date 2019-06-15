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

        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }





    //Beregn hash på baggrund af block indholdet
    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        data
        );
        return calculatedhash;
    }

    public void mineBlock(int difficulty)
    {

        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"

        while(!hash.substring( 0, difficulty).equals(target)) {

            nonce ++;

            hash = calculateHash();

        }

        System.out.println("Block Mined!!! : " + hash);

    }

}
