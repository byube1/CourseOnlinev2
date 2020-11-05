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
        String id = null;
        String email = request.getParameter("emailU");
        String pass = request.getParameter("passU");
        String name = request.getParameter("nameU");
        String img = null;
        String phone = null;
        String resgisterDate = null;
        int type = 1;
        UserDTO user = new UserDTO();
        user.setId(id);
        user.setEmail(email);
        user.setPass(pass);
        user.setName(name);
        user.setImg(img);
        user.setPhone(phone);
        user.setResgisterDate(resgisterDate);
        user.setType(type);
        try {
            dao.insectUser(user);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        RequestDispatcher dis = request.getRequestDispatcher("SignIn_SignUp.jsp");
        dis.forward(request, response);
//        if (valid.checkformatEmail(email)) {
//
//            try {
//                UserDTO u = new UserDTO();
//                int count = new UserDAO().insectUser(u);
//                if (count == 0) {
//                    session.setAttribute("Errors", "sai");
//                    response.sendRedirect("SignIn_SignUp.jsp");
//                } else {
//                    session.setAttribute("Errors", "Đúng");
//                    response.sendRedirect("component/HomePage.jsp");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        } else {
//            session.setAttribute("Errors", "Check your format email");
//            response.sendRedirect("SignIn_SignUp.jsp");
//        }
    }

 

}
