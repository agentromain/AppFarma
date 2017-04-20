package com.example.romainartru.appfarma;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by romainartru on 20/04/2017.
 */

public class CestaActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiting_activity);

        final RecyclerView rv = (RecyclerView) findViewById(R.id.list_item);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new AdapterRV());
    }
}
