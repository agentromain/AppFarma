package com.example.romainartru.appfarma;

/**
 * Created by romainartru on 06/04/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.provider.Settings;

public class DBPref extends DBHelper {
    public DBPref(Context contexto, String mode) {
        super(contexto, mode);
    }


    public void addCuenta(Cuenta cuenta) {
        ContentValues valores = new ContentValues();
        valores.put("usuario", cuenta.getUsuario());
        valores.put("correo", cuenta.getCorreo());
        valores.put("mdp", cuenta.getMdp());
/*
        String[] respuestas_erroneas = pregunta.getRespuestasErroneas();
        for(int i = 0; i < respuestas_erroneas.length; i++) {
            valores.put("respuesta_incorrecta_" + i, respuestas_erroneas[i]);
        }
        */
        db.insert("cuentas", null, valores);
    }
    public void addCuentas(Cuenta[] cuentas) {
        for(int i = 0; i < cuentas.length; i++) {
            this.addCuenta(cuentas[i]);
        }
    }
    public Cursor getCuentas() {
        return this.db.rawQuery("SELECT usuario, correo, mdp FROM cuentas",
                new String[]{});
    }
}