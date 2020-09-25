package com.restaurant.demo.domain;

import java.util.List;

public class FoodItem {
    private String menuName;
    private String steps;
    private int estimatedTime;
    
    public FoodItem(){}

    public FoodItem(String menuName, String steps, int estimatedTime){
        this.menuName = menuName;
        this.steps = steps;
        this.estimatedTime = estimatedTime;
    }
    private String dish;
    private List<String> dishData;
    
    public FoodItem(String dish, List<String> dishData, String menuName, String steps, int estimatedTime){
    	this.dish = dish;
        this.dishData = dishData;
    	this.menuName = menuName;
        this.steps = steps;
        this.estimatedTime = estimatedTime;
    }
   

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

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

	public int getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}
    
    
}
