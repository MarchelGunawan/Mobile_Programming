package com.example.histery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Range;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Opening extends AppCompatActivity {
    Rangetroops rt = new Rangetroops(45,90,30);
    Melletroops mt = new Melletroops(70,45,75);
    EditText team_melee_troops, team_range_troops, enemy_melee_troops, enemy_range_troops;
    int value1, value2, value3, value4;
    TextView team_troops_left, enemy_troops_left, tround, tml, trl, eml, erl;
    Button btnplay, btnrvr, btnrvm, btnmvr, btnmvm;
    int round = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        btnplay = findViewById(R.id.playthegame);
        btnmvm = findViewById(R.id.mvm);
        btnrvm = findViewById(R.id.rvm);
        btnmvr = findViewById(R.id.mvr);
        btnrvr = findViewById(R.id.rvr);
        team_melee_troops = findViewById(R.id.teammeleetroops);
        team_range_troops = findViewById(R.id.teamrangetroops);
        enemy_melee_troops = findViewById(R.id.enemymeleetroops);
        enemy_range_troops = findViewById(R.id.enemyrangetroops);
        team_troops_left = findViewById(R.id.teamtroopsleft);
        enemy_troops_left = findViewById(R.id.enemytroopsleft);
        tml = findViewById(R.id.teammeleeleft);
        trl = findViewById(R.id.teamrangeleft);
        eml = findViewById(R.id.enemymeleeleft);
        erl = findViewById(R.id.enemyrangeleft);
        tround = findViewById(R.id.round);
        btnrvm.setEnabled(false);
        btnrvr.setEnabled(false);
        btnmvm.setEnabled(false);
        btnmvr.setEnabled(false);
    }

    public void playgame(View v){
        btnrvm.setEnabled(true);
        btnrvr.setEnabled(true);
        btnmvm.setEnabled(true);
        btnmvr.setEnabled(true);
        value1 = Integer.parseInt(team_melee_troops.getText().toString());
        value2 = Integer.parseInt(team_range_troops.getText().toString());
        value3 = Integer.parseInt(enemy_melee_troops.getText().toString());
        value4 = Integer.parseInt(enemy_range_troops.getText().toString());
        int teamleft = value1 + value2;
        team_troops_left.setText(""+teamleft);
        int enemyleft = value3 +value4;
        enemy_troops_left.setText(""+enemyleft);
        tml.setText(""+value1);
        trl.setText(""+value2);
        eml.setText(""+value3);
        erl.setText(""+value4);
        team_melee_troops.setEnabled(false);
        team_range_troops.setEnabled(false);
        enemy_melee_troops.setEnabled(false);
        enemy_range_troops.setEnabled(false);
        btnplay.setEnabled(false);
        if(round%2 != 0){
            if(trl.getText().toString().equals("0")){
                btnrvr.setEnabled(false);
                btnrvm.setEnabled(false);
            }else{
                btnrvr.setEnabled(true);
                btnrvm.setEnabled(true);
            }
            if(tml.getText().toString().equals("0")){
                btnmvr.setEnabled(false);
                btnmvm.setEnabled(false);
            }else{
                btnmvr.setEnabled(true);
                btnmvm.setEnabled(true);
            }
        }
    }
    // range vs range
    public void rvrclicked(View v){
        if (round%2 != 0){
            if(trl.getText().toString().equals("0")){
                btnrvr.setEnabled(false);
                btnrvm.setEnabled(false);
            }else{
                btnrvr.setEnabled(true);
                btnrvm.setEnabled(true);
            }
            int atkrange = Integer.parseInt(trl.getText().toString());
            int defrange = Integer.parseInt(erl.getText().toString());
            int atk = rt.getAtk() * atkrange;
            int def = rt.getDef() * defrange;
            int result = defrange - Math.abs(Math.round((float)(atk-def)/rt.getHealth()));
            if(result <= 0){
                erl.setText("0");
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }else{
                erl.setText(""+result);
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }
            // counter attack from player 2 for range vs range
            int remaining = Integer.parseInt(erl.getText().toString());
            int catk = rt.getAtk() * remaining;
            int cresult = atkrange - Math.round((float)(catk)/ rt.getHealth());
            if(cresult <= 0){
                trl.setText("0");
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }else{
                trl.setText(""+cresult);
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }
        }else{
            if(erl.getText().toString().equals("0")){
                btnrvr.setEnabled(false);
                btnrvm.setEnabled(false);
            }else{
                btnrvr.setEnabled(true);
                btnrvm.setEnabled(true);
            }
            int atkrange = Integer.parseInt(erl.getText().toString());
            int defrange = Integer.parseInt(trl.getText().toString());
            int atk = rt.getAtk() * atkrange;
            int def = rt.getDef() * defrange;
            int result = defrange - Math.abs(Math.round((float)(atk-def)/rt.getHealth()));
            if(result <= 0){
                trl.setText("0");
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }else{
                trl.setText(""+result);
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }
            // counter attack from player 1 for range vs range
            int remaining = Integer.parseInt(trl.getText().toString());
            int catk = rt.getAtk() * remaining;
            int cresult = atkrange - Math.round((float)(catk)/ rt.getHealth());
            if(cresult <= 0){
                erl.setText("0");
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }else{
                erl.setText(""+cresult);
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }
        }
        round++;
        tround.setText("Round "+round);
        if(enemy_troops_left.getText().toString().equals("0") && team_troops_left.getText().toString().equals("0") ){
            tround.setText("Draw");
            btnplay.setEnabled(true);
            team_melee_troops.setEnabled(true);
            team_range_troops.setEnabled(true);
            enemy_melee_troops.setEnabled(true);
            enemy_range_troops.setEnabled(true);
        }else if(team_troops_left.getText().toString().equals("0") ){
            tround.setText("Player 2 Win");
            btnplay.setEnabled(true);
            team_melee_troops.setEnabled(true);
            team_range_troops.setEnabled(true);
            enemy_melee_troops.setEnabled(true);
            enemy_range_troops.setEnabled(true);
        }else if(enemy_troops_left.getText().toString().equals("0")){
            tround.setText("Player 1 Win");
            btnplay.setEnabled(true);
            team_melee_troops.setEnabled(true);
            team_range_troops.setEnabled(true);
            enemy_melee_troops.setEnabled(true);
            enemy_range_troops.setEnabled(true);
        }
    }
    // range vs melee
    public void rvmclicked(View v){
        if (round%2 != 0){
            if(trl.getText().toString().equals("0")){
                btnrvr.setEnabled(false);
                btnrvm.setEnabled(false);
            }else{
                btnrvr.setEnabled(true);
                btnrvm.setEnabled(true);
            }
            int atkrange = Integer.parseInt(trl.getText().toString());
            int defmelee = Integer.parseInt(eml.getText().toString());
            int atk = rt.getAtk() * atkrange;
            int def = mt.getDef() * defmelee;
            int result = defmelee - Math.abs(Math.round((float)(atk-def)/mt.getHealth()));
            if(result <= 0){
                eml.setText("0");
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }else{
                eml.setText(""+result);
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }
            // counter attack from player 2 for range vs melee
            int remaining = Integer.parseInt(eml.getText().toString());
            int catk = mt.getAtk() * remaining;
            int cresult = atkrange - Math.round((float)(catk)/ rt.getHealth());
            if(cresult <= 0){
                trl.setText("0");
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }else{
                trl.setText(""+cresult);
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }
        }else{
            if(erl.getText().toString().equals("0")){
                btnrvr.setEnabled(false);
                btnrvm.setEnabled(false);
            }else{
                btnrvr.setEnabled(true);
                btnrvm.setEnabled(true);
            }
            int atkrange = Integer.parseInt(erl.getText().toString());
            int defmelee = Integer.parseInt(tml.getText().toString());
            int atk = rt.getAtk() * atkrange;
            int def = rt.getDef() * defmelee;
            int result = defmelee - Math.abs(Math.round((float)(atk-def)/mt.getHealth()));
            if(result <= 0){
                tml.setText("0");
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }else{
                tml.setText(""+result);
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }
            // counter from player 1 for range vs melee
            int remaining = Integer.parseInt(tml.getText().toString());
            int catk = mt.getAtk() * remaining;
            int cresult = atkrange - Math.round((float)(catk)/ rt.getHealth());
            if(cresult <= 0){
                erl.setText("0");
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }else{
                erl.setText(""+cresult);
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }
        }
        round++;
        tround.setText("Round "+round);

        if(enemy_troops_left.getText().toString() == "0" && team_troops_left.getText().toString() == "0"  ){
            tround.setText("Draw");
            btnplay.setEnabled(true);
            team_melee_troops.setEnabled(true);
            team_range_troops.setEnabled(true);
            enemy_melee_troops.setEnabled(true);
            enemy_range_troops.setEnabled(true);
        }else if(team_troops_left.getText().toString() == "0" ){
            tround.setText("Player 2 Win");
            btnplay.setEnabled(true);
            team_melee_troops.setEnabled(true);
            team_range_troops.setEnabled(true);
            enemy_melee_troops.setEnabled(true);
            enemy_range_troops.setEnabled(true);
        }else if(enemy_troops_left.getText().toString() == "0"){
            tround.setText("Player 1 Win");
            btnplay.setEnabled(true);
            team_melee_troops.setEnabled(true);
            team_range_troops.setEnabled(true);
            enemy_melee_troops.setEnabled(true);
            enemy_range_troops.setEnabled(true);
        }
    }
    // melee vs range
    public void mvrclicked(View v){
        if (round%2 != 0){
            if(tml.getText().toString().equals("0")){
                btnmvr.setEnabled(false);
                btnmvm.setEnabled(false);
            }else{
                btnmvr.setEnabled(true);
                btnmvm.setEnabled(true);
            }
            int atkmelee = Integer.parseInt(tml.getText().toString());
            int defrange = Integer.parseInt(erl.getText().toString());
            int atk = rt.getAtk() * atkmelee;
            int def = mt.getDef() * defrange;
            int result = defrange - Math.abs(Math.round((float)(atk-def)/rt.getHealth()));
            if(result <= 0){
                erl.setText("0");
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }else{
                erl.setText(""+result);
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }
            // counter from player 2 for melee vs range
            int remaining = Integer.parseInt(erl.getText().toString());
            int catk = rt.getAtk() * remaining;
            int cresult = atkmelee - Math.round((float)catk/mt.getHealth());
            if(cresult <= 0){
                tml.setText("0");
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }else{
                tml.setText(""+cresult);
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }
        }else{
            if(eml.getText().toString().equals("0")){
                btnmvr.setEnabled(false);
                btnmvm.setEnabled(false);
            }else{
                btnmvr.setEnabled(true);
                btnmvm.setEnabled(true);
            }
            int atkmelee = Integer.parseInt(eml.getText().toString());
            int defrange = Integer.parseInt(trl.getText().toString());
            int atk = rt.getAtk() * atkmelee;
            int def = rt.getDef() * defrange;
            int result = defrange - Math.abs(Math.round((float)(atk-def)/rt.getHealth()));
            if(result <= 0){
                trl.setText("0");
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }else{
                trl.setText(""+result);
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }
            // counter from player 1 for melee vs range
            int remaining = Integer.parseInt(trl.getText().toString());
            int catk = rt.getAtk() * remaining;
            int cresult = atkmelee - Math.round((float)catk/mt.getHealth());
            if(cresult <= 0){
                eml.setText("0");
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }else{
                eml.setText(""+cresult);
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }
        }
        round++;
        tround.setText("Round "+round);
        if(enemy_troops_left.getText().toString().equals("0") && team_troops_left.getText().toString().equals("0")){
            tround.setText("Draw");
            btnplay.setEnabled(true);
            team_melee_troops.setEnabled(true);
            team_range_troops.setEnabled(true);
            enemy_melee_troops.setEnabled(true);
            enemy_range_troops.setEnabled(true);
        }else if(team_troops_left.getText().toString().equals("0")){
            tround.setText("Player 2 Win");
            btnplay.setEnabled(true);
            team_melee_troops.setEnabled(true);
            team_range_troops.setEnabled(true);
            enemy_melee_troops.setEnabled(true);
            enemy_range_troops.setEnabled(true);
        }else if(enemy_troops_left.getText().toString().equals("0")){
            tround.setText("Player 1 Win");
            btnplay.setEnabled(true);
            team_melee_troops.setEnabled(true);
            team_range_troops.setEnabled(true);
            enemy_melee_troops.setEnabled(true);
            enemy_range_troops.setEnabled(true);
        }
    }

    public void mvmclicked(View v){
        if (round%2 != 0){
            if(tml.getText().toString().equals("0")){
                btnmvr.setEnabled(false);
                btnmvm.setEnabled(false);
            }else{
                btnmvr.setEnabled(true);
                btnmvm.setEnabled(true);
            }
            int atkmelee = Integer.parseInt(trl.getText().toString());
            int defmelee = Integer.parseInt(erl.getText().toString());
            int atk = mt.getAtk() * atkmelee;
            int def = mt.getDef() * defmelee;
            int result = defmelee - Math.abs(Math.round((float)(atk-def)/mt.getHealth()));
            if(result <= 0){
                eml.setText("0");
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }else{
                eml.setText(""+result);
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }
            // counter attack player 2 for melee vs melee
            int remaining = Integer.parseInt(eml.getText().toString());
            int catk = mt.getAtk() * remaining;
            int cresult = atkmelee - Math.round((float)catk/mt.getHealth());
            if(cresult <= 0){
                tml.setText("0");
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }else{
                tml.setText(""+cresult);
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }
        }else{
            if(tml.getText().toString().equals("0")){
                btnmvr.setEnabled(false);
                btnmvm.setEnabled(false);
            }else{
                btnmvr.setEnabled(true);
                btnmvm.setEnabled(true);
            }
            int atkmelee = Integer.parseInt(erl.getText().toString());
            int defmelee = Integer.parseInt(trl.getText().toString());
            int atk = mt.getAtk() * atkmelee;
            int def = mt.getDef() * defmelee;
            int result = defmelee - Math.abs(Math.round((float)(atk-def)/mt.getHealth()));
            if(result <= 0){
                tml.setText("0");
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }else{
                tml.setText(""+result);
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }
            // counter attack player 1 for melee vs melee
            int remaining = Integer.parseInt(tml.getText().toString());
            int catk = mt.getAtk() * remaining;
            int cresult = atkmelee - Math.round((float)catk/mt.getHealth());
            if(cresult <= 0){
                eml.setText("0");
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }else{
                eml.setText(""+cresult);
                value1 = Integer.parseInt(tml.getText().toString());
                value2 = Integer.parseInt(trl.getText().toString());
                value3 = Integer.parseInt(eml.getText().toString());
                value4 = Integer.parseInt(erl.getText().toString());
                int teamleft = value1 + value2;
                team_troops_left.setText(""+teamleft);
                int enemyleft = value3 +value4;
                enemy_troops_left.setText(""+enemyleft);
            }
        }
        round++;
        tround.setText("Round "+round);
        if(enemy_troops_left.getText().toString().equals("0") && team_troops_left.getText().toString().equals("0")){
            tround.setText("Draw");
            btnplay.setEnabled(true);
            team_melee_troops.setEnabled(true);
            team_range_troops.setEnabled(true);
            enemy_melee_troops.setEnabled(true);
            enemy_range_troops.setEnabled(true);
        }else if(team_troops_left.getText().toString().equals("0")){
            tround.setText("Player 2 Win");
            btnplay.setEnabled(true);
            team_melee_troops.setEnabled(true);
            team_range_troops.setEnabled(true);
            enemy_melee_troops.setEnabled(true);
            enemy_range_troops.setEnabled(true);
        }else if(enemy_troops_left.getText().toString().equals("0")){
            tround.setText("Player 1 Win");
            btnplay.setEnabled(true);
            team_melee_troops.setEnabled(true);
            team_range_troops.setEnabled(true);
            enemy_melee_troops.setEnabled(true);
            enemy_range_troops.setEnabled(true);
        }
    }
}