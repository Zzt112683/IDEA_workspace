package dao.impl.jdbc.mybatis;

import dao.OrderItemDao;
import entity.UserOrderItem;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import java.util.List;

public class OrderItemDaoMybatisImpl implements OrderItemDao{

    SqlSession session = MybatisUtil.getSession(true);
    @Override
    public boolean addOrderItem(List<UserOrderItem> orderItem) {
        OrderItemDao orderItemDao = session.getMapper(OrderItemDao.class);
        orderItemDao.addOrderItem(orderItem);

        session.commit();
        session.close();

        return false;
    }

    @Override
    public List<UserOrderItem> findOrderItem() {
        return null;
    }

    @Override
    public int getOrderItemId() {
        return 0;
    }
}
