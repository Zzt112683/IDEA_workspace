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

@WebServlet(urlPatterns = {"/updateEmpView"})
public class UpdateEmpViewServlet extends HttpServlet{


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        SqlSession sqlSession = MybatisUtil.getSession(true);
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpById(id);
        req.setAttribute("emp",emp);
        sqlSession.close();
        //根据id查询数据
        req.getRequestDispatcher("updateEmp.jsp").forward(req,resp);
    }
}
