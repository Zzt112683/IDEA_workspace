package com.neuedu.test;

import entity.PageModel;
import entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.impl.ProductServiceImpl;

import java.util.List;

public class ProductTest {

    ProductServiceImpl productService = null;
    @Before
    public void before(){
        productService = new ProductServiceImpl();
    }

    @Test
    public void testFindProduct(){

        List<Product> list = productService.findAll();
        System.out.println(list);
        System.out.println(list.size());

    }
    @Test
    public void testAddProduct(){
        Product product = new Product("夏利","汽车",20000,"hot");
        productService.addProduct(product);
        System.out.println(product);
    }
    @Test
    public void testDeleteProduct(){
        productService.deleteProduct(20);
    }
    @Test
    public void testUpdateProduct(){
        Product product = new Product(18,"法拉利","跑车",8000000,"cool");
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
