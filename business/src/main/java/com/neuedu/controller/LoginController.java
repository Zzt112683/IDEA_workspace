package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.neuedu.entity.Account;
import com.neuedu.service.LoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;

@WebServlet(urlPatterns= {"/login"})
public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginService ls = new LoginServiceImpl();
		
		
		 String username = req.getParameter("username");
		 String password = req.getParameter("password");
		System.out.println(password);
		Account acc = ls.LoginLogic(username, MD5Utils.GetMD5Code(password));
		System.out.println(password);
		String method = req.getParameter("method");
		if(acc != null) {
			//��½�ɹ�
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(3600*24*7);
			resp.addCookie(cookie);
			Cookie pwd_cookie = new Cookie("password", MD5Utils.GetMD5Code(password));
			pwd_cookie.setMaxAge(3600*24*7);
			resp.addCookie(pwd_cookie);
			
			//����token����ŵ����ݿ���
			long time = System.currentTimeMillis();
			String token = MD5Utils.GetMD5Code(username+password+time);
			ls.addToken(token,acc);
			//token�ŵ��Ự����
			HttpSession session = req.getSession();
			session.setAttribute("token",token);
			session.setAttribute("acc", acc);

			/*Gson gson = new Gson();
			String json = gson.toJson(acc);
			//json转java
			PrintWriter write = resp.getWriter();
			//????JS??success????
			write.print(method+"("+json+")");*/
			
			req.getRequestDispatcher("view/home.jsp").forward(req, resp);
		}else {
			//��¼ʧ��
			req.getRequestDispatcher("view/fail.jsp").forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
		
	}

	

	

	

	
}
