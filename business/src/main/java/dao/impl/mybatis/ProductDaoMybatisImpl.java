package dao.impl.mybatis;

import dao.ProductDao;
import entity.PageModel;
import entity.Product;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoMybatisImpl implements ProductDao{

    SqlSession session = MybatisUtil.getSession(true);

    @Override
    public boolean addProduct(Product product) {
        /*ProductDao productDao = session.getMapper(ProductDao.class);
        productDao.addProduct(product);*/
        session.selectList("entity.Product.addProduct",product);
        session.commit();
        session.close();
        return false;
    }


    @Override
    public List<Product> findAll() {
        /*ProductDao productDao = session.getMapper(ProductDao.class);
        List<Product> list = productDao.findAll();*/

        List<Product> list = session.selectList("entity.Product.findAll");
        session.close();

        return list;
    }



    @Override
    public boolean updateProduct(Product product) {
        /*ProductDao productDao = session.getMapper(ProductDao.class);
        productDao.updateProduct(product);*/

        session.selectList("entity.Product.updateProduct",product);
        session.commit();
        session.close();
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        /*ProductDao productDao = session.getMapper(ProductDao.class);
        productDao.deleteProduct(id);*/

        session.selectList("entity.Product.deleteProduct",id);
        session.commit();
        session.close();
        return false;
    }

    @Override
    public Product findProductById(int id) {
        Product product = session.selectOne("entity.Product.findProductById",id);
        session.close();
        return product;
    }

    //更新库存
    @Override
    public boolean updateStock(Product product) {
        session.selectList("entity.Product.updateStock",product);

        return true;
    }

    @Override
    public PageModel<Product> findProductByPage(int pageNo, int pageSize) {
        //查询总记录数-->计算总页数
        int totalcount=(Integer)session.selectOne("entity.Product.findTotalCount");
        //查询数据
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("offSet",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Product> products = session.selectList("entity.Product.findProductByPage",map);

        PageModel<Product> pageModel = new PageModel<Product>();
        pageModel.setTotalPage(((totalcount%pageSize)==0?totalcount/pageSize:(totalcount%pageSize)+1));
        pageModel.setData(products);

        session.close();

        return pageModel;
    }
}
