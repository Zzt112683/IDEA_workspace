package com.neuedu.test;

import dao.LoginDao;
import dao.impl.jdbc.mybatis.LoginMybatisImpl;
import entity.Account;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){

        LoginDao loginDao = new LoginMybatisImpl();
        Account acc = loginDao.LoginLogic("a","0cc175b9c0f1b6a831c399e269772661");
        System.out.println(acc);
    }

}
