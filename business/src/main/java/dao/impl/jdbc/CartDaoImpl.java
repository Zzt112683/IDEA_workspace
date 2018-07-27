package dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.CartDao;
import dao.ProductDao;
import entity.Cart;
import entity.Product;
import utils.DBUtils;



public class CartDaoImpl implements CartDao {

	ProductDao productDao = new ProductDaoImpl();
	
	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "insert into cart(productid,productnum) values(?,?)";
			st = conn.prepareStatement(sql);
			st.setInt(1, cart.getProduct().getId());
			st.setInt(2, cart.getProductnum());
			System.out.println(sql);
			st.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List<Cart> findCart() {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Cart> carts = new ArrayList<Cart>();
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "select id,productid,productnum from cart";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {
			int id = rs.getInt("id");
			int product = rs.getInt("productid");
			int productnum = rs.getInt("productnum");
				
			Cart cart = new Cart();
			cart.setId(id);
			cart.setProductnum(productnum);
			cart.setProduct(productDao.findProductById(product));
			
			carts.add(cart);	
					
			}
			return carts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return carts;
	}

	@Override
	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "update cart set productnum = ? where productid = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, cart.getProductnum());
			st.setInt(2, cart.getProduct().getId());
			st.execute();
			System.out.println(sql);

	
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "delete from cart where id = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			st.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public int getOrderId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cart getCartById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "update cart set productnum = "+ num +" where id = "+ id ;
			System.out.println(sql);
			st.execute(sql);
	
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public void clearCart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product findProductById(int id) {				
		Product product = null;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			String sql ="select id,name,detail,price,image,stock from product where id = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			rs = st.executeQuery();
			
			if(rs.first()) {
				product = new Product();
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				double price = rs.getDouble("price");
				String image = rs.getString("image");
				int stock = rs.getInt("stock");
				product.setId(id1);
				product.setName(name);
				product.setDetail(detail);
				product.setPrice(price);
				product.setImage(image);
				product.setStock(stock);
			}
			
			return product;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return product;
	}

	@Override
	public Product findProductById_upd(int id) {
		// TODO Auto-generated method stub
		Product product = null;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			String sql ="select id,name,detail,price,image,stock from product where id = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			rs = st.executeQuery();
			
			if(rs.first()) {
				product = new Product();
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				double price = rs.getDouble("price");
				String image = rs.getString("image");
				int stock = rs.getInt("stock");
				product.setId(id1);
				product.setName(name);
				product.setDetail(detail);
				product.setPrice(price);
				product.setImage(image);
				product.setStock(stock);
			}
			
			return product;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return product;
	}

	

}
