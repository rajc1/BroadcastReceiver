package com.example.chetanrajjain.broadcastreceiver;

/**
 * Created by chetanrajjain on 3/25/18.
 */

public class IncomingNumber {

    private int id;
    private String number;


    public IncomingNumber(int id,String number){

        this.id = id;
        this.number = number;

    }

    public int getID(){

        return id;
    }

    public void setID(int id){

        this.id = id;

    }

    public String getNumber(){

        return number;
    }

    public void setNumber(String number){

        this.number = number;

    }

}
