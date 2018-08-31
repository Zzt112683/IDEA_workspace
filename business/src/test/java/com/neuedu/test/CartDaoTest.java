package com.neuedu.test;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.impl.mybatis.CartDaoMybatisImpl;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CartDaoTest {


    CartDao cartDao;
    @Before
    public void before(){
        /*cartDao = new CartDaoMybatisImpl();*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        cartDao = (CartDao)applicationContext.getBean("cartDao");
    }

    @Test
    public void testAddCart(){

        Cart cart = new Cart();
        Product product = new Product(14,"特朗普","充气娃娃",222,"sad","拉阿拉蕾");
        cart.setProduct(product);
        cart.setProductnum(20);

        cartDao.addCart(cart);
        System.out.println(cart);
    }

    @Test
    public void testFindCart(){

     List<Cart> list = cartDao.findCart();
        System.out.println(list);

    }

    @After
    public void destory(){
        cartDao = null;
    }
}
