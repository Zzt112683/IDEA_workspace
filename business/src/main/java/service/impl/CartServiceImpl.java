package service.impl;

import java.util.List;

import dao.CartDao;
import dao.impl.jdbc.CartDaoImpl;
import entity.Cart;
import entity.Product;
import service.CartService;

public class CartServiceImpl implements CartService {

	CartDao cartDao;

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	@Override
	public boolean addCart(Cart cart) {

		return cartDao.addCart(cart);
	}

	@Override
	public List<Cart> findCart() {

		return cartDao.findCart();
	}

	@Override
	public boolean updateCart(Cart cart) {

		return cartDao.updateCart(cart);
	}

	@Override
	public boolean deleteCart(int id) {

		return cartDao.deleteCart(id);
	}

	@Override
	public int getOrderId() {

		return cartDao.getOrderId();
	}
	
	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		return cartDao.updateCart(id,num);
	}

	@Override
	public Cart getCartById(int id) {

		return cartDao.getCartById(id);
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return cartDao.findProductById(id);
	}

	@Override
	public Product findProductById_upd(int id) {
		// TODO Auto-generated method stub
		return cartDao.findProductById_upd(id);
	}


}
