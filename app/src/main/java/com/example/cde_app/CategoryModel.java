package com.example.cde_app;

public class CategoryModel {
    private String categoryId, name, image;

    public CategoryModel(String categoryId, String categoryName, String categoryImage) {
        this.categoryId = categoryId;
        this.name = categoryName;
        this.image = categoryImage;
    }

    public CategoryModel() {
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String categoryName) {
        this.name = categoryName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String categoryImage) {
        this.image = categoryImage;
    }
}
