package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Account;
import service.LoginService;
import service.impl.LoginServiceImpl;

/**
 * Servlet Filter implementation class CheckLoginFilter
 */
@WebFilter("/view/*")
public class CheckLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CheckLoginFilter() {
        // TODO Auto-generated constructor stub
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
		
		HttpServletRequest _request = (HttpServletRequest)request;
		HttpServletResponse _response = (HttpServletResponse)response;
		
		HttpSession session = _request.getSession();
		Object o = session.getAttribute("token");
		Object acco = session.getAttribute("acc");
		if(o != null&& acco != null) {
			String token = (String)o;
			
			LoginService ls = new LoginServiceImpl();
			Account acc = (Account)acco;
			String result_token = ls.findTokenByid(acc.getId());
			if(result_token!=null) {
				if(token.equals(result_token)) {
					//��Ч��token
					chain.doFilter(_request, _response);
					return;
				}
			}
		}
		
		//�ض���
		_response.sendRedirect("http://localhost:8080/ShoppingProject_web/login.jsp");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
