package controller;

import dao.CategoryDAO;
import dao.CourseDAO;
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

import javax.naming.NamingException;
import validation.valid;

@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {

    public SignInServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("emailUser");
        String pass = request.getParameter("passUser");
        if (valid.checkformatEmail(email)) {
            UserLogin(email, pass, request, response);
        } else {
            session.setAttribute("Error", "Check your format email");
            response.sendRedirect("SignIn_SignUp.jsp");
        }

    }

    protected void UserLogin(String email, String pass, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO handleLogin = new UserDAO();
        try {
            UserDTO user = handleLogin.Login(email, pass);
            if (user.getName() == null || user.getType() != 1) {
                session.setAttribute("Error", "Invalid login or password. Please try again.");
                response.sendRedirect("SignIn_SignUp.jsp");
            } else {
                session.setAttribute("User", user);
                CategoryDAO cate = new CategoryDAO();
                session.setAttribute("cloneCATE", cate.GetAllCates());
                CourseDAO course = new CourseDAO();
                session.setAttribute("cloneCOURSE", course.getAllCourses());
                response.sendRedirect("component/HomePage.jsp");
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }

}
