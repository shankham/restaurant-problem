package com.restaurant.demo.service;

import com.restaurant.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MenuDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    MenuRowMapper menuRowMapper;

    public int addMenu(Menu menu) {
        int result;
        result = jdbcTemplate.update("merge into menu(menu_name, description, image, price, additional) key(menu_name) " + "select ?, ?, ?, ?, ? from dual",
                new Object[]{
                        menu.getName().toUpperCase(), menu.getDescription(), menu.getImage(), menu.getPrice(), String.join(",", menu.getAdditional())
                });

        return result;
    }

        public Menu getMenuPrice(String name) {
        return jdbcTemplate.queryForObject("select * from menu where upper(menu_name)=?",
                new Object[] { name.toUpperCase() },
                new BeanPropertyRowMapper<>(Menu.class));
    }

    
}
