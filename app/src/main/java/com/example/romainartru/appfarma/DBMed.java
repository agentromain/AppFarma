package com.example.romainartru.appfarma;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by romainartru on 20/04/2017.
 */

public class DBMed extends DBHelper {
    public DBMed(Context contexto, String mode) {
        super(contexto, mode);
    }

    public void addMed(Medicamento m) {
        ContentValues valores = new ContentValues();
        valores.put("name", m.getName());
        valores.put("desc", m.getDesc());
        valores.put("price", m.getPrice());

        db.insert("medics", null, valores);
    }

    public void addMedics(Medicamento[] med) {
        for(int i = 0; i < med.length; i++) {
            this.addMed(med[i]);
        }
    }

    public Cursor getMedics() {
        return this.db.rawQuery("SELECT name, desc, price FROM medics",
                new String[]{});
    }
}
