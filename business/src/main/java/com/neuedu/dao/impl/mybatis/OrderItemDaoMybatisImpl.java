package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.OrderItemDao;
import com.neuedu.entity.UserOrderItem;
import org.apache.ibatis.session.SqlSession;
import com.neuedu.utils.MybatisUtil;

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
