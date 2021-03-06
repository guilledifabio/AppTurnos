package com.example.guillermo.appturnos.store;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.guillermo.appturnos.R;
import com.example.guillermo.appturnos.image.adapter.ImagesAdapter;
import com.example.guillermo.appturnos.image.ui.OnItemClickListener;
import com.example.guillermo.appturnos.lib.GlideImageLoader;
import com.example.guillermo.appturnos.lib.ImageLoader;
import com.example.guillermo.appturnos.turno.entities.Turno;



import butterknife.Bind;
import butterknife.ButterKnife;


public class StoreFragment extends Fragment implements OnItemClickListener {


    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.container)
    FrameLayout container;


    ImagesAdapter adapter;
    ImageLoader imageLoader;

    public StoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        ButterKnife.bind(this, view);


        imageLoader = new GlideImageLoader(this.getContext());


        adapter = new ImagesAdapter(this,imageLoader);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));



        //Parte 5 - Load from Sqlite
      //  dbInitListImage();

        return view;
    }
/*
    private void dbInitListImage() {
        List<ImageEntity> lista = new Select().from(ImageEntity.class).queryList();
        List<Image> resultado = new ArrayList<Image>(0);
        for (ImageEntity item:lista) {
            resultado.add(new Image(item.getText(),item.getImageURL(),item.getSourceURL()));
        }
        adapter.setItems(resultado);
    }
*/


    public void updateList() {
             //dbInitListImage();
            }

    @Override
    public void onItemClick(Turno turno) {

    }
}
