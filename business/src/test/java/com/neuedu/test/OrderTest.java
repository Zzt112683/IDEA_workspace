package com.neuedu.test;

import com.neuedu.dao.OrderDao;
import com.neuedu.dao.impl.mybatis.OrderDaoMybatisImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.neuedu.service.OrderService;
import com.neuedu.service.impl.OrderServiceImpl;

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
