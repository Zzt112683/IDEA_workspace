package com.neuedu.filter;

import com.neuedu.entity.User;
import com.neuedu.mapper.UserMapper;
import com.neuedu.util.CookieUtil;
import com.neuedu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebFilter(urlPatterns = {"/*"})
public class LoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("创建");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        //1.先放行标准后缀的文件
        if (uri.endsWith("regist")|| uri.endsWith(".jsp")|| uri.endsWith(".js")|| uri.endsWith(".css")|| uri.endsWith(".gif")|| uri.endsWith("login")|| uri.endsWith("image")|| uri.endsWith("fileup")|| uri.endsWith("ajaxtest")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null){
                //判断cookie有没有用户名
                //获取cookie
                Cookie[] cookies = request.getCookies();
                Map<String,Cookie> cookieMap = CookieUtil.getCookieMap(cookies);
                Cookie userCookie = cookieMap.get("username");
                if (userCookie == null){
                    ((HttpServletResponse)servletResponse).sendRedirect("login.jsp");
                }else {
                    String username = userCookie.getValue();
                    SqlSession sqlSession = MybatisUtil.getSession(true);
                    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
                    User u = userMapper.getUserByUsername(username);
                    session.setAttribute("user",u);
                    sqlSession.close();
                    filterChain.doFilter(servletRequest,servletResponse);
                }

            }else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
