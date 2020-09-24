package com.restaurant.demo.domain;

import java.util.List;

public class FoodItem {

    private String dish;
    private List<String> dishData;

    public FoodItem(String dish) {
        this.dish = dish;
    }

    public String getDish() {
        return dish;
    }

    public List<String> getDishData() {
        return dishData;
    }

    public void setDishData(List<String> dishData) {
        this.dishData = dishData;
    }
}
