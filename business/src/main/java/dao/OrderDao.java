package dao;

import java.util.List;

import entity.UserOrder;

public interface OrderDao {

	// 创建订单
	boolean createOrder(UserOrder order);

	// �鿴����
	List<UserOrder> findOrder();

	// 生成订单ID
	int getOrderId();
}
