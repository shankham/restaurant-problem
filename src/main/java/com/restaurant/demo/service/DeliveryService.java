package com.restaurant.demo.service;


import com.restaurant.demo.database.OrderDao;
import com.restaurant.demo.domain.FoodDelivery;
import com.restaurant.demo.domain.FoodItem;
import com.restaurant.demo.domain.Order;
import com.restaurant.demo.util.OrderResponseWrapper;
import com.restaurant.demo.util.ResponseConstant;
import com.restaurant.demo.util.ResponseWrapper;
import com.restaurant.demo.domain.Menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DeliveryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryService.class.getName());
    @Autowired
    OrderDao orderDao;
    public ResponseEntity<ResponseWrapper> deliver(List<Map<String, String>> order, List<FoodItem> items) {
        FoodDelivery foodDelivery = new FoodDelivery();
        foodDelivery.setOrderId(order.get(0).get("billNo"));
        foodDelivery.setFoodData(items);

        List<Order> orders = orderDao.findOrderByBill(order.get(0).get("billNo"));
        int result = orderDao.checkOutOrderByBillNo(order.get(0).get("billNo"));
        int totalPrice = calculatePrice(order);

        OrderResponseWrapper responseWrapper = new OrderResponseWrapper();
        if(result > 0) {
            responseWrapper.setOrders(orders);
            responseWrapper.setResponseCode(ResponseConstant.SUCCESS_CODE);
            responseWrapper.setResponseStatus(ResponseConstant.SUCCESS);
            responseWrapper.setResponseDesc(ResponseConstant.SUCCESS);
            responseWrapper.setTotalPrice(totalPrice);
        } else {
            responseWrapper.setResponseCode(ResponseConstant.FAIL_CODE);
            responseWrapper.setResponseStatus(ResponseConstant.FAIL);
            responseWrapper.setResponseDesc("Got Exception While checking out orders");
        }

        logger.info(responseWrapper.toString());
        ResponseEntity<ResponseWrapper> response = new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        return response;
        
        
      //  LOGGER.info("Delivering {} to {}", order.getOrderId(), order.getEmail());
        return foodDelivery;
    }
    
    public int calculatePrice(List<Order> orders){
        int price = 0;
        for (Order order:orders) {
            Menu menu = menuDao.getMenuPrice(order.get(0).get("menu"));
            price = price + (menu.getPrice() * Integer.parseInt(order.get(0).get("quantity")));
        }
        return price;
    }

    public Timestamp getCurrentTime() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = df.format(new Date());
        Date orderedDate = df.parse(dateStr);
        return new java.sql.Timestamp(orderedDate.getTime());
    }
}
