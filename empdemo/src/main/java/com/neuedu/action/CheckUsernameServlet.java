package com.neuedu.action;

import com.neuedu.entity.User;
import com.neuedu.mapper.UserMapper;
import com.neuedu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/checkusername"})
public class CheckUsernameServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        SqlSession sqlSession = MybatisUtil.getSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByUsername(username);
        PrintWriter out = resp.getWriter();
        if (user == null){
            out.print(true);
        }else {
            out.print(false);
        }
        sqlSession.close();
        out.close();
    }
}
