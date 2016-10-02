package com.example.guillermo.appturnos.image.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.guillermo.appturnos.R;
import com.example.guillermo.appturnos.api.ImageApiEndpointInterface;
import com.example.guillermo.appturnos.api.ImageClient;
import com.example.guillermo.appturnos.image.adapter.ImagesAdapter;
import com.example.guillermo.appturnos.image.entity.Image;
import com.example.guillermo.appturnos.lib.GlideImageLoader;
import com.example.guillermo.appturnos.lib.ImageLoader;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment implements OnItemClickListener, Callback<JsonObject> {

    static final String TAG = "ImageFragment";

    static final String URL_GET = "https://sizzling-heat-8971.firebaseio.com/images.json";

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.container)
    FrameLayout container;


    public interface ChangeListener {
        public void onChange();
    }

    ChangeListener listener;

    public void setChangeListener(ChangeListener listener) {
        this.listener = listener;
    }

    ImagesAdapter adapter;
    ImageLoader imageLoader;

    ImageApiEndpointInterface imageApiEndpointInterface;


    public ImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_image, container, false);
        ButterKnife.bind(this, view);

      //  imageApiEndpointInterface = new ImageClient().getImageService();

        imageLoader = new GlideImageLoader(this.getContext());


        adapter = new ImagesAdapter(this, imageLoader);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        //Parte 1 - Lista Estatica
        //adapter.setItems(initImageStatic());


        //Parte 4 - Retrofit 2.0
        retrofiInitListImage();

        return view;
    }


    @Override
    public void onItemClick(Image image) {
        //String textInfo = String.format(getString(R.string.info_navegate_url), image.getSourceURL());
        //  Snackbar.make(container, textInfo, Snackbar.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(image.getSourceURL()));
        startActivity(intent);

        //Persistir
       /* Log.i(TAG, image.getText());
        ImageEntity imageEntity = new ImageEntity(image.getImageURL(), image.getText(), image.getSourceURL());
        imageEntity.save();*/

        //Notifica al Frgment Dos
        listener.onChange();
    }


    @NonNull
    private List<Image> initImageStatic() {

        List<Image> images = new ArrayList<Image>(0);
        images.add(new Image("http://www.noticias3d.com/images/logo.gif",
                "noticias3d",
                "http://www.noticias3d.com/"));
        images.add(new Image("http://www.guru3d.com/-/2006/driversweeper.jpg",
                "guru3d",
                "http://www.guru3d.com"));
        images.add(new Image("https://firebasestorage.googleapis.com/v0/b/sizzling-heat-8971.appspot.com/o/2%2Fdorso%2F2f75293a-459e-4730-bdee-80a1eec41e00.jpg?alt=media&token=ac25426e-eab8-475d-b89d-090547d0052b",
                "Test 3",
                "http://www.noticias3d.com/"));
        images.add(new Image("https://firebasestorage.googleapis.com/v0/b/sizzling-heat-8971.appspot.com/o/2%2Fdorso%2F2f75293a-459e-4730-bdee-80a1eec41e00.jpg?alt=media&token=ac25426e-eab8-475d-b89d-090547d0052b",
                "Test 4",
                "http://www.noticias3d.com/"));
        images.add(new Image("https://firebasestorage.googleapis.com/v0/b/sizzling-heat-8971.appspot.com/o/2%2Fdorso%2F2f75293a-459e-4730-bdee-80a1eec41e00.jpg?alt=media&token=ac25426e-eab8-475d-b89d-090547d0052b",
                "Test 5",
                "http://www.noticias3d.com/"));
        images.add(new Image("https://firebasestorage.googleapis.com/v0/b/sizzling-heat-8971.appspot.com/o/2%2Fdorso%2F2f75293a-459e-4730-bdee-80a1eec41e00.jpg?alt=media&token=ac25426e-eab8-475d-b89d-090547d0052b",
                "Test 6",
                "http://www.noticias3d.com/"));
        return images;
    }


    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }


    //Metodo Servicio Rest

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while ((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }


    private void retrofiInitListImage() {
        showProgressBar();
        Call<JsonObject> call = imageApiEndpointInterface.getImages();
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<JsonObject> call, retrofit2.Response<JsonObject> response) {
        List<Image> images = new ArrayList<Image>(0);
        if (response.isSuccessful()) {
            JSONObject json = null;
            try {
                json = new JSONObject(response.body().toString());


                Iterator<String> iter = json.keys();
                while (iter.hasNext()) {
                    String key = iter.next();

                    Image image = new Image();
                    JSONObject jsonObject = (JSONObject) json.get(key);
                    image.setText(jsonObject.get("text").toString());
                    image.setImageURL(jsonObject.get("imageURL").toString());
                    image.setSourceURL(jsonObject.get("sourceURL").toString());

                    images.add(image);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            adapter.setItems(images);
            hideProgressBar();

        } else {
            Log.d(TAG, response.message());
        }
    }

    @Override
    public void onFailure(Call<JsonObject> call, Throwable t) {
        Log.d(TAG, t.getLocalizedMessage());
    }

}
