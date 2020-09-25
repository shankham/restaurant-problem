package com.restaurant.demo.controller;

//import com.restaurant.controller.ResponseEntity;
import com.restaurant.demo.domain.FoodDelivery;
import com.restaurant.demo.domain.Order;
import com.restaurant.demo.domain.ResponseWrapper;
import com.restaurant.demo.service.MenuDao;
import com.restaurant.demo.service.OrderDao;
import com.restaurant.demo.service.RestaurantService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import java.util.Map;
import java.util.UUID;

@RestController
public class RestaurantController {
	@Autowired
    private final RestaurantService service;    
    
    private final Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    
  /*  @PostMapping(value = "/addOrder", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseEntity  FoodDelivery addOrderrder(final @RequestBody  Order order) {
        return service.order(order);
    }*/

    @PostMapping(value = "/addOrder", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseWrapper>  addOrder(final @RequestBody List<Map<String, String>> order) {
        return service.order(order);
    }

}
