package com.example.guillermo.appturnos.turno.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guillermo.appturnos.R;
import com.example.guillermo.appturnos.lib.ImageLoader;
import com.example.guillermo.appturnos.turno.entities.Turno;
import com.example.guillermo.appturnos.turno.ui.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guillermo on 02/10/2016.
 */

public class TurnoAdapter extends RecyclerView.Adapter<TurnoAdapter.ViewHolder> {

    private List<Turno> items = new ArrayList<Turno>(0);
    private ImageLoader imageLoader;
    private OnItemClickListener clickListener;
    private ImageView imageView;

    public TurnoAdapter(OnItemClickListener clickListener, ImageLoader imageLoader) {
        this.items = items;
        this.clickListener = clickListener;
        this.imageLoader = imageLoader;
    }


    public void setItems(List<Turno> newItems) {
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_turno, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        Turno turno = items.get(position);
        holder.setClickListener(turno, clickListener);
        holder.textHora.setText(turno.getHora());//   Para ponerle el texto
        holder.complejo.setText("");
        imageLoader.load(holder.imgMedia, "https://firebasestorage.googleapis.com/v0/b/turnos-deportivos.appspot.com/o/Quinta%20Basso.jpg?alt=media&token=2af30445-ca2b-4f33-b32b-a9f403415e4d");
        //imageLoader.load(holder.imgMedia, tweet.getImageURL());carga la imagen en la Vista

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.imgMedia)
        ImageView imgMedia;
        @Bind(R.id.textHora)
        TextView textHora;
        @Bind(R.id.complejo)
        TextView complejo;

        private View view;


        public ViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);

            this.view = view;
        }

        public void setClickListener(final Turno turno, final OnItemClickListener listener) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(turno);
                }
            });
        }
    }
}
