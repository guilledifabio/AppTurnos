package com.example.guillermo.appturnos.api;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by horaciomunoz on 3/7/16.
 */

public interface ImageApiEndpointInterface {
    @GET("images.json")
    Call<JsonObject> getImages();
}
