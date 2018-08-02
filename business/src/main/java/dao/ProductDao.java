package dao;

import java.util.List;

import entity.PageModel;
import entity.Product;


public interface ProductDao {
	//���
	boolean addProduct(Product product);
	//�鿴
	List<Product> findAll();
	//�޸�
	boolean updateProduct(Product product);
	//ɾ��
	boolean deleteProduct(int id);
	//����ID�鿴��Ʒ
	Product findProductById(int id);
	/*
	 * 分页获取数据
	 * pageNo:获取第几页
	 * pageSize:每页多少条数据
	 */
	PageModel<Product> findProductByPage(int pageNo, int pageSize);
	
	
	//list-->json
	/*public static void main(String[] args){
		
		ProductService ps = new ProductServiceImpl();
		List<Product> products = ps.findAll();
		
		String json = JSONArray.toJSONString(products);
		System.out.println(json);
		
	}*/
	
	
}
