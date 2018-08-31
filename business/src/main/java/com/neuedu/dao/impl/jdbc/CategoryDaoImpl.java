package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CategoryDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;

import com.neuedu.utils.DBUtils;


public class CategoryDaoImpl implements CategoryDao{

	
	
	
	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "insert into category(parent_id,name,status,sort_order,creat_time,update_time) values(?,?,?,?,now(),now())";
			st = conn.prepareStatement(sql);
			st.setInt(1, category.getParent_id());
			st.setString(2, category.getName());
			st.setInt(3, category.getStatus());
			st.setInt(4, category.getSort_order());
			
			
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
	public List<Category> findCategory() {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Category> categorys = new ArrayList<Category>();
		try {
			conn = DBUtils.getConnection();
			st = conn.createStatement();
			String sql ="select id,parent_id,name,status,sort_order,creat_time,update_time from category";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				int parent_id = rs.getInt("parent_id");
				String name = rs.getString("name");
				int status = rs.getInt("status");
				int sort_order = rs.getInt("sort_order");
				String creat_time = rs.getString("creat_time");
				String update_time = rs.getString("update_time");
				
				Category category = new Category(id,parent_id,name,status,sort_order,creat_time,update_time);
				categorys.add(category);
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
		return categorys;
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "update category set parent_id=?,name = ?,status =?,sort_order = ?,update_time = now() where id = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, category.getParent_id());
			st.setString(2, category.getName());
			st.setInt(3, category.getStatus());
			st.setInt(4, category.getSort_order());
			st.setInt(5, category.getId());
			System.out.println(sql);
			st.execute();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "delete from category where id = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Category findCategoryById(int id) {
		// TODO Auto-generated method stub
		Category category = null;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select id,parent_id,name,status,sort_order,creat_time,update_time from category where id =?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			rs = st.executeQuery();
			
			if(rs.first()) {
				category = new Category();
				int id1 = rs.getInt("id");
				int parent_id = rs.getInt("parent_id");
				String name = rs.getString("name");
				int status = rs.getInt("status");
				int sort_order = rs.getInt("sort_order");
				String creat_time = rs.getString("creat_time");
				String update_time = rs.getString("update_time");
				category.setId(id1);
				category.setParent_id(parent_id);
				category.setStatus(status);
				category.setName(name);
				category.setSort_order(sort_order);
				category.setCreat_time(creat_time);
				category.setUpdate_time(update_time);
			}
			return category;
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
		
		return category;
	}

	@Override
	public PageModel<Category> findCatrgoryByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageModel<Category> pageModel = new PageModel<Category>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
	
		try {
			conn = DBUtils.getConnection();
			
			//��ѯ�ܵļ�¼��
			String sqlcount = "select count(id) from category";
			st = conn.prepareStatement(sqlcount);
			rs = st.executeQuery();
			if(rs.next()) {
				//�ܼ�¼
				int totalCount = rs.getInt(1);
				//������ҳ��
				int totalPage = (totalCount%pageSize)==0?totalCount/pageSize:(totalCount/pageSize+1);
				pageModel.setTotalPage(totalPage);
			}
			
			
			String sql ="select id,parent_id,name,status,sort_order,creat_time,update_time from category limit ?,?";
			st = conn.prepareStatement(sql);
			st.setInt(1, (pageNo-1)*pageSize);
			st.setInt(2, pageSize);
			System.out.println(sql);
			rs = st.executeQuery();
			List<Category> list = new ArrayList<Category>();
			while(rs.next()) {
				int id = rs.getInt("id");
				int parent_id = rs.getInt("parent_id");
				String name = rs.getString("name");
				int status = rs.getInt("status");
				int sort_order = rs.getInt("sort_order");
				String creat_time = rs.getString("creat_time");
				String update_time = rs.getString("update_time");
				
				Category category = new Category(id,parent_id,name,status,sort_order,creat_time,update_time);
				list.add(category);
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
