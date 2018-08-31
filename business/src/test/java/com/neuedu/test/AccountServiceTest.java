package com.neuedu.test;

import com.neuedu.dao.LoginDao;
import com.neuedu.dao.impl.mybatis.LoginMybatisImpl;
import com.neuedu.service.AccountService;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountServiceTest {

    /*ApplicationContext applicationContext=null;*/







    @Test
    public void testTransfer(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
       AccountService accountService  = (AccountService)applicationContext.getBean("accountServiceImpl");
        accountService.transfer("zhangsan","lisi",600);

    }

}
