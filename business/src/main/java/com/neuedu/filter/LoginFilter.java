package com.neuedu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Account;
import com.neuedu.service.LoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/login.jsp")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest _req = (HttpServletRequest)request;
		HttpServletResponse _resp = (HttpServletResponse)response;
		String username = null;
		String password = null;
		
		Cookie[] cookies = _req.getCookies();
		if(cookies != null) {
			for(Cookie coo:cookies) {
				if(coo.getName().equals("username")) {
					username = coo.getValue();
				}
				if(coo.getName().equals("password")) {
					password = coo.getValue();
				}
			}
		}
				
		if(username != null&&password != null &&!username.equals("")&&!password.equals("")) {
			LoginService ls = new LoginServiceImpl();
			Account acc = ls.LoginLogic(username, password);
			if(acc != null) {
				//��¼�ɹ�
				//����token����ŵ����ݿ���
				long time = System.currentTimeMillis();
				String token = MD5Utils.GetMD5Code(username+password+time);
				ls.addToken(token,acc);
				//token�ŵ��Ự����
				HttpSession session = _req.getSession();
				session.setAttribute("token",token);
				session.setAttribute("acc", acc);
				_req.getRequestDispatcher("view/home.jsp").forward(_req, _resp);
				
			}else {
				//��¼ʧ��
				chain.doFilter(request, response);
			}
		}else {
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
