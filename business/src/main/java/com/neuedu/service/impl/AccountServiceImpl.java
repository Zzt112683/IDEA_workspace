package com.neuedu.service.impl;

import com.neuedu.dao.LoginDao;
import com.neuedu.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,readOnly = false,timeout = 1000)
public class AccountServiceImpl implements AccountService{

    @Resource(name = "loginMybatisImpl")
    LoginDao loginDao;

    @Override

    public void transfer(String fromuser, String touser, double money) {
        loginDao.updateAccount(fromuser,2000-money);

        int i = 1/0;
        loginDao.updateAccount(touser,2000+money);
    }
}
