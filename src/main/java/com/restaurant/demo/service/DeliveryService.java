package com.restaurant.demo.service;

import com.restaurant.demo.domain.FoodDelivery;
import com.restaurant.demo.domain.FoodItem;
import com.restaurant.demo.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryService.class.getName());

    public FoodDelivery deliver(Order order, List<FoodItem> items) {
        FoodDelivery foodDelivery = new FoodDelivery();
        foodDelivery.setOrderId(order.getOrderId());
        foodDelivery.setFoodData(items);

        LOGGER.info("Delivering {} to {}", order.getOrderId(), order.getEmail());
        return foodDelivery;
    }
}
