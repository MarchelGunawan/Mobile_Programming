package com.example.histery;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

public class TroopsPopUp extends Activity {
    int melle_count;
    int range_count;
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
    }

    public void melleTroops(View v){
        melle_count = 1;
        Intent i = new Intent();
        i.putExtra("mellecount", melle_count);
        setResult(RESULT_OK,i);
        finish();
    }
}