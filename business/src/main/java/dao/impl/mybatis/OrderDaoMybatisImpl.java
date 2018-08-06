package dao.impl.mybatis;

import dao.OrderDao;
import entity.UserOrder;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import java.util.List;

public class OrderDaoMybatisImpl implements OrderDao{

    SqlSession session = MybatisUtil.getSession(true);

    @Override
    public boolean createOrder(UserOrder order) {

        OrderDao orderDao = session.getMapper(OrderDao.class);
        orderDao.createOrder(order);

        session.commit();
        session.close();

        return false;
    }

    @Override
    public List<UserOrder> findOrder() {
        return null;
    }

    @Override
    public int getOrderId() {
        return 0;
    }

    @Override
    public List<UserOrder> findOrderByOrderno(long orderno) {
        System.out.println(orderno);
        OrderDao orderDao = session.getMapper(OrderDao.class);

        List<UserOrder> userOrderlist = orderDao.findOrderByOrderno(orderno);
        session.close();
        return userOrderlist;
    }
}
