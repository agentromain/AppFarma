package com.example.romainartru.appfarma;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by romainartru on 27/03/2017.
 */

public class MapActivity extends MainActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);

        Button mB2 = (Button) findViewById(R.id.button2);
        Button mB3 = (Button) findViewById(R.id.button3);
        Button mB4 = (Button) findViewById(R.id.button4);
        /*
        mB.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, );
            }
        });
        */
    }
}
