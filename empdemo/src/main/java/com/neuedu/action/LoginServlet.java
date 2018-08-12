package com.neuedu.action;

import com.neuedu.entity.User;
import com.neuedu.mapper.UserMapper;
import com.neuedu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //根据用户名查询user
        SqlSession session = MybatisUtil.getSession(true);
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.getUserByUsername(username);
        session.close();
        if (user != null && user.getPassword().equals(password)){
            //将登陆的用户信息存储到session中
            HttpSession httpSession = req.getSession();
            httpSession.setMaxInactiveInterval(8);
            httpSession.setAttribute("user",user);
            //将登陆信息存储到cookie中一份
            Cookie cookie = new Cookie("username",user.getUsername());
            cookie.setMaxAge(60*60*24*7);
            resp.addCookie(cookie);
            //登陆成功情况
//            resp.sendRedirect("emplist");
            out.print(true);
        }else {
//            resp.sendRedirect("login.jsp");
            out.print(false);
        }

    }
}
