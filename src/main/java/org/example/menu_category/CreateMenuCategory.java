package org.example.menu_category;

import org.example.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class CreateMenuCategory {
    public static void main(String[] args) {
        MenuCategoryRequestModel data = new MenuCategoryRequestModel();
        data.setName("Main Dish");

        createMenuCategory(data);
    }

    public static void createMenuCategory (MenuCategoryRequestModel data) {

        MenuCategoryAPIService apiService = RetrofitClient.getRetrofitInstance().create(MenuCategoryAPIService.class);

        Call<MenuCategoryRequestModel> createMenuCategory = apiService.createMenuCategory(data);

        createMenuCategory.enqueue(new Callback<MenuCategoryRequestModel>() {
            @Override
            public void onResponse(Call<MenuCategoryRequestModel> call, Response<MenuCategoryRequestModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    System.out.println("Menu Category created: " + response.body().getName());
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
            public void onFailure(Call<MenuCategoryRequestModel> call, Throwable throwable) {

                System.out.println("Network error or request failed: " + throwable.getMessage());
            }
        });
    }
}
