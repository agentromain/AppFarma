package com.example.romainartru.appfarma;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by romainartru on 30/03/2017.
 */

public class LoginActivity extends Activity{

    DBPref mDbP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mDbP  = new DBPref(LoginActivity.this, "READ");
        final int indexFarma = getIntent().getIntExtra("idFarma", -1);

        SQLiteDatabase db = mDbP.getReadableDatabase();

        TextView title = (TextView) findViewById(R.id.titleFarmaLogin);

        title.setText(String.format("Bienvenido a la farmacia %d", indexFarma));

        final EditText edC = (EditText) findViewById(R.id.editCorreoLog);
        final EditText edM = (EditText) findViewById(R.id.editMDPLog);

        Button mBsi = (Button) findViewById(R.id.buttonSignin);
        mBsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SigninActivity.class);
                intent.putExtra("idFarma", indexFarma);
                startActivity(intent);
            }
        });

        Button mBli = (Button) findViewById(R.id.buttonLogin);
        mBli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cur = mDbP.getCuentas();
                boolean found = false;

                cur.moveToFirst();

                /*
                if(cur.getCount() > 0) {
                    String userName = cur.getString(0);
                    String correo = cur.getString(1);
                    String passw = cur.getString(2);
                    Log.i("col1", userName);
                    Log.i("col2", correo);
                    Log.i("col3", passw);
                }
                */
                String correo = cur.getString(1);
                String passw = cur.getString(2);

                for(int i = 0; i < cur.getCount(); ++i){
                    if(correo.equals(edC.getText().toString()) &&
                            passw.equals(edM.getText().toString())){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        found = true;
                    }
                    cur.moveToNext();
                }
                if(!found) {
                    Dialog d = new Dialog(LoginActivity.this);
                    TextView td = new TextView(LoginActivity.this);
                    td.setText("¡ No cuenta endontrada !");
                    final RelativeLayout.LayoutParams params = new
                            RelativeLayout.LayoutParams(1000,300);
                    td.setGravity(Gravity.CENTER);
                    d.addContentView(td, params);
                    d.show();
                }

                //Intent intent = new Intent(LoginActivity.this, SigninActivity.class);
                //startActivity(intent);
            }
        });
    }
}
