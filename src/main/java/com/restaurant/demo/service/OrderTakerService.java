package com.restaurant.demo.service;

import com.restaurant.demo.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderTakerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderTakerService.class.getName());

    public void takeOrder(Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        LOGGER.info("New order : {}", order.getOrderId());
    }
}
