package dao;

import java.util.List;

import entity.UserOrderItem;

public interface OrderItemDao {

	// �Ѷ�����ϸ��������ϸ��Ӧһ������Ʒ��Ӧ���Ǽ��ϣ����붩����ϸ������
	boolean addOrderItem(List<UserOrderItem> orderItem);

	List<UserOrderItem> findOrderItem();

	int getOrderItemId();
}
