package com.example.romainartru.appfarma;

/**
 * Created by romainartru on 19/04/2017.
 */
import android.app.AlertDialog;
import android.app.Dialog;
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

    private final List<Pair<Pair<String, Boolean>, Pair<String, Double>>> med = Arrays.asList(
            Pair.create(Pair.create("Lorem ipsum", true), Pair.create("Lorem ipsum dolor sit amet",10.0)),
            Pair.create(Pair.create("Consectetur", true), Pair.create("Consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore",12.0)),
            Pair.create(Pair.create("Ut enim", false), Pair.create("Ut enim ad minim veniam",7.99)),
            Pair.create(Pair.create("Quis nostrud", true), Pair.create("Quis nostrud exercitation ullamco laboris nisi ut aliquip",0.0)),
            Pair.create(Pair.create("2Lorem ipsum", true), Pair.create("Lorem ipsum dolor sit amet",10.0)),
            Pair.create(Pair.create("2Consectetur", true), Pair.create("Consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore",12.0)),
            Pair.create(Pair.create("2Ut enim", false), Pair.create("Ut enim ad minim veniam",7.99)),
            Pair.create(Pair.create("2Quis nostrud", true), Pair.create("Quis nostrud exercitation ullamco laboris nisi ut aliquip",0.0)),
            Pair.create(Pair.create("3Lorem ipsum", true), Pair.create("Lorem ipsum dolor sit amet",10.0)),
            Pair.create(Pair.create("3Consectetur", true), Pair.create("Consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore",12.0)),
            Pair.create(Pair.create("3Ut enim", false), Pair.create("Ut enim ad minim veniam",7.99)),
            Pair.create(Pair.create("3Quis nostrud", true), Pair.create("Quis nostrud exercitation ullamco laboris nisi ut aliquip",0.0))
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
        Pair<Pair<String, Boolean>, Pair<String, Double>> pair = med.get(position);
        holder.display(pair);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView dispo;
        private final TextView description;
        private final TextView price;

        private Pair<Pair<String, Boolean>,Pair<String, Double>> currentPair;

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
                            .setTitle(currentPair.first.first)
                            .setMessage(currentPair.second.first)
                            .show();
                }
            });
        }

        public void display(Pair<Pair<String, Boolean>,Pair<String, Double>> pair) {
            currentPair = pair;
            name.setText(pair.first.first);
            if(pair.first.second) {
                dispo.setText("Disponible");
                dispo.setTextColor(Color.GREEN);
            }else {
                dispo.setText("Indisponible");
                dispo.setTextColor(Color.RED);
            }
            description.setText(pair.second.first);
            price.setText(pair.second.second.toString());
        }
    }

}