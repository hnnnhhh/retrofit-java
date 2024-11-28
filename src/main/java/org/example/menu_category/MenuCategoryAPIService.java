package org.example.menu_category;

import org.example.restaurant.RestaurantRequestModel;
import org.example.restaurant.RestaurantResponseModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface MenuCategoryAPIService {

    @POST("/menu-category/")
    Call<MenuCategoryRequestModel> createMenuCategory(@Body MenuCategoryRequestModel menuCategoryRequestModel);

    @GET("/menu-category")
    Call<List<MenuCategoryResponseModel>> getMenuCategory();
}
