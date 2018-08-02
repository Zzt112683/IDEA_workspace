package utils;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
            .build(MybatisUtil.class.getClassLoader().getResourceAsStream("mybatis-config.xml"));

    public static SqlSession getSession(boolean autoCommit){
        return sqlSessionFactory.openSession(autoCommit);
    }

}
