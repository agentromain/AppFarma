package com.example.romainartru.appfarma;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class DBHelper extends SQLiteOpenHelper {
    public static final String NOMBRE_BD="cuentasDB";
    public static final int VERSION_ACTUAL_BD=1;
    protected SQLiteDatabase db;
    protected Context ctx;

    public DBHelper(Context context) {
        super(context, NOMBRE_BD, null, VERSION_ACTUAL_BD);
        this.ctx = context;
        this.open();
    }
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("debug", "Creando la Base de Datos");
        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner( this.ctx.getResources().openRawResource(R.raw.database) );
        while(sc.hasNextLine()) {
            sb.append(sc.nextLine());
            sb.append('\n');
            if (sb.indexOf(";") != -1) {
                sqLiteDatabase.execSQL(sb.toString());
                sb.delete(0, sb.capacity());
            }
        }
    }
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        Log.d("debug", "Actualizando la base de datos desde la version " + i + " a la version " + i2);
    }
    public void open() {
        Log.d("debug", "Abriendo la base de datos");
        this.db = this.getWritableDatabase();
    }
    public void close() {
        Log.d("debug", "Cerrando la base de datos");
        this.db.close();
    }
    public void addSampleData() {
        try {
            this.db.execSQL("DELETE FROM cuentas;");
            this.db.execSQL("INSERT INTO cuentas (usuario, mdp)" +
            "VALUES(\"romainartru\", \"mdpRomain\");");
            //RESTO DE cuentas
        }
        catch (Exception e) {
            e.printStackTrace();
            Log.d("debug", e.toString());
        }
    }
}