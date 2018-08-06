package com.neuedu.test;

import dao.OrderDao;
import dao.impl.jdbc.OrderDaoImpl;
import dao.impl.jdbc.mybatis.OrderDaoMybatisImpl;
import entity.Cart;
import entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.OrderService;
import service.impl.OrderServiceImpl;

public class OrderTest {

    OrderService orderService = null;
    OrderDao orderDao = null;

    @Before
    public void before(){
        orderService = new OrderServiceImpl();
        orderDao = new OrderDaoMybatisImpl();
    }

    @Test
    public void testCreateCart(){

        orderService.createOrder();
    }

    @Test
    public void testFindOrderByorderno(){

        System.out.println(orderDao.findOrderByOrderno(1533474443016L));
    }


    @After
    public void destory(){
        orderService = null;
    }

}
