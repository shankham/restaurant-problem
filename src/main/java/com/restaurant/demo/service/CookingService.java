package com.restaurant.demo.service;

import com.restaurant.demo.domain.FoodItem;
import com.restaurant.demo.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CookingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CookingService.class.getName());

    public List<FoodItem> cook(Order order) {
        List<FoodItem> items = new ArrayList<>();

        for (final String dish : order.getDishes()) {
            FoodItem foodItem = new FoodItem(dish);
            List<String> dishData = new ArrayList<>();
            switch (dish) {
                case "Dish1" -> {
                    dishData.add("Step1 to cook Dish1");
                    dishData.add("Step2 to cook Dish1");
                    dishData.add("Step3 to cook Dish1");
                    dishData.add("Step4 to cook Dish1");
                }
                case "Dish2" -> {
                    dishData.add("Step1 to cook Dish2");
                    dishData.add("Step2 to cook Dish2");
                    dishData.add("Step3 to cook Dish2");
                    dishData.add("Step4 to cook Dish2");
                    dishData.add("Step5 to cook Dish2");
                    dishData.add("Step6 to cook Dish2");
                    dishData.add("Step7 to cook Dish2");
                    dishData.add("Step8 to cook Dish2");
                }
                case "Dish3" -> {
                    dishData.add("Step1 to cook Dish3");
                    dishData.add("Step2 to cook Dish3");
                    dishData.add("Step3 to cook Dish3");
                }
                default -> {
                    LOGGER.error("Invalid Dish {}", dish);
                    throw new RuntimeException("Invalid Dish: [" + dish + "]");
                }
            }
            foodItem.setDishData(dishData);
            items.add(foodItem);
        }
        return items;
    }


}
