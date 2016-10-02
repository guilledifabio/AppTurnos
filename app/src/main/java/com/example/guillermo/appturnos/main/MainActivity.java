package com.example.guillermo.appturnos.main;

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
import com.example.guillermo.appturnos.login.LoginPresenterImpl;
import com.example.guillermo.appturnos.login.ui.LoginActivity;
import com.example.guillermo.appturnos.main.adapter.MainSectionsPagerAdapter;
import com.example.guillermo.appturnos.store.StoreFragment;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs)
    TabLayout tabLayout;
    @Bind(R.id.container)
    ViewPager viewPager;
    //private ImageFragment imageFragment;
    private StoreFragment storeFragment;
    private StoreFragment storeFragment2;
    private StoreFragment storeFragment3;
    private StoreFragment storeFragment4;
    private StoreFragment storeFragment5;
    private StoreFragment storeFragment6;
    private StoreFragment storeFragment7;
    private String dia;
    private String diasemana;
    private String mes;
    private String ano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // ActionBar actionBar = getActionBar();
        //Seteando el icono
        toolbar.setLogo(R.drawable.bolafutbol);

        Calendar now = new GregorianCalendar();
        Calendar pasado = new GregorianCalendar();


        dia = String.valueOf(now.get(Calendar.DATE));
        mes = String.valueOf(now.get(Calendar.MONTH) + 1);
        ano = String.valueOf(now.get(Calendar.YEAR));
        Log.d("DIA", String.valueOf(now.get(Calendar.DATE)));
        Log.d("MES", String.valueOf(now.get(Calendar.MONTH) + 1));
        Log.d("AÑO", String.valueOf(now.get(Calendar.YEAR)));
        Log.d("HORA", String.valueOf(now.get(Calendar.HOUR)));
        Log.d("Dia de la semana", String.valueOf(now.get(Calendar.DAY_OF_WEEK)));
        Log.d("Dia de la sem", String.valueOf(now.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH)));

        diasemana = convertirdia(now.get(Calendar.DAY_OF_WEEK));
        Log.d("Dia de la semana st", diasemana);

        String[] titles = new String[10];
        for (int i = 0; i < 10; i++) {
            if (i != 0)
                pasado.add(Calendar.DAY_OF_YEAR, 1);
            titles[i] = String.valueOf(convertirdia(pasado.get(Calendar.DAY_OF_WEEK))) + " " + String.valueOf(pasado.get(Calendar.DATE)) + "/" + String.valueOf(pasado.get(Calendar.MONTH) + 1);
            Log.d("Pasado", String.valueOf(convertirdia(pasado.get(Calendar.DAY_OF_WEEK))) + " " + String.valueOf(pasado.get(Calendar.DATE)) + "/" + String.valueOf(pasado.get(Calendar.MONTH) + 1));

        }
        // imageFragment = new ImageFragment();

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


        MainSectionsPagerAdapter adapter = new MainSectionsPagerAdapter(getSupportFragmentManager(),
                fragments,
                titles);
        viewPager.setAdapter(adapter);


        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(tabLayout.MODE_SCROLLABLE);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
           // startActivity(new Intent(this, SettingsActivity.class));
          //  contactListPresenter.signOff(); VERR
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }


        return super.onOptionsItemSelected(item);
    }

    private String convertirdia(int dia) {
        String diaconv = "";
        switch (dia) {
            case 1:
                diaconv = "Domingo";
                break;
            case 2:
                diaconv = "Lunes";
                break;
            case 3:
                diaconv = "Martes";
                break;
            case 4:
                diaconv = "Miercoles";
                break;
            case 5:
                diaconv = "Jueves";
                break;
            case 6:
                diaconv = "Viernes";
                break;
            case 7:
                diaconv = "Sabado";

                break;

        }
        return diaconv;
    }

}
