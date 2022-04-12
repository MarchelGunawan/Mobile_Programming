package com.example.histery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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
    String countMelle;
    Troops tmt = new Troops(70,45,75);
    Troops trt = new Troops(45,90,30);
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btnplay);
        test = findViewById(R.id.white);
    }

    public void play(View v) {
        Intent i = new Intent(getApplicationContext(), Popup.class);
        startActivityForResult(i, SECOND_ACTIVITY_REQUEST_CODE);
    }

    public void teamTroops(View v) {
        switch (v.getId()){
            case R.id.m0:
                em0 = findViewById(R.id.m0);
                showWarningAlertDialog(em0);
                break;
            case R.id.m1:
                em1 = findViewById(R.id.m1);
                showWarningAlertDialog(em1);
                break;
            case R.id.m2:
                em2 = findViewById(R.id.m2);
                showWarningAlertDialog(em2);
                break;
            case R.id.m3:
                em3 = findViewById(R.id.m3);
                showWarningAlertDialog(em3);
                break;
            case R.id.m4:
                em4 = findViewById(R.id.m4);
                showWarningAlertDialog(em4);
                break;
            case R.id.m5:
                em5 = findViewById(R.id.m5);
                showWarningAlertDialog(em5);
                break;
            case R.id.m6:
                em6 = findViewById(R.id.m6);
                showWarningAlertDialog(em6);
                break;
            case R.id.m7:
                em7 = findViewById(R.id.m7);
                showWarningAlertDialog(em7);
                break;
            case R.id.m8:
                em8 = findViewById(R.id.m8);
                showWarningAlertDialog(em8);
                break;
            case R.id.m9:
                // handle player 1 textview T1
                tm9 = findViewById(R.id.m9);
                showWarningAlertDialog(tm9);
                //test.setText("m9 ID");
                break;
            case R.id.m10:
                // handle player 1 textview T2
                tm10 = findViewById(R.id.m10);
                showWarningAlertDialog(tm10);
                break;
            case R.id.m11:
                // handle player 1 textview T2
                tm11 = findViewById(R.id.m11);
                showWarningAlertDialog(tm11);
                break;
            case R.id.m12:
                // handle player 1 textview T2
                tm12 = findViewById(R.id.m12);
                showWarningAlertDialog(tm12);
                break;
            case R.id.m13:
                // handle player 1 textview T2
                tm13 = findViewById(R.id.m13);
                showWarningAlertDialog(tm13);
                break;
            case R.id.m14:
                // handle player 1 textview T2
                tm14 = findViewById(R.id.m14);
                showWarningAlertDialog(tm14);
                break;
            case R.id.m15:
                // handle player 1 textview T2
                tm15 = findViewById(R.id.m15);
                showWarningAlertDialog(tm15);
                break;
            case R.id.m16:
                // handle player 1 textview T2
                tm16 = findViewById(R.id.m16);
                showWarningAlertDialog(tm16);
                break;
            case R.id.m17:
                // handle player 1 textview T2
                tm17 = findViewById(R.id.m17);
                showWarningAlertDialog(tm17);
                break;
            default:
                Toast.makeText(getApplicationContext(), "Unknown button ID", Toast.LENGTH_SHORT);
                throw new RuntimeException("Unknown button ID");
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
                    tm9.setText("Melee#x#x#x#");
                }else if(v == tm10){
                    tm10.setText("Melee#x#x#x#");
                }else if(v == tm11){
                    tm11.setText("Melee#x#x#x#");
                }else if(v == tm12){
                    tm12.setText("Melee#x#x#x#");
                }else if(v == tm13){
                    tm13.setText("Melee#x#x#x#");
                }else if(v == tm14){
                    tm14.setText("Melee#x#x#x#");
                }else if(v == tm15){
                    tm15.setText("Melee#x#x#x#");
                }else if(v == tm16){
                    tm16.setText("Melee#x#x#x#");
                }else if(v == tm17){
                    tm17.setText("Melee#x#x#x#");
                }
                alertDialog.dismiss();
            }
        });

        view.findViewById(R.id.buttonrange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (v == tm9){
                    tm9.setText("Range#x#x#x#");
                }else if(v == tm10){
                    tm10.setText("Range#x#x#x#");
                }else if(v == tm11){
                    tm11.setText("Range#x#x#x#");
                }else if(v == tm12){
                    tm12.setText("Range#x#x#x#");
                }else if(v == tm13){
                    tm13.setText("Range#x#x#x#");
                }else if(v == tm14){
                    tm14.setText("Range#x#x#x#");
                }else if(v == tm15){
                    tm15.setText("Range#x#x#x#");
                }else if(v == tm16){
                    tm16.setText("Range#x#x#x#");
                }else if(v == tm17){
                    tm17.setText("Range#x#x#x#");
                }
                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is okay popup with in ok result
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // get String data from intent
//                String meleetroops = data.getStringExtra("melee_count");

            }
        }
    }
}