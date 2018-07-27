package dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import dao.LoginDao;
import entity.Account;
import utils.DBUtils;

public class LoginDaoImpl implements LoginDao{

	@Override
	public Account LoginLogic(String username, String password) {
		// TODO Auto-generated method stub
		Account account = null;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			 conn = DBUtils.getConnection();
			 //st = (PreparedStatement) conn.createStatement();
			 String sql = "select * from user where username = ? and password = ? ";
			 st = conn.prepareStatement(sql);
			 //��ռλ����ֵ
			 st.setString(1, username);
			 st.setString(2, password);
			 System.out.println(sql);
			
			 rs = st.executeQuery();
			if(rs.first()) {
				int id = rs.getInt("id");
				String username1 = rs.getString("username");
				String password1 = rs.getString("password");
				String ip = rs.getString("ip");
				String sex = rs.getString("sex");
				account = new Account(id,username1,password1,ip,sex);
				
			}
			return account;
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
		

		return account;
	}

	@Override
	public void addToken(String token, Account acc) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "update user set token = ? where id = ?";
			st = conn.prepareStatement(sql);
			st.setString(1,token);
			st.setInt(2, acc.getId());
			
//			String sql = "update product set name = '"+product.getName()+"','"+product.getDetail()+"',"+product.getPrice()+",'"+product.getImage()+"',"+product.getStock()+" where id = "+ product.getId() +"";
			
			System.out.println(sql);
			st.execute();
	
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
		
	}

	@Override
	public String findTokenById(int id) {
		// TODO Auto-generated method stub
		Account account = null;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			 conn = DBUtils.getConnection();
			 //st = (PreparedStatement) conn.createStatement();
			 String sql = "select token from user where id = ? ";
			 st = conn.prepareStatement(sql);
			 //��ռλ����ֵ
			 st.setInt(1, id);
			 
			 System.out.println(sql);
			
			 rs = st.executeQuery();
			if(rs.first()) {
				
				String token = rs.getString("token");
				
				
				return token;
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
		return null;
	}
	

}
