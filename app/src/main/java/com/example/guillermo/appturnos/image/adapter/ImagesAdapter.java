package com.example.guillermo.appturnos.image.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guillermo.appturnos.R;
import com.example.guillermo.appturnos.image.entity.Image;
import com.example.guillermo.appturnos.image.ui.OnItemClickListener;
import com.example.guillermo.appturnos.lib.ImageLoader;

import java.util.ArrayList;
import java.util.List;


import butterknife.Bind;
import butterknife.ButterKnife;


public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {
    private List<Image> items = new ArrayList<Image>(0);
    private ImageLoader imageLoader;

    private OnItemClickListener clickListener;

    public ImagesAdapter(OnItemClickListener clickListener, ImageLoader imageLoader) {
        this.items = items;
        this.clickListener = clickListener;
        this.imageLoader = imageLoader;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Image tweet = items.get(position);
        // holder.setClickListener(tweet, clickListener);
        //    holder.txtText.setText(tweet.getText()); Para ponerle el texto
        //carga la imagen en Descargas imageLoader.load(holder.imgMedia, tweet.getImageURL());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Image> newItems) {
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.txtText)
        TextView txtText;
        @Bind(R.id.imgMedia)
        ImageView imgMedia;

        private View view;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.view = view;
        }

       /* public void setClickListener(final Image image, final OnItemClickListener listener) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(image);
                }
            });
        }*/
    }
}
