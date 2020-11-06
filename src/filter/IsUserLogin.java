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
import javax.servlet.http.HttpSession;

import dto.UserDTO;

/**
 * Servlet Filter implementation class IsUserLogin
 */
@WebFilter("/*")
public class IsUserLogin implements Filter {

    /**
     * Default constructor. 
     */
    public IsUserLogin() {
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
	    HttpSession session = rq.getSession();
	    String URLLogin = "../SignInUp/SignIn_SignUp.jsp";
	    UserDTO isUserLogin = (UserDTO) session.getAttribute("User");
	    String email = request.getParameter("emailUser") ;
	    session.setMaxInactiveInterval(900);
	    
	    String servletPath = rq.getServletPath();
	   
	   
	    
//	    if(isUserLogin == null && email ==null ) {
//	    	if(servletPath.matches(".*(css|js|jpg|jpeg|png)")) {
//	    		
//				
//	    	}
//	    	RequestDispatcher dp = request.getRequestDispatcher(URLLogin);
//			dp.forward(request, response);
//	    }
//	    else {
//	    	
//	    	chain.doFilter(request, response);
//	    }
	    
	    if(servletPath.matches(".*(css|js|jpg|jpeg|png)") || isUserLogin != null || email!=null ){
	    	chain.doFilter(request, response);
	    }
	    else {
	    	RequestDispatcher dp = request.getRequestDispatcher(URLLogin);
			dp.forward(request, response);
	    }
		// pass the request along the filter chain`		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
