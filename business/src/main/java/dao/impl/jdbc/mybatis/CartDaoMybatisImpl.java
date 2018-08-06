package dao.impl.jdbc.mybatis;

import dao.CartDao;
import entity.Cart;
import entity.Product;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import java.util.List;

public class CartDaoMybatisImpl implements CartDao{

    SqlSession session = MybatisUtil.getSession(true);


    @Override
    public boolean addCart(Cart cart) {
        CartDao cartDao = session.getMapper(CartDao.class);
        cartDao.addCart(cart);
        session.commit();
        session.close();

        return false;
    }

    @Override
    public List<Cart> findCart() {
        CartDao cartDao = session.getMapper(CartDao.class);
        List<Cart> list = cartDao.findCart();
        session.commit();
        session.close();
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
