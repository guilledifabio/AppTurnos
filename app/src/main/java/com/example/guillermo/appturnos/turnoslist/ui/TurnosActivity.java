package com.example.guillermo.appturnos.turnoslist.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.guillermo.appturnos.R;
import com.example.guillermo.appturnos.login.ui.LoginActivity;
import com.example.guillermo.appturnos.store.StoreFragment;
import com.example.guillermo.appturnos.turnoslist.TurnosListPresenter;
import com.example.guillermo.appturnos.turnoslist.TurnosListPresenterImpl;
import com.example.guillermo.appturnos.turnoslist.adapter.TurnosListAdapter;
import com.example.guillermo.appturnos.turnoslist.entities.Turno;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
    private StoreFragment storeFragment;
    private StoreFragment storeFragment2;
    private StoreFragment storeFragment3;
    private StoreFragment storeFragment4;
    private StoreFragment storeFragment5;
    private StoreFragment storeFragment6;
    private StoreFragment storeFragment7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turnos);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        turnosListPresenter = new TurnosListPresenterImpl(this);
        toolbar.setLogo(R.drawable.bolafutbol);
        setupAdapter();
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
        storeFragment = new StoreFragment();
        storeFragment2 = new StoreFragment();
        storeFragment3 = new StoreFragment();
        storeFragment4 = new StoreFragment();
        storeFragment5 = new StoreFragment();
        storeFragment6 = new StoreFragment();
        storeFragment7 = new StoreFragment();


      /*  imageFragment.setChangeListener(new ImageFragment.ChangeListener() {
            @Override
            public void onChange() {
                storeFragment.updateList();
            }
        });
        Cuando cambio de tab actualiza la Lista
        */

        Fragment[] fragments = new Fragment[]{storeFragment, storeFragment2, storeFragment3, storeFragment4, storeFragment5, storeFragment6, storeFragment7};
        //   String[] titles = new String[]{getString(R.string.main_header_images), getString(R.string.main_header_store), getString(R.string.pestana3), getString(R.string.pestana4), getString(R.string.pestana5), getString(R.string.pestana6), getString(R.string.pestana7)};

        String[] titles = turnosListPresenter.obtenerDias();
        adapter = new TurnosListAdapter(getSupportFragmentManager(), fragments, titles);
        container.setAdapter(adapter);

        tabs.setupWithViewPager(container);
        tabs.setTabMode(tabs.MODE_SCROLLABLE);
    }
}
