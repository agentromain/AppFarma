package com.example.romainartru.appfarma;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by romainartru on 30/03/2017.
 */

public class SigninActivity extends Activity {

    DBPref mDbP = new DBPref(this.getApplicationContext(), "WRITE");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity);

        Button mBE = (Button) findViewById(R.id.buttonEnviar);
        final EditText edU = (EditText) findViewById(R.id.editUsuario);
        final EditText edC = (EditText) findViewById(R.id.editCorreo);
        final EditText edM = (EditText) findViewById(R.id.editMDP);
        final EditText edMC = (EditText) findViewById(R.id.editMDPConf);

        mBE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edM.getText() != edMC.getText()) {
                    Cuenta c = new Cuenta(edU.getText().toString(), edC.getText().toString(), edM.getText().toString());
                    mDbP.addRegistro(c);

                    Intent intent = new Intent(SigninActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
