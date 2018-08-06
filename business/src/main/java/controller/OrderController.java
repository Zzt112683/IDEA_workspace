package controller;

import java.util.List;

import entity.UserOrder;
import entity.UserOrderItem;
import service.OrderService;
import service.impl.OrderServiceImpl;

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
