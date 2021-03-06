package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.UserOrder;

public interface OrderDao {

	// 创建订单
	boolean createOrder(UserOrder order);

	// �鿴����
	List<UserOrder> findOrder();

	// 生成订单ID
	int getOrderId();

	//根据订单编号查询订单
	List<UserOrder> findOrderByOrderno(long orderno);


}
