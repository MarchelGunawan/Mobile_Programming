package com.example.histery;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

public class TroopsPopUp extends Activity {
    String melee_count = "20";
    String range_count = "30";
    private SharedPreferences sp;
    private SharedPreferences.Editor edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troops_pop_up);

        // Display the matrics for the popup activity
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        // to get the size of activity
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        // set the activity size when popup
        getWindow().setLayout((int)(width*.8), (int)(height*.5));

        // setting the layout for the popup activity
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        sp = PreferenceManager.getDefaultSharedPreferences(this);
        edt = sp.edit();
    }


}