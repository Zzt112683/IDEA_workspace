package dao.impl.mybatis;

import dao.LoginDao;
import entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class LoginMybatisImpl implements LoginDao{
    @Override
    public Account LoginLogic(String username, String password) {

        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
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
        Account account = session.selectOne("com.neuedu.entity.Account.findByUsernameAndPassword",map);
        System.out.println(account);
        session.close();


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
