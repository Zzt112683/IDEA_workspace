package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.ProductDao;

import com.neuedu.dao.impl.mybatis.ProductDaoMybatisImpl;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao pd ;

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
	public boolean updateStock(Product product) {
		return pd.updateStock(product);
	}

	@Override
	public PageModel<Product> findProductByPage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		
		return pd.findProductByPage(pageNo, pageSize);
	}

}
