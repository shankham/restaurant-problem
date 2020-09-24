package com.restaurant.demo.service;

import com.restaurant.demo.domain.FoodDelivery;
import com.restaurant.demo.domain.FoodItem;
import com.restaurant.demo.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final OrderTakerService orderTakerService;
    private final CookingService cookingService;
    private final DeliveryService deliveryService;

    public RestaurantService(OrderTakerService orderTakerService, CookingService cookingService, DeliveryService deliveryService) {
        this.orderTakerService = orderTakerService;
        this.cookingService = cookingService;
        this.deliveryService = deliveryService;
    }

    public FoodDelivery order(Order order) {
        orderTakerService.takeOrder(order);
        List<FoodItem> foodItems = cookingService.cook(order);
        return deliveryService.deliver(order, foodItems);
    }
}
