package com.example.romainartru.appfarma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by romainartru on 19/04/2017.
 */

public class FarmaGeneralActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farma_activity);

        Button buPro = (Button) findViewById(R.id.buttonProfil);
        buPro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(FarmaGeneralActivity.this, FarmaProfilActivity.class);
                startActivity(intent);
            }
        });

        Button buMed = (Button) findViewById(R.id.buttonMed);
        buMed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(FarmaGeneralActivity.this, MedActivity.class);
                startActivity(intent);
            }
        });

        Button buHist = (Button) findViewById(R.id.buttonHist);
        buHist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(FarmaGeneralActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });

        Button buCesta = (Button) findViewById(R.id.buttonCesta);
        buHist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(FarmaGeneralActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });

        Button buPref = (Button) findViewById(R.id.buttonPref);
        buPref.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(FarmaGeneralActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });

        Button buEx = (Button) findViewById(R.id.buttonExit);
        buPref.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(FarmaGeneralActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
    }
}
