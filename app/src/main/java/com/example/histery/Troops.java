package com.example.histery;

public class Troops {
    private int health;
    private int atk;
    private int def;

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
}
