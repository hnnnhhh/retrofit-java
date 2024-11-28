package org.example.menu_category;

public class MenuCategoryResponseModel extends MenuCategoryRequestModel{

    String created_at;
    int menu_id;
    String menu_uuid;
    String updated_at;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_uuid() {
        return menu_uuid;
    }

    public void setMenu_uuid(String menu_uuid) {
        this.menu_uuid = menu_uuid;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}