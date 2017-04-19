package com.example.romainartru.appfarma;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by romainartru on 19/04/2017.
 */

public class FarmaProfilActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil_activity);

        Button buConf = (Button) findViewById(R.id.buttonConfCamb);
        buConf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(FarmaProfilActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });

        Button buCamb = (Button) findViewById(R.id.buttonCambContr);
        buCamb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Dialog d = new Dialog(FarmaProfilActivity.this);
                TextView td1 = new TextView(FarmaProfilActivity.this);
                td1.setText("Para cambiar su contrasena, entrega el viejo :");
                EditText et1 = new EditText(FarmaProfilActivity.this);
                et1.setHint("******");
                TextView td2 = new TextView(FarmaProfilActivity.this);
                td2.setText("Entregar la nueva contrasena :");
                EditText et2 = new EditText(FarmaProfilActivity.this);
                et2.setHint("******");
                Button b = new Button(FarmaProfilActivity.this);
                b.setText("Confirmar");
                final RelativeLayout.LayoutParams params = new
                        RelativeLayout.LayoutParams(1000,300);
                td1.setGravity(Gravity.CENTER);
                td2.setGravity(Gravity.CENTER);
                d.addContentView(td1, params);
                d.addContentView(td2, params);
                d.addContentView(et1, params);
                d.addContentView(et2, params);
                d.addContentView(b, params);
                d.show();
            }
        });
    }
}
