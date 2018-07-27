package service.impl;


import java.util.List;

import dao.CategoryDao;
import dao.impl.jdbc.CategoryDaoImpl;
import entity.Category;
import entity.PageModel;
import service.CategoryService;


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
