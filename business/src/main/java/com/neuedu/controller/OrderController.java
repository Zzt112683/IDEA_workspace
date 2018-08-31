package com.neuedu.controller;

import java.util.List;

import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.service.OrderService;
import com.neuedu.service.impl.OrderServiceImpl;

public class OrderController {

	OrderService os = new OrderServiceImpl();

	public boolean createOrder() {
		return os.createOrder();

	}

	public List<UserOrder> findOrder() {
		return os.findOrder();
	}

	public List<UserOrderItem> findOrderItem() {
		return os.findOrderItem();
	}
}
