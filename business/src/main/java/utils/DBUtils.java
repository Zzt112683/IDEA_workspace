package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBUtils {
	
	static {
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ȡ����
	public static Connection getConnection() throws SQLException {
		String url="jdbc:mysql://127.0.0.1:3306/bussiness";
		String user="root";
		String password="1234";
		
		return DriverManager.getConnection(url,user,password);
	}
	//�ر�����
	public static void close (Connection conn,Statement st) throws SQLException {
		if(conn != null) {
			conn.close();
		}
		if(st != null) {
			st.close();
		}
		
	}
	public static void close (Connection conn,Statement st,ResultSet rs) throws SQLException {
		if(conn != null) {
			conn.close();
		}
		if(st != null) {
			st.close();
		}
		if(rs != null) {
			rs.close();
		}
	}
	

}
