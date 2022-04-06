package com.example.histery;

public class Rangetroops extends Troops {
    String type;
    public Rangetroops(int health, int atk, int def){
        super(health,atk,def);
        this.type = "Range";
    }

    public String display(){
        return this.type;
    }

}
