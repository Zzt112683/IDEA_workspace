package service;

import java.util.List;

import entity.UserOrder;
import entity.UserOrderItem;

public interface OrderService {

	// ��������
	boolean createOrder();

	// �鿴����
	List<UserOrder> findOrder();

	List<UserOrderItem> findOrderItem();

	// ��ȡ������
	long orderNo();
}
