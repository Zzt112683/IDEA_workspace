package com.neuedu.action;

import com.neuedu.entity.Emp;
import com.neuedu.mapper.EmpMapper;
import com.neuedu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/addEmp"})
public class AddEmpServlet extends HttpServlet{


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
//        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        Integer salary = Integer.parseInt(req.getParameter("salary"));
        String job = req.getParameter("job");
        SqlSession sqlSession = MybatisUtil.getSession(true);
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        empMapper.saveEmp(new Emp(null,name,salary,job));
        sqlSession.close();
        //该重定向还是转发
        resp.sendRedirect("emplist");
    }
}
