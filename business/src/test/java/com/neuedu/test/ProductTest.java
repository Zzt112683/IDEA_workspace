package com.neuedu.test;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.neuedu.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductTest {

   ProductService productService = null;
    @Before
    public void before(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        //step 2 从容器中获取bean
         productService =  (ProductService)applicationContext.getBean("productServiceImpl");

    }

    @Test
    public void testFindProduct(){

        List<Product> list = productService.findAll();
        System.out.println(list);
        System.out.println(list.size());

    }
    @Test
    public void testAddProduct(){


        Product product = new Product("夏天","汽车",20000,"hot","哈哈哈");
        productService.addProduct(product);
        System.out.println(product);
    }
    @Test
    public void testDeleteProduct(){
        productService.deleteProduct(20);
    }
    @Test
    public void testUpdateProduct(){
        Product product = new Product(18,"法拉利","跑车",80000000,"cool","嘻嘻嘻");
        productService.updateProduct(product);
        System.out.println(product);
    }
    @Test
    public void testFindProductByPage(){
        PageModel<Product> pageModel = productService.findProductByPage(1,2);
        System.out.println(pageModel);
    }

    @Test
    public void findProductById(){
        productService.findProductById(15);
    }


    @After
    public void destory(){
        productService = null;
    }

}
