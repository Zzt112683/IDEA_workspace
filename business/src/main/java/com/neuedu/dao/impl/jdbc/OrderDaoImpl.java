package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.UserOrder;
import com.neuedu.utils.DBUtils;
import com.neuedu.utils.Utils;

public class OrderDaoImpl implements OrderDao{

	@Override
	public boolean createOrder(UserOrder order) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		boolean boo =false;
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			/*
			  	
				private long order_no;
				private int user_id;
				private int shopping_id;
				private double payment;
				private int payment_type;
				private int postage;
				private int status;
				private long create_time;
			 */
			String sql = "insert into userorder(order_no,user_id,shopping_id,payment,payment_type,postage,status,create_time) "
					+ "values("+order.getOrder_no()+","+order.getUser_id()+","+order.getShopping_id()+","+order.getPayment()+","+order.getPayment_type()+","+order.getPostage()+","+order.getStatus()+",'"+Utils.getTime()+"')";
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
	public List<UserOrder> findOrder() {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<UserOrder> userOrder = new ArrayList<UserOrder>();
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql = "select order_no,user_id,shopping_id,payment,payment_type,postage,status,create_time from userorder";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {
				long order_no = rs.getLong("order_no");
				int user_id = rs.getInt("user_id");
				int shopping_id = rs.getInt("shopping_id");
				double payment = rs.getDouble("payment");
				int payment_type = rs.getInt("payment_type");
				int postage = rs.getInt("postage");
				int status = rs.getInt("status");
				long create_time = rs.getLong("create_time");			 
								
				UserOrder userOrders = new UserOrder();
				userOrders.setOrder_no(order_no);
				userOrders.setUser_id(user_id);
				userOrders.setShopping_id(shopping_id);
				userOrders.setPayment(payment_type);
				userOrders.setPayment_type(payment_type);
				userOrders.setPostage(postage);
				userOrders.setStatus(status);
				userOrders.setCreate_time(create_time);
				
				userOrder.add(userOrders);
				
			}
			return userOrder;
			
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
		
		return userOrder;
	}

	@Override
	public int getOrderId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserOrder> findOrderByOrderno(long orderno) {
		return null;
	}

}
