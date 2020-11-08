package controller;

import dao.CategoryDAO;
import dao.CourseDAO;
import dao.DashboardDAO;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dto.DashboardDTO;
import dto.UserDTO;

import javax.naming.NamingException;
import validation.valid;

@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
            Login(email, pass, request, response);
        } else {
            session.setAttribute("Error", "Check your format email");
            response.sendRedirect("SignInUp/SignIn_SignUp.jsp");
        }

    }

    protected void Login(String email, String pass, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO handleLogin = new UserDAO();
        try {
            UserDTO user = handleLogin.Login(email, pass);
            if (user.getName() == null) {
                session.setAttribute("Error", "Invalid login or password. Please try again.");
                response.sendRedirect("SignInUp/SignIn_SignUp.jsp");
            } else {
                if(user.getType()==1) {
                	AdLogin(email, pass, session, user, response);
                }
                else {
                	UserLogin(email, pass, session, user, response);
                }
                session.removeAttribute("Error");
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
    
    protected void UserLogin(String email, String pass, HttpSession session,UserDTO user, HttpServletResponse response) throws IOException, NamingException, SQLException {
    	 session.setAttribute("User", user);
         CategoryDAO cate = new CategoryDAO();
         session.setAttribute("cloneCATE", cate.GetAllCates());
         CourseDAO course = new CourseDAO();
//         ****
         session.setAttribute("cloneCOURSE", course.getAllCourses(Integer.parseInt(user.getId())));
         session.setAttribute("CourseOfUser", course.getCourseofUser((Integer.parseInt(user.getId()))));
         response.sendRedirect("component/HomePage.jsp");
    }   
    protected void AdLogin(String email, String pass, HttpSession session,UserDTO user, HttpServletResponse response) throws IOException, NamingException, SQLException {   	                                                           	
         session.setAttribute("User", user);
         DashboardDTO dashboard = DashboardDAO.GetInfomationWeb();
         session.setAttribute("Dashboard", dashboard);        
         response.sendRedirect("DashboardServlet");                     
   }
    
    
    

}
