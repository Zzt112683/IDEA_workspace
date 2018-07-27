package service;

import java.util.List;

import entity.PageModel;
import entity.Product;


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
	
	
	
	//��ҳ��ȡ��Ʒ��Ϣ
	PageModel<Product> findProductByPage(Integer pageNo, Integer pageSize);
		
	
}
