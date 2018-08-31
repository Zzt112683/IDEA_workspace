package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;

public interface CartService {

	boolean addCart(Cart cart);// ��

	List<Cart> findCart();// ��

	boolean updateCart(Cart cart);// ��

	boolean deleteCart(int id);// ɾ
	
	// ���ݣɣķ�����Ʒ
		Product findProductById(int id);
		Product findProductById_upd(int id);
		

	public int getOrderId();
	
	boolean updateCart(int id, int num);

	Cart getCartById(int id);

}
