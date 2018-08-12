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

@WebServlet(urlPatterns = {"/updateEmp"})
public class UpdateEmpServlet extends HttpServlet{


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Integer salary = Integer.parseInt(req.getParameter("salary"));
        String job = req.getParameter("job");
        SqlSession sqlSession = MybatisUtil.getSession(true);
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        empMapper.updateEmp(new Emp(id,name,salary,job));
        sqlSession.close();
        resp.sendRedirect("emplist");
    }
}
