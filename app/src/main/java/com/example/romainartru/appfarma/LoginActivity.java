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

    //DBPref mDbP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        //mDbP  = new DBPref(LoginActivity.this, "READ");
        final int indexFarma = getIntent().getIntExtra("idFarma", -1);

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


                MainActivity.mDbP.db = MainActivity.mDbP.getReadableDatabase();
                Cursor cur = MainActivity.mDbP.getCuentas();
                boolean found = false;

                cur.moveToNext();

                for(int i = 0; i < cur.getCount(); ++i){
                    String correo = cur.getString(1);
                    String passw = cur.getString(2);
                    if(correo.equals(edC.getText().toString()) &&
                            passw.equals(edM.getText().toString())){
                        found = true;
                        MainActivity.mDbP.close();
                        Intent intent = new Intent(LoginActivity.this, FarmaGeneralActivity.class);
                        startActivity(intent);

                    }
                    cur.moveToNext();
                }
                MainActivity.mDbP.close();

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
                /*
                MainActivity.mDbP.db = MainActivity.mDbP.getReadableDatabase();
                Cursor cur = MainActivity.mDbP.getCuentas();
                Log.i("lala", cur.getCount()+"");
                Log.i("lala", cur.getColumnCount()+"");
                Log.i("lala", cur.getColumnName(0)+"");
                Log.i("lala", cur.getColumnName(1)+"");
                Log.i("lala", cur.getColumnName(2)+"");

                cur.moveToNext();
                for(int i = 0; i < cur.getCount(); ++i){
                    for(int j = 0; j < cur.getColumnCount(); ++j){
                        Log.i("lala", cur.getString(j)+"");
                    }
                    Log.i("lala", "NEXT ACCOUNT");
                    cur.moveToNext();
                }
                MainActivity.mDbP.close();
                */

                //Intent intent = new Intent(LoginActivity.this, SigninActivity.class);
                //startActivity(intent);
            }
        });
    }
}
