package org.example.menu;

import org.example.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class GetAllMenu {
    public static void main(String[] args) {

        getAllMenu();
    }

    public static void getAllMenu() {

        MenuAPIService apiService = RetrofitClient.getRetrofitInstance().create(MenuAPIService.class);
        Call<List<MenuResponseModel>> getData = apiService.getMenu();

        getData.enqueue(new Callback<List<MenuResponseModel>>() {
            @Override
            public void onResponse(Call<List<MenuResponseModel>> call, Response<List<MenuResponseModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    System.out.println("Menu Category List:");
                    for (MenuResponseModel menuResponseModel : response.body()) {
                        System.out.println("Name: " + menuResponseModel.getName() + ", uuid: " + menuResponseModel.getMenu_uuid());
                    }
                } else {
                    System.out.println("Failed to fetch users: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<MenuResponseModel>> call, Throwable throwable) {

                System.out.println("Error" + throwable.getMessage());
            }
        });
    }
}