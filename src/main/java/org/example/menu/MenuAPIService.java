package org.example.menu;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface MenuAPIService {

    @POST("/menu/")
    Call<MenuRequestModel> createMenu(@Body MenuRequestModel menuRequestModel);

    @GET("/menu")
    Call<List<MenuResponseModel>> getMenu();
}