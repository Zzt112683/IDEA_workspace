package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.LogDao;
import com.neuedu.entity.LogBean;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LogDaoMybatisImpl implements LogDao{

    @Autowired
    SqlSession session;
    @Override
    public void add(LogBean logBean) {

        LogDao logDao = session.getMapper(LogDao.class);
        logDao.add(logBean);
    }
}
