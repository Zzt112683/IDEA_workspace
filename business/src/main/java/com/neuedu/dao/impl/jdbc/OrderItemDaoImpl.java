package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.neuedu.dao.OrderItemDao;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.utils.DBUtils;
import com.neuedu.utils.Utils;

public class OrderItemDaoImpl implements OrderItemDao{
	
	@Override
	public boolean addOrderItem(List<UserOrderItem> orderItems) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		Boolean boo = false;
		UserOrderItem orderItem = orderItems.get(0);
		
		/*
		 	private int id; // ???????ID
			private long order_no;// ???????????
			private int user_id;// ???id
			private int product_id;// ???id
			private String product_name;// ???????
			private String product_image;// ?????
			private double current_unit_price;// ????????????
			private int quantity;// ???????
			private double total_price; // ???
			private long create_time;// ???????
			private long update_time;// ???????
		 * */
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			for (int i = 1; i < orderItems.size(); i++) {
				orderItem.setTotal_price(orderItem.getTotal_price()+orderItems.get(i).getTotal_price());
				orderItem.setProduct_name(orderItem.getProduct_name()+","+orderItems.get(i).getProduct_name());
				orderItem.setProduct_image(orderItem.getProduct_image()+","+orderItems.get(i).getProduct_image());
			}
			String sql = "insert into userorderitem(order_no,user_id,product_id,product_name,product_image,current_unit_price,quantity,total_price,create_time) "
					+ "values("+orderItem.getOrder_no()+","+orderItem.getUser_id()+","+orderItem.getProduct_id()+",'"+orderItem.getProduct_name()+"','"+orderItem.getProduct_image()+"',"+orderItem.getCurrent_unit_price()+","+orderItem.getQuantity()+","+orderItem.getTotal_price()+",'"+Utils.getTime()+"')";
			System.out.println(sql);
			boo = st.execute(sql);
					
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
		
		
		return boo;
	}

	@Override
	public List<UserOrderItem> findOrderItem() {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<UserOrderItem> userOrderItem = new ArrayList<UserOrderItem>();
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "select order_no,user_id,product_id,product_name,product_image,current_unit_price,quantity,total_price,create_time from userorderitem";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {
				long order_no = rs.getLong("order_no");
				int user_id = rs.getInt("user_id");
				int product_id = rs.getInt("product_id");
				String product_name = rs.getString("product_name");
				String product_image = rs.getString("product_image");
				double current_unit_price = rs.getDouble("current_unit_price");
				int quantity = rs.getInt("quantity");
				double total_price = rs.getDouble("total_price");
				long create_time = rs.getLong("create_time");
				
				UserOrderItem userOrderItems = new UserOrderItem();
				userOrderItems.setOrder_no(order_no);
				userOrderItems.setUser_id(user_id);
				userOrderItems.setProduct_id(product_id);
				userOrderItems.setProduct_name(product_name);
				userOrderItems.setProduct_image(product_image);
				userOrderItems.setCurrent_unit_price(current_unit_price);
				userOrderItems.setQuantity(quantity);
				userOrderItems.setTotal_price(total_price);
				userOrderItems.setCreate_time(create_time);
				
				userOrderItem.add(userOrderItems);
				return userOrderItem;
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
		
		return userOrderItem;
	}

	@Override
	public int getOrderItemId() {
		// TODO Auto-generated method stub
		return (new Random()).nextInt(100);
	}

}
