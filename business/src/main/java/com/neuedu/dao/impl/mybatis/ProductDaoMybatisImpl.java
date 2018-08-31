package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import org.apache.ibatis.session.SqlSession;
import com.neuedu.utils.MybatisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoMybatisImpl implements ProductDao{

    @Autowired
    SqlSession session;

    @Override
    public boolean addProduct(Product product) {
        /*ProductDao productDao = session.getMapper(ProductDao.class);
        productDao.addProduct(product);*/
        session.insert("com.neuedu.entity.Product.addProduct",product);
        /*session.commit();
        session.close();*/
        return true;
    }


    @Override
    public List<Product> findAll() {
        /*ProductDao productDao = session.getMapper(ProductDao.class);
        List<Product> list = productDao.findAll();*/

        List<Product> list = session.selectList("com.neuedu.entity.Product.findAll");
        /*session.close();*/

        return list;
    }



    @Override
    public boolean updateProduct(Product product) {
        /*ProductDao productDao = session.getMapper(ProductDao.class);
        productDao.updateProduct(product);*/

        session.update("com.neuedu.entity.Product.updateProduct",product);
        /*session.commit();
        session.close();*/
        return true;
    }

    @Override
    public boolean deleteProduct(int id) {
        /*ProductDao productDao = session.getMapper(ProductDao.class);
        productDao.deleteProduct(id);*/

        session.delete("com.neuedu.entity.Product.deleteProduct",id);
        /*session.commit();
        session.close();*/
        return true;
    }

    @Override
    public Product findProductById(int id) {
        Product product = session.selectOne("com.neuedu.entity.Product.findProductById",id);
        /*session.close();*/
        return product;
    }

    //更新库存
    @Override
    public boolean updateStock(Product product) {
        session.selectList("com.neuedu.entity.Product.updateStock",product);

        return true;
    }

    @Override
    public PageModel<Product> findProductByPage(int pageNo, int pageSize) {
        //查询总记录数-->计算总页数
        int totalcount=(Integer)session.selectOne("com.neuedu.entity.Product.findTotalCount");
        //查询数据
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("offSet",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Product> products = session.selectList("com.neuedu.entity.Product.findProductByPage",map);

        PageModel<Product> pageModel = new PageModel<Product>();
        pageModel.setTotalPage((totalcount%pageSize==0)?(totalcount/pageSize):(totalcount/pageSize+1));
        pageModel.setData(products);
        pageModel.setCurrentPage(pageNo);

        /*session.close();*/

        return pageModel;
    }
}
