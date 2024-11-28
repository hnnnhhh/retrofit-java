package org.example.restaurant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import org.example.RetrofitClient;

import java.util.List;

public class GetAllRestaurant {
    public static void main(String[] args) {

        getAllRestaurant();
    }

    public static void getAllRestaurant() {

        RestaurantAPIService apiService = RetrofitClient.getRetrofitInstance().create(RestaurantAPIService.class);
        Call<List<RestaurantResponseModel>> getData = apiService.getRestaurant();

        getData.enqueue(new Callback<List<RestaurantResponseModel>>() {
            @Override
            public void onResponse(Call<List<RestaurantResponseModel>> call, Response<List<RestaurantResponseModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    System.out.println("Restaurant List:");
                    for (RestaurantResponseModel restaurantResponseModel : response.body()) {
                        System.out.println("Name: " + restaurantResponseModel.getName() + ", uuid: " + restaurantResponseModel.getRestaurant_uuid());
                    }
                } else {
                    System.out.println("Failed to fetch users: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<RestaurantResponseModel>> call, Throwable throwable) {

                System.out.println("Error" + throwable.getMessage());
            }
        });
    }
}