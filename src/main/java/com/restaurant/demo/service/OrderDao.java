package com.restaurant.demo.service;

import com.restaurant.demo.domain.FoodItem;
import com.restaurant.demo.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class OrderDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    OrderRowMapper orderRowMapper;

    public List<Order> findOrderByBill(String billNo) {
        return jdbcTemplate.query("select * from customer_order where bill_no=? and checked_out=?",
                new Object[] {
                billNo, 1
                },
                orderRowMapper);
    }

    public List<FoodItem> findFoodItemByMenu(String menu) {
        return jdbcTemplate.query("select * from MENU_PREPARATION where MENU_NAME=?",
                new Object[] {
                	menu 
                },
                orderRowMapper);
    }

    public int addOrder(Order order) {
        return jdbcTemplate.update("insert into customer_order (bill_no, menu, quantity, ordered_time, checked_out) " + "values(?, ?, ?, ?, ?)",
            new Object[] {
                    order.getBillNo(), order.getMenu().toUpperCase(), order.getQuantity(), order.getOrderedTime(), 1
            });
    }

    public int checkOutOrderByBillNo(String billNo) {
        return jdbcTemplate.update("update customer_order " + " set checked_out = ? " + " where bill_no = ?",
                new Object[] {
                    0, billNo
                });
    }
}
