package com.neuedu.test;

import dao.CartDao;
import dao.impl.jdbc.mybatis.CartDaoMybatisImpl;
import entity.Cart;
import entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CartDaoTest {

    CartDao cartDao = null;
    @Before
    public void before(){
        cartDao = new CartDaoMybatisImpl();
    }

    @Test
    public void testAddCart(){

        Cart cart = new Cart();
        Product product = new Product(14,"特朗普","充气娃娃",22,"sad","拉阿拉蕾");
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
