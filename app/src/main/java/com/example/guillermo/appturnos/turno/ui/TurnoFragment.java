package com.example.guillermo.appturnos.turno.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.guillermo.appturnos.R;
import com.example.guillermo.appturnos.lib.GlideImageLoader;
import com.example.guillermo.appturnos.lib.ImageLoader;
import com.example.guillermo.appturnos.reservarturno.ui.ReservaActivity;
import com.example.guillermo.appturnos.turno.adapter.TurnoAdapter;
import com.example.guillermo.appturnos.turno.entities.Turno;
import com.example.guillermo.appturnos.turnoslist.TurnosListPresenter;
import com.example.guillermo.appturnos.turnoslist.TurnosListPresenterImpl;
import com.example.guillermo.appturnos.turnoslist.ui.TurnosActivity;
import com.example.guillermo.appturnos.turnoslist.ui.TurnosListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guillermo on 02/10/2016.
 */

public class TurnoFragment extends Fragment implements OnItemClickListener {
    ExpandableListAdapter listAdapter;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private TurnosListPresenter turnosListPresenter;

    // TurnoAdapter adapter;
    ImageLoader imageLoader;

    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.container)
    FrameLayout container;
    String tittle;
    @Bind(R.id.lvExp)
    ExpandableListView lvExp;
    private Context context;

    public TurnoFragment() {
    }

    public void setListDataHeader(List<String> listDataHeader) {
        this.listDataHeader = listDataHeader;
    }

    public void setListDataChild(HashMap<String, List<String>> listDataChild) {
        this.listDataChild = listDataChild;
    }

    public void add(HashMap<String, List<String>> listDataChild) {
        this.listDataChild = listDataChild;
        listAdapter.add(listDataChild);

    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_turno, container, false);
        ButterKnife.bind(this, view);
        turnosListPresenter = new TurnosListPresenterImpl((TurnosListView) context);
        imageLoader = new GlideImageLoader(getActivity().getApplicationContext());
        turnosListPresenter.obtenerTurnosDisp(getTittle());

        //adapter = new TurnoAdapter(this, imageLoader);


        // preparing list data

        prepareListData();

        listAdapter = new ExpandableListAdapter(getContext(), listDataHeader, listDataChild);

        // setting list adapter
        lvExp.setAdapter(listAdapter);
        /*
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
*/

        //Parte 5 - Load from Sqlite
        //  dbInitListImage();

        //Parte 1 - Lista Estatica
        //  adapter.setItems(initImageStatic());
        return view;
    }


    @Override
    public void onItemClick(Turno turno) {


    }

    @Override
    public void onItemLongClick(Turno turno) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

    }

    /*
        @NonNull
        private List<Turno> initImageStatic() {

    //Traer los turnos para un dia que me pasan por parametro
            List<Turno> turnos = new ArrayList<Turno>(0);
            turnos.add(new Turno("02/10/2016", "13 hs","02/10/2016","11:20","guille@gmail_com","cancha1_quinta_basso",true));
            turnos.add(new Turno("02/10/2016", "14 hs","02/10/2016","12:20","guille@gmail_com","cancha1_quinta_basso",true));
            turnos.add(new Turno("02/10/2016", "15 hs","02/10/2016","13:20","guille@gmail_com","cancha1_quinta_basso",true));
            turnos.add(new Turno("02/10/2016", "16 hs","02/10/2016","14:20","guille@gmail_com","cancha1_quinta_basso",true));
            turnos.add(new Turno("02/10/2016", "17 hs","02/10/2016","15:20","guille@gmail_com","cancha1_quinta_basso",true));
            turnos.add(new Turno("02/10/2016", "18 hs","02/10/2016","16:20","guille@gmail_com","cancha1_quinta_basso",true));

            return turnos;
        }
    */
    private void prepareListData() {

       /* listDataHeader = new ArrayList<String>();
        this.listDataChild = listDataChild;*/
        listDataHeader = new ArrayList<String>();
       this.listDataChild = new HashMap<String, List<String>>();
//Obtener los horarios con este parametro tittle
        // Adding child data
        listDataHeader.add("13:00");
        listDataHeader.add("14:00");
        listDataHeader.add("15:00");
        // Ver cuando no tiene sub item,, hay error

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("Quinta Basso");
        top250.add("Tercer Tiempo");
        top250.add("Barrilete");
        top250.add("De Rabona");


        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }

    public void setContext(Context context) {

        this.context = context;
    }
}
