package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.LoginDao;
import com.neuedu.entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

@Repository
public class LoginMybatisImpl implements LoginDao{

    @Autowired
    private SqlSession session;

    @Override
    public void updateAccount(String username, double money) {


        /*LoginDao loginDao = sqlSession.getMapper(LoginDao.class);
        loginDao.updateAccount(username,money);*/
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("username",username);
        map.put("money",money);
        session.update("com.neuedu.entity.Account.updatemoney",map);

    }

    @Override
    public Account LoginLogic(String username, String password) {

        String resource = "mybatis-config.xml";
        Reader reader = null;
//        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        session = sqlMapper.openSession();

        Map<String,String> map = new HashMap<String,String>();
        map.put("username",username);
        map.put("password",password);
        Account account = session.selectOne("com.neuedu.com.neuedu.entity.Account.findByUsernameAndPassword",map);
        System.out.println(account);
        //关闭SqlSession
//        sqlSession.close();


        return account;
    }

    @Override
    public void addToken(String token, Account acc) {

    }

    @Override
    public String findTokenById(int id) {
        return null;
    }
}
