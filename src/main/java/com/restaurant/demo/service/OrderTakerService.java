package com.restaurant.demo.service;

import com.restaurant.controller.ResponseEntity;
import com.restaurant.demo.database.Autowired;
import com.restaurant.demo.domain.Order;
import com.restaurant.demo.domain.ResponseConstant;
import com.restaurant.demo.domain.ResponseWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderTakerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderTakerService.class.getName());
    @Autowired
    OrderDao orderDao;
    public ResponseEntity<ResponseWrapper> takeOrder(List<Map<String, String>> body) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        try {
            Timestamp timestamp = getCurrentTime();
            for(int i =0; i<body.size(); i++) {
	            Order order = new Order(body.get(i).get("billNo"), body.get(i).get("menu"), Integer.parseInt(body.get(i).get("quantity")), timestamp);
	            orderDao.addOrder(order);
            }
            responseWrapper.setResponseCode(ResponseConstant.SUCCESS_CODE);
            responseWrapper.setResponseDesc(ResponseConstant.SUCCESS);
            responseWrapper.setResponseStatus(ResponseConstant.SUCCESS);
        } catch (ParseException e){
            responseWrapper.setResponseCode(ResponseConstant.FAIL_CODE);
            responseWrapper.setResponseDesc(ResponseConstant.FAIL);
            responseWrapper.setResponseStatus(e.getMessage());
        }

        logger.info(responseWrapper.toString());
        ResponseEntity<ResponseWrapper> response = new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        return response;
    }
}
