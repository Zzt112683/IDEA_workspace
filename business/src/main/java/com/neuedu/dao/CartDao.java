package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;


public interface CartDao {

	boolean addCart(Cart cart);//��
	
	List<Cart> findCart();//��
	
	boolean updateCart(Cart cart);//��
	
	boolean deleteCart(int id);//ɾ
	
	Product findProductById(int id);
	
	Product findProductById_upd(int id);
	
	int getOrderId();
	
	boolean updateCart(int id, int num);
	
	Cart getCartById(int id);
	
	void clearCart();
	
	/*public static void main(String[] args){
		
		CartDao cd = new CartDaoImpl();
		List<Cart> carts = cd.findCart();
		
		String json = JSONArray.toJSONString(carts);
		System.out.println(json);
		
	}*/
	
	
	
}
