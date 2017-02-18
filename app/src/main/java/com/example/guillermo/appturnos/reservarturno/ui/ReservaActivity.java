package com.example.guillermo.appturnos.reservarturno.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.guillermo.appturnos.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ReservaActivity extends AppCompatActivity {
    public final static String FECHA = "fecha";
    public final static String HORA = "hora";
    @Bind(R.id.app_bar_image)
    ImageView appBarImage;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.cordinator)
    CoordinatorLayout cordinator;
    @Bind(R.id.activity_reserva)
    RelativeLayout activityReserva;
    @Bind(R.id.imageView2)
    ImageView imageView2;
    @Bind(R.id.hora)
    TextView horatxt;

    @Bind(R.id.fecha)
    TextView fechatxt;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        setToolbarData(intent);

    }

    private void setToolbarData(Intent i) {
        String hora = i.getStringExtra(HORA);
        String fecha = i.getStringExtra(FECHA);
        toolbar.setTitle("Quinta Basso");

        horatxt.setText(hora);
        fechatxt.setText(fecha);

    }
}
