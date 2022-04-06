package com.example.histery;

public class Melletroops extends Troops{
    String type;
    public Melletroops(int health, int atk, int def){
        super(health,atk,def);
        this.type = "Melle";
    }

    public String display(){
        return this.type;
    }
}
