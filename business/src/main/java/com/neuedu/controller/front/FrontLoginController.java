package com.neuedu.controller.front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neuedu.entity.Account;
import com.neuedu.service.LoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;

/**
 * Servlet implementation class FrontLoginController
 */
@WebServlet("/front/login")
public class FrontLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		LoginService ls = new LoginServiceImpl();
		
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String method = req.getParameter("method");
		Account acc = ls.LoginLogic(username, MD5Utils.GetMD5Code(password));
		if(acc != null) {
			//??????
			/*StringBuffer sbuffer = new StringBuffer("{");*/
			
			//?????
			/*sbuffer.append("\"");
			sbuffer.append("username");
			sbuffer.append("\"");
			sbuffer.append(":");
			sbuffer.append("\"");
			sbuffer.append(acc.getUsername());
			sbuffer.append("\"");
			sbuffer.append(",");
			
			//?????
			sbuffer.append("\"");
			sbuffer.append("password");
			sbuffer.append("\"");
			sbuffer.append(":");
			sbuffer.append("\"");
			sbuffer.append(acc.getPassword());
			sbuffer.append("\"");
			sbuffer.append(",");
			
			//?????
			sbuffer.append("\"");
			sbuffer.append("ip");
			sbuffer.append("\"");
			sbuffer.append(":");
			sbuffer.append("\"");
			sbuffer.append(acc.getIp());
			sbuffer.append("\"");
			sbuffer.append(",");
			
			//?????
			sbuffer.append("\"");
			sbuffer.append("sex");
			sbuffer.append("\"");
			sbuffer.append(":");
			sbuffer.append("\"");
			sbuffer.append(acc.getSex());
			sbuffer.append("\"");
			sbuffer.append("}");*/
			
			//gson.jar     google
			//jackson.jar    alibaba
			//??java?????json?????
			Gson gson = new Gson();
			String json = gson.toJson(acc);
			
			//json?java
			/*Account account = gson.fromJson(json, Account.class);
			System.out.println("json-->java:"+account);*/
			
			
			
			
			//????????
			PrintWriter write = resp.getWriter();
			//????JS??success????
			write.print(method+"("+json+")");
			
			
			
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}


}
