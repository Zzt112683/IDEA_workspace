package com.neuedu.service.impl;


import java.util.List;

import com.neuedu.dao.CategoryDao;
import com.neuedu.dao.impl.jdbc.CategoryDaoImpl;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.service.CategoryService;


public class CategoryServiceImpl implements CategoryService{

	CategoryDao cgd = new CategoryDaoImpl();
	
	@Override
	public boolean addCategory(Category category) {
		
		// TODO Auto-generated method stub
		return cgd.addCategory(category);
		
	}

	@Override
	public List<Category> findCategory() {
		// TODO Auto-generated method stub
		return cgd.findCategory();
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return cgd.updateCategory(category);
	}

	@Override
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		return cgd.deleteCategory(id);
	}

	@Override
	public Category findCategoryById(int id) {
		// TODO Auto-generated method stub
		return cgd.findCategoryById(id);
	}

	@Override
	public PageModel<Category> findCatrgoryByPage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return cgd.findCatrgoryByPage(pageNo, pageSize);
	}

}
