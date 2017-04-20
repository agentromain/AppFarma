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

public class AdapterRV extends RecyclerView.Adapter<AdapterRV.MyViewHolder> {

    private final List<Medicamento> med = Arrays.asList();

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

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView dispo;
        private final TextView description;
        private final TextView price;

        private Medicamento currentMed;

        public MyViewHolder(final View itemView) {
            super(itemView);

            name = ((TextView) itemView.findViewById(R.id.name));
            dispo = ((TextView) itemView.findViewById(R.id.dispo));
            description = ((TextView) itemView.findViewById(R.id.description));
            price = ((TextView) itemView.findViewById(R.id.price));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle(currentMed.getName())
                            .setMessage(currentMed.getDesc())
                            .setNegativeButton("Anadir a la cesta", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .show();
                }
            });
        }

        public void display(Medicamento m) {
            currentMed = m;
            name.setText(m.getName());
            if(m.getAva()) {
                dispo.setText("Disponible");
                dispo.setTextColor(Color.GREEN);
            }else {
                dispo.setText("Indisponible");
                dispo.setTextColor(Color.RED);
            }
            description.setText(m.getDesc());
            price.setText(Double.toString(m.getPrice()));
        }
    }

}