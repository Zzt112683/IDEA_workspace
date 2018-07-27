package service;

import java.util.List;

import entity.Category;
import entity.PageModel;

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
