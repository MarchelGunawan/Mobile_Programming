package com.example.histery;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Popup extends Activity {
    Button btn1;
    String tmc, trc, emc, erc;
    EditText team_melle, team_range, enemy_melle, enemy_range;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        team_melle = findViewById(R.id.edittextmelle1);
        team_range = findViewById(R.id.edittexrange1);
        enemy_melle = findViewById(R.id.edittextmelle2);
        enemy_range = findViewById(R.id.edittexrange2);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.8));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

    }

    public void start(View v){
        //Send the variable
        tmc = team_melle.getText().toString();
        trc = team_range.getText().toString();
        emc = enemy_melle.getText().toString();
        erc = enemy_range.getText().toString();
        Intent i = new Intent();
        i.putExtra("team_melle", tmc);
        i.putExtra("team_range", trc);
        i.putExtra("enemy_melle", emc);
        i.putExtra("enemy_range", erc);
        setResult(RESULT_OK,i);
        finish();
    }
}