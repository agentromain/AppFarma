package com.example.romainartru.appfarma;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by romainartru on 30/03/2017.
 */

public class SigninActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity);
        final int indexFarma = getIntent().getIntExtra("idFarma", -1);

        MainActivity.mDbP.db = MainActivity.mDbP.getWritableDatabase();

        Button mBE = (Button) findViewById(R.id.buttonEnviar);
        final EditText edU = (EditText) findViewById(R.id.editUsuario);
        final EditText edC = (EditText) findViewById(R.id.editCorreo);
        final EditText edM = (EditText) findViewById(R.id.editMDP);
        final EditText edMC = (EditText) findViewById(R.id.editMDPConf);

        mBE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String m = edM.getText().toString();
                String mc = edMC.getText().toString();

                    if(m.equals(mc)) {
                        Cuenta c = new Cuenta(edU.getText().toString(), edC.getText().toString(), edM.getText().toString());
                        MainActivity.mDbP.addRegistro(c);

                        Intent intent = new Intent(SigninActivity.this, LoginActivity.class);
                        intent.putExtra("idFarma", indexFarma);
                        startActivity(intent);

                }
                else {
                        Dialog d = new Dialog(SigninActivity.this);
                        TextView td = new TextView(SigninActivity.this);
                        td.setText("¡ Contrasena diferente de su confirmacion !");
                        final RelativeLayout.LayoutParams params = new
                                RelativeLayout.LayoutParams(1000,300);
                        td.setGravity(Gravity.CENTER);
                        d.addContentView(td, params);
                        d.show();
                    }
            }
        });
    }


}
