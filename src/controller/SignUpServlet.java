/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import dto.UserDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import validation.valid;

/**
 *
 * @author WIN 10
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {

    private UserDAO dao = new UserDAO();

    public SignUpServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("emailUser");
        String pass = request.getParameter("passUser");
        String name = request.getParameter("nameUser");
        
        if(valid.checkformatEmail(email)) {
        	 UserDAO handleSignUp = new UserDAO();        
             try {
     			handleSignUp.SignIn(email, pass, name);
     			session.setAttribute("SignUp", "SignUp successfully");
     		} catch (SQLException e) {
     			// TODO Auto-generated catch block
     			session.setAttribute("Error", "Duplicate email");
     			response.sendRedirect("SignInUp/SignUp_SignIn.jsp");
     			e.printStackTrace();
     		}       
             response.sendRedirect("SignInUp/SignIn_SignUp.jsp");
        }
        else {
        	session.setAttribute("Error", "Check your format email");
            response.sendRedirect("SignInUp/SignUp_SignIn.jsp");
        }
        
       
    }

 

}
