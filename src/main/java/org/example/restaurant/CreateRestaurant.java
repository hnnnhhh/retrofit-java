package org.example.restaurant;

import org.example.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class CreateRestaurant {
    public static void main(String[] args) {
        RestaurantRequestModel data = new RestaurantRequestModel();
        data.setName("Hannah's Hungry Haven");
        data.setAddress("217 Willow Creek Lane, Springdale, AR 72764");
        data.setDescription("Hannah's offers a cozy dining experience with a focus on comfort food and creative cuisine.");
        data.setCategory_id(5);
        data.setEmail("contact@hannahhungryhaven.com");
        data.setPhone("09971851444");
        data.setStatus(true);
        data.setUser_id(4);

        createRestaurant(data);
    }

    public static void createRestaurant(RestaurantRequestModel data){

        RestaurantAPIService apiService = RetrofitClient.getRetrofitInstance().create(RestaurantAPIService.class);

        Call<RestaurantRequestModel> createRestaurant = apiService.createRestaurant(data);

        createRestaurant.enqueue(new Callback<RestaurantRequestModel>() {
            @Override
            public void onResponse(Call<RestaurantRequestModel> call, Response<RestaurantRequestModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    System.out.println("Restaurant created: " + response.body().getName());
                } else {
                    try {
                        String errorMessage = response.errorBody() != null ? response.errorBody().string() : "Unknown error";
                        System.out.println("Failed to create user. Code: " + response.code() + ", Error: " + errorMessage);
                    } catch (IOException e) {
                        System.out.println("Error reading error body: " + e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<RestaurantRequestModel> call, Throwable throwable) {
                System.out.println("Network error or request failed: " + throwable.getMessage());

            }
        });

    }
}