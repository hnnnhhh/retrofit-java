package org.example.menu_category;

import org.example.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class GetAllMenuCategory {
    public static void main(String[] args) {

        getAllMenuCategory();
    }

    public static void getAllMenuCategory() {

        MenuCategoryAPIService apiService = RetrofitClient.getRetrofitInstance().create(MenuCategoryAPIService.class);
        Call<List<MenuCategoryResponseModel>> getData = apiService.getMenuCategory();

        getData.enqueue(new Callback<List<MenuCategoryResponseModel>>() {
            @Override
            public void onResponse(Call<List<MenuCategoryResponseModel>> call, Response<List<MenuCategoryResponseModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    System.out.println("Menu Category List:");
                    for (MenuCategoryResponseModel menuCategoryResponseModel : response.body()) {
                        System.out.println("Name: " + menuCategoryResponseModel.getName() + ", uuid: " + menuCategoryResponseModel.getMenu_uuid());
                    }
                } else {
                    System.out.println("Failed to fetch users: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<MenuCategoryResponseModel>> call, Throwable throwable) {

                System.out.println("Error" + throwable.getMessage());
            }
        });
    }
}