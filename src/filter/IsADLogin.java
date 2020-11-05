package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserDTO;

/**
 * Servlet Filter implementation class isLoginRole
 */
@WebFilter("/ProjectADpage/*")
public class IsADLogin implements Filter {

    /**
     * Default constructor. 
     */
    public IsADLogin() {
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
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse rp = (HttpServletResponse) response;
		HttpSession session =  rq.getSession();
		
		String email = request.getParameter("email") ;
		String pass = request.getParameter("pass");
		UserDTO isUserLogin = (UserDTO) session.getAttribute("User") ;
		session.setMaxInactiveInterval(900);		
		if(email==null && pass==null && isUserLogin==null ) {
			RequestDispatcher dp = request.getRequestDispatcher("Login.jsp");
			dp.forward(request, response);
		}
		else {
			// pass the request along the filter chain	
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
