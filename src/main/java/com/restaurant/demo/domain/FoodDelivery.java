package com.restaurant.demo.domain;

import java.util.List;

public class FoodDelivery {

    private String orderId;
    private List<FoodItem> foodData;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<FoodItem> getFoodData() {
        return foodData;
    }

    public void setFoodData(List<FoodItem> foodData) {
        this.foodData = foodData;
    }
}
