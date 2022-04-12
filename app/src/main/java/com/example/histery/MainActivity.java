package com.example.histery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView em0, em1, em2, em3, em4, em5, em6, em7, em8, tm9, tm10, tm11, tm12, tm13, tm14, tm15, tm16, tm17;
    TextView test;
    int i = 0;
    int strategyTime = 1;
    Troops tmt = new Troops(70,45,75);
    Troops trt = new Troops(45,90,30);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btnplay);
        test = findViewById(R.id.white);
        em0 = findViewById(R.id.m0);
        em1 = findViewById(R.id.m1);
        em2 = findViewById(R.id.m2);
        em3 = findViewById(R.id.m3);
        em4 = findViewById(R.id.m4);
        em5 = findViewById(R.id.m5);
        em6 = findViewById(R.id.m6);
        em7 = findViewById(R.id.m7);
        em8 = findViewById(R.id.m8);
        tm9 = findViewById(R.id.m9);
        tm10 = findViewById(R.id.m10);
        tm11 = findViewById(R.id.m11);
        tm12 = findViewById(R.id.m12);
        tm13 = findViewById(R.id.m13);
        tm14 = findViewById(R.id.m14);
        tm15 = findViewById(R.id.m15);
        tm16 = findViewById(R.id.m16);
        tm17 = findViewById(R.id.m17);
        disableEnemy();
        disableTeam();
    }

    public void enableTeam(){
        tm9.setEnabled(true);
        tm10.setEnabled(true);
        tm11.setEnabled(true);
        tm12.setEnabled(true);
        tm13.setEnabled(true);
        tm14.setEnabled(true);
        tm15.setEnabled(true);
        tm16.setEnabled(true);
        tm17.setEnabled(true);
    }

    public void disableTeam(){
        tm9.setEnabled(false);
        tm10.setEnabled(false);
        tm11.setEnabled(false);
        tm12.setEnabled(false);
        tm13.setEnabled(false);
        tm14.setEnabled(false);
        tm15.setEnabled(false);
        tm16.setEnabled(false);
        tm17.setEnabled(false);
    }

    public void enableEnemy(){
        em0.setEnabled(true);
        em1.setEnabled(true);
        em2.setEnabled(true);
        em3.setEnabled(true);
        em4.setEnabled(true);
        em5.setEnabled(true);
        em6.setEnabled(true);
        em7.setEnabled(true);
        em8.setEnabled(true);
    }

    public void disableEnemy(){
        em0.setEnabled(false);
        em1.setEnabled(false);
        em2.setEnabled(false);
        em3.setEnabled(false);
        em4.setEnabled(false);
        em5.setEnabled(false);
        em6.setEnabled(false);
        em7.setEnabled(false);
        em8.setEnabled(false);
    }

    public void play(View v) {
        // play the time thread for set the strategy for player 1 and player 2
        if(strategyTime == 0){
            enableTeam();
            btn.setText("Player 1");
            tmr();
            strategyTime++;
        }else if(strategyTime == 1){
            btn.setText("Player 2");
            tmr();
            strategyTime++;
        }
    }

    public void enemyTroops(View v){
        if(strategyTime > 2){

        }else{
            switch (v.getId()){
                case R.id.m0:
                    showWarningAlertDialog2(em0);
                    break;
                case R.id.m1:
                    showWarningAlertDialog2(em1);
                    break;
                case R.id.m2:
                    showWarningAlertDialog2(em2);
                    break;
                case R.id.m3:
                    showWarningAlertDialog2(em3);
                    break;
                case R.id.m4:
                    showWarningAlertDialog2(em4);
                    break;
                case R.id.m5:
                    showWarningAlertDialog2(em5);
                    break;
                case R.id.m6:
                    showWarningAlertDialog2(em6);
                    break;
                case R.id.m7:
                    showWarningAlertDialog2(em7);
                    break;
                case R.id.m8:
                    showWarningAlertDialog2(em8);
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "Unknown button ID", Toast.LENGTH_SHORT);
                    throw new RuntimeException("Unknown button ID");
            }
        }

    }

    public void teamTroops(View v) {
        if(strategyTime > 2){

        }else{
            switch (v.getId()){
                case R.id.m9:
                    // handle player 1 textview T1
                    showWarningAlertDialog(tm9);
                    break;
                case R.id.m10:
                    // handle player 1 textview T2
                    showWarningAlertDialog(tm10);
                    break;
                case R.id.m11:
                    // handle player 1 textview T3
                    showWarningAlertDialog(tm11);
                    break;
                case R.id.m12:
                    // handle player 1 textview M1
                    showWarningAlertDialog(tm12);
                    break;
                case R.id.m13:
                    // handle player 1 textview M2
                    showWarningAlertDialog(tm13);
                    break;
                case R.id.m14:
                    // handle player 1 textview M3
                    showWarningAlertDialog(tm14);
                    break;
                case R.id.m15:
                    // handle player 1 textview S1
                    showWarningAlertDialog(tm15);
                    break;
                case R.id.m16:
                    // handle player 1 textview S2
                    showWarningAlertDialog(tm16);
                    break;
                case R.id.m17:
                    // handle player 1 textview S3
                    showWarningAlertDialog(tm17);
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "Unknown button ID", Toast.LENGTH_SHORT);
                    throw new RuntimeException("Unknown button ID");
            }
        }


    }

    private void showWarningAlertDialog(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(MainActivity.this).inflate(
                R.layout.layout_warning_dialog,(ConstraintLayout)findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.buttonmelee).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (v == tm9){
                    tm9.setText("M#45#75#70#30");
                }else if(v == tm10){
                    tm10.setText("M#45#75#70#30");
                }else if(v == tm11){
                    tm11.setText("M#45#75#70#30");
                }else if(v == tm12){
                    tm12.setText("M#45#75#70#30");
                }else if(v == tm13){
                    tm13.setText("M#45#75#70#30");
                }else if(v == tm14){
                    tm14.setText("M#45#75#70#30");
                }else if(v == tm15){
                    tm15.setText("M#45#75#70#30");
                }else if(v == tm16){
                    tm16.setText("M#45#75#70#30");
                }else if(v == tm17){
                    tm17.setText("M#45#75#70#30");
                }
                alertDialog.dismiss();
            }
        });

        view.findViewById(R.id.buttonrange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (v == tm9){
                    tm9.setText("R#90#30#45#20");
                }else if(v == tm10){
                    tm10.setText("R#90#30#45#20");
                }else if(v == tm11){
                    tm11.setText("R#90#30#45#20");
                }else if(v == tm12){
                    tm12.setText("R#90#30#45#20");
                }else if(v == tm13){
                    tm13.setText("R#90#30#45#20");
                }else if(v == tm14){
                    tm14.setText("R#90#30#45#20");
                }else if(v == tm15){
                    tm15.setText("R#90#30#45#20");
                }else if(v == tm16){
                    tm16.setText("R#90#30#45#20");
                }else if(v == tm17){
                    tm17.setText("R#90#30#45#20");
                }
                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    private void showWarningAlertDialog2(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(MainActivity.this).inflate(
                R.layout.layout_warning_dialog,(ConstraintLayout)findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.buttonmelee).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (v == em0){
                    em0.setText("M#45#75#70#30");
                }else if(v == em1){
                    em1.setText("M#45#75#70#30");
                }else if(v == em2){
                    em2.setText("M#45#75#70#30");
                }else if(v == em3){
                    em3.setText("M#45#75#70#30");
                }else if(v == em4){
                    em4.setText("M#45#75#70#30");
                }else if(v == em5){
                    em5.setText("M#45#75#70#30");
                }else if(v == em6){
                    em6.setText("M#45#75#70#30");
                }else if(v == em7){
                    em7.setText("M#45#75#70#30");
                }else if(v == em8){
                    em8.setText("M#45#75#70#30");
                }
                alertDialog.dismiss();
            }
        });

        view.findViewById(R.id.buttonrange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (v == em0){
                    em0.setText("R#90#30#45#20");
                }else if(v == em1){
                    em1.setText("R#90#30#45#20");
                }else if(v == em2){
                    em2.setText("R#90#30#45#20");
                }else if(v == em3){
                    em3.setText("R#90#30#45#20");
                }else if(v == em4){
                    em4.setText("R#90#30#45#20");
                }else if(v == em5){
                    em5.setText("R#90#30#45#20");
                }else if(v == em6){
                    em6.setText("R#90#30#45#20");
                }else if(v == em7){
                    em7.setText("R#90#30#45#20");
                }else if(v == em8){
                    em8.setText("R#90#30#45#20");
                }
                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    private void tmr(){
        i = 0;
        boolean t = true;
        Handler hnd = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while(t) {
                    try{
                        i++;
                        Thread.sleep(1000);
                        if(i == 60){
                            break;
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    hnd.post(new Runnable() {
                        @Override
                        public void run() {
                            test.setText(""+i);
                        }
                    });
                }
            }
        };
        new Thread(runnable).start();
    }
}

