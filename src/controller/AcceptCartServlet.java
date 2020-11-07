package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ShoppingCartItem;
import dto.UserDTO;

/**
 * Servlet implementation class AccpetCartServlet
 */
@WebServlet("/AcceptCartServlet")
public class AcceptCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 HttpSession session = request.getSession();
		 List<ShoppingCartItem> UserCart = (List<ShoppingCartItem>) session.getAttribute("cart");
		 UserDTO thisUser = (UserDTO) session.getAttribute("User");
		 
		 System.out.println(thisUser.getName());
		for (ShoppingCartItem shoppingCartItem : UserCart) {
			System.out.println(shoppingCartItem.getCourse().getCourseName());
			
		}
		
		response.sendRedirect("component/HomePage.jsp");
		 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
