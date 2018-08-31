package com.neuedu.utils;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

    //构建与数据库连接的工厂
    private static SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
            .build(MybatisUtil.class.getClassLoader().getResourceAsStream("mybatis-config.xml"));

    public static SqlSession getSession(boolean autoCommit){
        return sqlSessionFactory.openSession(autoCommit);
    }

}
