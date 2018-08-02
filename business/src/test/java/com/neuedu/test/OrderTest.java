package com.neuedu.test;

import dao.OrderDao;
import entity.Cart;
import entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.OrderService;
import service.impl.OrderServiceImpl;

public class OrderTest {

    OrderService orderService = null;

    @Before
    public void before(){
        orderService = new OrderServiceImpl();
    }

    @Test
    public void testCreateCart(){

        orderService.createOrder();

    }

    @After
    public void destory(){
        orderService = null;
    }

}
