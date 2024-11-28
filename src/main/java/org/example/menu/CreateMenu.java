package org.example.menu;

import org.example.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class CreateMenu {
    public static void main(String[] args) {

        MenuRequestModel data = new MenuRequestModel();
        data.setName("Kimchi Fried Rice");
        data.setDescription(" A flavorful Korean dish made with leftover rice, kimchi, and other ingredients.");
        data.setAvailability(true);
        data.setCategory_id(4);
        data.setRestaurant_id(6);

        createMenu(data);
    }

    public static void createMenu (MenuRequestModel data){

        MenuAPIService apiService = RetrofitClient.getRetrofitInstance().create(MenuAPIService.class);

        Call<MenuRequestModel> creatMenu = apiService.createMenu(data);

        creatMenu.enqueue(new Callback<MenuRequestModel>() {
            @Override
            public void onResponse(Call<MenuRequestModel> call, Response<MenuRequestModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    System.out.println("Menu created: " + response.body().getName());
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
            public void onFailure(Call<MenuRequestModel> call, Throwable throwable) {

                System.out.println("Network error or request failed: " + throwable.getMessage());
            }
        });
    }
}
