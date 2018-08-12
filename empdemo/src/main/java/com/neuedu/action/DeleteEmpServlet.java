package com.neuedu.action;

import com.neuedu.mapper.EmpMapper;
import com.neuedu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/delete"})
public class DeleteEmpServlet extends HttpServlet{


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //根据id删除数据
        Integer id = Integer.parseInt(req.getParameter("id"));
        SqlSession sqlSession = MybatisUtil.getSession(true);
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        empMapper.deleteEmpById(id);
        sqlSession.close();
        //跳转回列表页
        resp.sendRedirect("emplist");
    }
}
