package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import org.apache.ibatis.session.SqlSession;
import com.neuedu.utils.MybatisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDaoMybatisImpl implements CartDao{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public boolean addCart(Cart cart) {
        CartDao cartDao = sqlSession.getMapper(CartDao.class);
        cartDao.addCart(cart);

        return true;
    }

    @Override
    public List<Cart> findCart() {
        CartDao cartDao = sqlSession.getMapper(CartDao.class);
        List<Cart> list = cartDao.findCart();

        return list;
    }

    @Override
    public boolean updateCart(Cart cart) {
        return false;
    }

    @Override
    public boolean deleteCart(int id) {
        return false;
    }

    @Override
    public Product findProductById(int id) {
        return null;
    }

    @Override
    public Product findProductById_upd(int id) {
        return null;
    }

    @Override
    public int getOrderId() {
        return 0;
    }

    @Override
    public boolean updateCart(int id, int num) {
        return false;
    }

    @Override
    public Cart getCartById(int id) {
        return null;
    }

    @Override
    public void clearCart() {
        /*CartDao cartDao = session.getMapper(CartDao.class);
        cartDao.clearCart();
        session.commit();
        session.close();*/
    }
}
