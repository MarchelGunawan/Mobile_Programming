package com.example.histery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView test;
    String countMelle;
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
        Intent i = new Intent(getApplicationContext(), TroopsPopUp.class);
        startActivityForResult(i, SECOND_ACTIVITY_REQUEST_CODE);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is okay popup with in ok result
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // get String data from intent
                //String teamMelle = data.getStringExtra("team_melle");
                countMelle = data.getStringExtra("mellecount");
                test.setText(countMelle);
            }
        }
    }
}