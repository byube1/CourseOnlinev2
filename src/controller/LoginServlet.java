package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dto.UserDTO;
import validation.valid;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        if (valid.checkformatEmail(email)) {
            UserLogin(email, pass, request, response);
        } else {
            session.setAttribute("Error", "Check your format email");
			response.sendRedirect("ProjectADpage/Login.jsp");
        }

    }

    protected void UserLogin(String email, String pass, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO handleLogin = new UserDAO();
        try {
            UserDTO user = handleLogin.Login(email, pass);
            if (user.getName() == null || user.getType() != 1) {
                session.setAttribute("Error", "Invalid login or password. Please try again.");
				response.sendRedirect("ProjectADpage/Login.jsp");	             
            } else {
                session.setAttribute("User", user);
                response.sendRedirect("ProjectADpage/index.jsp");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
