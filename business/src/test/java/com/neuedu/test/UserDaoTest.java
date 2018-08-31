package com.neuedu.test;

import com.neuedu.dao.LoginDao;
import com.neuedu.dao.impl.mybatis.LoginMybatisImpl;
import com.neuedu.entity.Account;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){

        LoginDao loginDao = new LoginMybatisImpl();
        Account acc = loginDao.LoginLogic("a","0cc175b9c0f1b6a831c399e269772661");
        System.out.println(acc);
    }

}
