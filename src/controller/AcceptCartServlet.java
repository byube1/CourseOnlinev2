package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import dto.ShoppingCartItem;
import dto.UserDTO;
import tool.Tool;

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
		 
		 //neu gio hang trong
		 
		 if(UserCart.isEmpty()) {
			 response.sendRedirect("component/HomePage.jsp");
		 }		 
		 else {
			 AcceptBuy(thisUser, UserCart, request, response);
		 }		 					
		
	}
	
	protected void AcceptBuy(UserDTO thisUser,List<ShoppingCartItem> UserCart,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		String OrderID =Tool.AutoCreateID("OD");
		 float total =0;
		 for (ShoppingCartItem Item : UserCart) {
			total+= Item.getCourse().getCoursePrice();
		}
		 
		 
		 CartDAO handleAccept = new CartDAO();
		 try {
			handleAccept.Order(OrderID,Integer.parseInt(thisUser.getId()),total);
			 for (ShoppingCartItem Item : UserCart) {				 
				 handleAccept.OrderDetail(OrderID, Item.getCourse().getCourseID());
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		session.removeAttribute("cart");		 		
		response.sendRedirect("component/HomePage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
