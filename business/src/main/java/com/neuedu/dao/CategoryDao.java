package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;


public interface CategoryDao {

	//������
	boolean addCategory(Category category);
	//��ѯ���
	List<Category> findCategory();
	//�޸����
	boolean updateCategory(Category category);
	//ɾ�����
	boolean deleteCategory(int id);;
	
	//����id�鿴���
	Category findCategoryById(int id);
	
	
	
	PageModel<Category> findCatrgoryByPage(int pageNo, int pageSize);
	
}
