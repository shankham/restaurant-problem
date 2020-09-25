package com.restaurant.demo.domain;

import java.util.ArrayList;
import java.util.List;


public class OrderResponseWrapper extends ResponseWrapper{

    private int totalPrice;
    private List<Order> orders;
    private FoodDelivery foodDelivery;

    public OrderResponseWrapper(){
        orders = new ArrayList<>();
        totalPrice = 0;
        foodDelivery = new FoodDelivery();
    }

    public void setOrders(List orders){
        this.orders = orders;
    }

    public List<Order> getOrders(){
        return orders;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
    
    public FoodDelivery getFoodDelivery() {
		return foodDelivery;
	}

	public void setFoodDelivery(FoodDelivery foodDelivery) {
		this.foodDelivery = foodDelivery;
	}

	@Override
    public String toString(){
        return "ResponseWrapper:{" +
                " resultCode=" + getResponseCode() +
                " resultStatus=" + getResponseStatus() +
                " resultDesc=" + getResponseDesc() +
                " totalPrice=" + getTotalPrice() +
                " orders=" + getOrders() +
                " foodDelivery=" + getFoodDelivery() +
              " }";
    }
}
