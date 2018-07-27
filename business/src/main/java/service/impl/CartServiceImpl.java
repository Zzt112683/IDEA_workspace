package service.impl;

import java.util.List;

import dao.CartDao;
import dao.impl.jdbc.CartDaoImpl;
import entity.Cart;
import entity.Product;
import service.CartService;

public class CartServiceImpl implements CartService {

	CartDao cd = new CartDaoImpl();

	@Override
	public boolean addCart(Cart cart) {

		return cd.addCart(cart);
	}

	@Override
	public List<Cart> findCart() {

		return cd.findCart();
	}

	@Override
	public boolean updateCart(Cart cart) {

		return cd.updateCart(cart);
	}

	@Override
	public boolean deleteCart(int id) {

		return cd.deleteCart(id);
	}

	@Override
	public int getOrderId() {

		return cd.getOrderId();
	}
	
	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		return cd.updateCart(id,num);
	}

	@Override
	public Cart getCartById(int id) {

		return cd.getCartById(id);
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return cd.findProductById(id);
	}

	@Override
	public Product findProductById_upd(int id) {
		// TODO Auto-generated method stub
		return cd.findProductById_upd(id);
	}


}
