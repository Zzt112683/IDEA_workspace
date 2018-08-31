package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;

public interface CategoryService {

	//������
		boolean addCategory(Category category);
		//��ѯ���
		List<Category> findCategory();
		//�޸����
		boolean updateCategory(Category category);
		//ɾ�����
		boolean deleteCategory(int id);
	
		//����id�鿴���
	 Category findCategoryById(int id);
	 
	 
	 PageModel<Category> findCatrgoryByPage(Integer pageNo, Integer pageSize);
	 
	 
}
