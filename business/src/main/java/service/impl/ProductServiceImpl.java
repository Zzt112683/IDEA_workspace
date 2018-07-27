package service.impl;

import java.util.List;

import dao.ProductDao;
import dao.impl.jdbc.ProductDaoImpl;
import entity.PageModel;
import entity.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService {

	ProductDao pd = new ProductDaoImpl();

	public boolean addProduct(Product product) {

		return pd.addProduct(product);
	}

	@Override
	public List<Product> findAll() {

		return pd.findAll();
	}

	@Override
	public boolean updateProduct(Product product) {

		return pd.updateProduct(product);
	}

	@Override
	public boolean deleteProduct(int id) {

		return pd.deleteProduct(id);
	}

	@Override
	public Product findProductById(int id) {

		return pd.findProductById(id);
	}

	@Override
	public PageModel<Product> findProductByPage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		
		return pd.findProductByPage(pageNo, pageSize);
	}

}
