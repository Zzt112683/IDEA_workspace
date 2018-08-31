package com.neuedu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.OrderDao;
import com.neuedu.dao.OrderItemDao;
import com.neuedu.dao.ProductDao;


import com.neuedu.dao.impl.mybatis.CartDaoMybatisImpl;
import com.neuedu.dao.impl.mybatis.OrderDaoMybatisImpl;
import com.neuedu.dao.impl.mybatis.OrderItemDaoMybatisImpl;
import com.neuedu.dao.impl.mybatis.ProductDaoMybatisImpl;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.service.OrderService;
import com.neuedu.utils.Utils;

public class OrderServiceImpl implements OrderService {

	OrderDao od = new OrderDaoMybatisImpl();// 调用订单Dao层
	OrderItemDao oid = new OrderItemDaoMybatisImpl(); // 调用订单明细Dao层
	CartDao cd = new CartDaoMybatisImpl();
	ProductDao pd = new ProductDaoMybatisImpl();

	/* 创建订单 */
	public boolean createOrder() {
		// temp1 获取购物车信息
		List<Cart> carts = cd.findCart();
		if (carts == null || carts.size() <= 0) {
			return false;
		}
		// temp2 生成订单实体类

		UserOrder userOrder = createUserOrder();

		// temp3 将购物信息集合转成订单明细集合
		List<UserOrderItem> orderItems = new ArrayList<UserOrderItem>();
		for (int i = 0; i < carts.size(); i++) {
			Cart cart = carts.get(i);
			UserOrderItem orderItem = Utils.convertToOrderItem(oid.getOrderItemId(), userOrder.getOrder_no(), cart);
			// temp4 检验库存
			if (orderItem.getQuantity() <= cart.getProduct().getStock()) {
				orderItems.add(orderItem);
			} else {
				return false;
			}
		}

		// temp5 计算订单价格
		userOrder.setPayment(getOrderPrice(orderItems));
		// temp6 下单
		od.createOrder(userOrder);
		oid.addOrderItem(orderItems);
		// temp7 扣库存
		for (int i = 0; i < carts.size(); i++) {
			Cart cart = carts.get(i);
			Product product = cart.getProduct();
			int leftStock = product.getStock() - cart.getProductnum();
			//修改商品库存
			product.setStock(leftStock);
			pd.updateStock(product);
		}

		// temp8清空购物车
		cd.clearCart();

		return true;
	}

	/*
	 * 计算订单总价格
	 */
	private double getOrderPrice(List<UserOrderItem> items) {
		double price = 0;
		for (int i = 0; i < items.size(); i++) {
			UserOrderItem ui = items.get(i);
			price += ui.getTotal_price();
		}
		return price;
	}

	//生成订单号
	private UserOrder createUserOrder() {
		UserOrder order = new UserOrder();
		/*order.setId(a.getId());*/
		order.setOrder_no(orderNo());
		order.setCreate_time(System.currentTimeMillis());

		return order;
	}

	// 获取订单号
	public long orderNo() {

		return System.currentTimeMillis();
	}

	// 查看订单
	public List<UserOrder> findOrder() {

		return od.findOrder();
	}

	@Override
	public List<UserOrderItem> findOrderItem() {

		return oid.findOrderItem();
	}

}
