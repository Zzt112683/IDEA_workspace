package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import org.springframework.stereotype.Service;


public interface ProductService {

	// ���
	boolean addProduct(Product product);

	// �鿴
	List<Product> findAll();

	// �޸�
	boolean updateProduct(Product product);

	// ɾ��
	boolean deleteProduct(int id);

	// ���ݣɣķ�����Ʒ
	Product findProductById(int id);

	//更新库存
	boolean updateStock(Product product);
	
	
	//��ҳ��ȡ��Ʒ��Ϣ
	PageModel<Product> findProductByPage(Integer pageNo, Integer pageSize);
		
	
}
