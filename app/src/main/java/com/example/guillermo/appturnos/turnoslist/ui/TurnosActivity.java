package com.example.guillermo.appturnos.turnoslist.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.guillermo.appturnos.R;
import com.example.guillermo.appturnos.login.ui.LoginActivity;

import com.example.guillermo.appturnos.turno.ui.OnItemClickListener;
import com.example.guillermo.appturnos.turno.ui.TurnoFragment;
import com.example.guillermo.appturnos.turnoslist.TurnosListPresenter;
import com.example.guillermo.appturnos.turnoslist.TurnosListPresenterImpl;
import com.example.guillermo.appturnos.turnoslist.adapter.TurnosListAdapter;
import com.example.guillermo.appturnos.turno.entities.Turno;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TurnosActivity extends AppCompatActivity implements TurnosListView, OnItemClickListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.container)
    ViewPager container;
    private TurnosListPresenter turnosListPresenter;
    private TurnosListAdapter adapter;
    private TurnoFragment turnoFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turnos);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        turnosListPresenter = new TurnosListPresenterImpl(this);
        turnosListPresenter.onCreate();

        toolbar.setLogo(R.drawable.bolafutbol);
        //toolbar.setSubtitle("guille");
        toolbar.setSubtitle(turnosListPresenter.getCurrentEmail());
        //Log.d("Subtitle", turnosListPresenter.getCurrentUserEmail()); VER
        setupAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        turnosListPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        turnosListPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        turnosListPresenter.onDestroy();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contactlist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            turnosListPresenter.singOff();
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(Turno turno) {

    }

    @Override
    public void onItemLongClick(Turno turno) {

    }

    @Override
    public void onReservaAdded(Turno turno) {

    }

    @Override
    public void onReservaCancel(Turno turno) {

    }

    private void setupAdapter() {
         /*  imageFragment.setChangeListener(new ImageFragment.ChangeListener() {
            @Override
            public void onChange() {
                turnoFragment.updateList();
            }
        });
        Cuando cambio de tab actualiza la Lista
        */

        //Fragment[] fragments = new Fragment[]{turnoFragment, storeFragment2, storeFragment3, storeFragment4, storeFragment5, storeFragment6, storeFragment7};
        //   String[] titles = new String[]{getString(R.string.main_header_images), getString(R.string.main_header_store), getString(R.string.pestana3), getString(R.string.pestana4), getString(R.string.pestana5), getString(R.string.pestana6), getString(R.string.pestana7)};
        Fragment[] fragments = new Fragment[10];
        String[] titles = turnosListPresenter.obtenerDias();
        //turnoFragment.setContext(this.getApplicationContext());
        for (int i = 0; i < 10; i++) {
            turnoFragment = new TurnoFragment();
            turnoFragment.setTittle(titles[i]);
            turnosListPresenter.obtenerTurnosDisp(titles[i]);
            fragments[i] = turnoFragment;

        }

        adapter = new TurnosListAdapter(getSupportFragmentManager(), fragments, titles);
        container.setAdapter(adapter);

        tabs.setupWithViewPager(container);

        tabs.setTabMode(tabs.MODE_SCROLLABLE);
    }
}
