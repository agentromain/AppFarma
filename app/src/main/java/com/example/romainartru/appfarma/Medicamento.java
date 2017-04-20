package com.example.romainartru.appfarma;

/**
 * Created by romainartru on 20/04/2017.
 */

public class Medicamento {
    private final String name;
    private  final String desc;
    private final boolean available;
    private final double price;

    public Medicamento(String n, String d, boolean a, double p){
        name = n;
        desc = d;
        available = a;
        price = p;
    }

    public String getName(){
        return name;
    }

    public String getDesc(){
        return desc;
    }

    public boolean getAva(){
        return available;
    }

    public double getPrice(){
        return price;
    }
}
