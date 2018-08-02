package dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import dao.ProductDao;
import entity.PageModel;
import entity.Product;
import utils.DBUtils;

public class ProductDaoImpl implements ProductDao{

	
	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "insert into product(name,detail,price,image,stock) values('"+product.getName()+"','"+product.getDetail()+"',"+product.getPrice()+",'"+product.getImage()+"',"+product.getStock()+")";
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
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Product> products = new ArrayList<Product>();
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql ="select id,name,detail,price,image,stock from product";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				double price = rs.getDouble("price");
				String image = rs.getString("image");
				int stock = rs.getInt("stock");
				
				Product product = new Product(id,name,detail,price,image,stock);
				products.add(product);
			}
			
			
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
		return products;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "update product set name=?,Detail = ?,price =?,image = ?,stock = ? where id = ?";
			st = conn.prepareStatement(sql);
			st.setString(1, product.getName());
			st.setString(2, product.getDetail());
			st.setDouble(3, product.getPrice());
			st.setString(4, product.getImage());
			st.setInt(5, product.getStock());
			st.setInt(6, product.getId());
//			String sql = "update product set name = '"+product.getName()+"','"+product.getDetail()+"',"+product.getPrice()+",'"+product.getImage()+"',"+product.getStock()+" where id = "+ product.getId() +"";
			
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
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "delete from product where id = "+id+"";
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
	public Product findProductById(int id) {
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
	@Override
	public PageModel<Product> findProductByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		
		PageModel<Product> pageModel = new PageModel<Product>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
	
		try {
			conn = DBUtils.getConnection();
			
			//��ѯ�ܵļ�¼��
			String sqlcount = "select count(id) from product";
			st = conn.prepareStatement(sqlcount);
			rs = st.executeQuery();
			if(rs.next()) {
				//�ܼ�¼
				int totalCount = rs.getInt(1);
				//������ҳ��
				int totalPage = (totalCount%pageSize)==0?totalCount/pageSize:(totalCount/pageSize+1);
				pageModel.setTotalPage(totalPage);
			}
			
			
			String sql ="select id,name,detail,price,image,stock from product limit ?,?";
			st = conn.prepareStatement(sql);
			st.setInt(1, (pageNo-1)*pageSize);
			st.setInt(2, pageSize);
			System.out.println(sql);
			rs = st.executeQuery();
			List<Product> list = new ArrayList<Product>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				double price = rs.getDouble("price");
				String image = rs.getString("image");
				int stock = rs.getInt("stock");
				
				Product product = new Product(id,name,detail,price,image,stock);
				list.add(product);
			}
			pageModel.setData(list);
			pageModel.setCurrentPage(pageNo);
			
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
		return pageModel;
	}

}
