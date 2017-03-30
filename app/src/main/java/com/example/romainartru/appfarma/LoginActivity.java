package com.example.romainartru.appfarma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by romainartru on 30/03/2017.
 */

public class LoginActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        TextView title = (TextView) findViewById(R.id.titleFarmaLogin);
        title.setText(String.format("Bienvenido a la farmacia %d", getIntent().getIntExtra("idFarma", -1)));

        Button mB = (Button) findViewById(R.id.buttonSignin);
        mB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });
    }
}
