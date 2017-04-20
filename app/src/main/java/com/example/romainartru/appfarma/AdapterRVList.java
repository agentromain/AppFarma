package com.example.romainartru.appfarma;

/**
 * Created by romainartru on 19/04/2017.
 */
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class AdapterRVList extends AdapterRV {

    private final List<Medicamento> med = Arrays.asList(
            new Medicamento("Lorem ipsum", "Lorem ipsum dolor sit amet", true, 10.0),
            new Medicamento("Consectetur", "Consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore", true, 12.0),
            new Medicamento("Ut enim", "Ut enim ad minim veniam", false, 7.99),
            new Medicamento("Quis nostrud", "Quis nostrud exercitation ullamco laboris nisi ut aliquip", true, 29.99),
            new Medicamento("2Lorem ipsum", "Lorem ipsum dolor sit amet", true, 10.0),
            new Medicamento("2Consectetur", "Consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore", true, 12.0),
            new Medicamento("2Ut enim", "Ut enim ad minim veniam", false, 7.99),
            new Medicamento("2Quis nostrud", "Quis nostrud exercitation ullamco laboris nisi ut aliquip", true, 29.99),
            new Medicamento("3Lorem ipsum", "Lorem ipsum dolor sit amet", true, 10.0),
            new Medicamento("3Consectetur", "Consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore", true, 12.0),
            new Medicamento("3Ut enim", "Ut enim ad minim veniam", false, 7.99),
            new Medicamento("3Quis nostrud", "Quis nostrud exercitation ullamco laboris nisi ut aliquip", true, 29.99)
    );

    @Override
    public int getItemCount() {
        return med.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cell_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Medicamento m = med.get(position);
        holder.display(m);
    }
}