package com.example.histery;

public class Troops {
    private int health;
    private int atk;
    private int def;
    private int meleeTroops = 30;
    private int rangeTroops = 40;
    Troops(int health, int atk, int def){
        this.health = health;
        this.atk = atk;
        this.def = def;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getHealth() {
        return health;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getMeleeTroops(){
        return meleeTroops;
    }

    public int getRangeTroops() {
        return rangeTroops;
    }
}
