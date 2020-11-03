package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CourseDAO;
import dto.CourseDTO;

/**
 * Servlet implementation class ManageCourseServlet
 */
@WebServlet(urlPatterns = {"/ManageCourseServlet","/ManageCourseServlet/show","/ManageCourseServlet/detail"})
public class ManageCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected ArrayList<CourseDTO> getListCourse(){
    	CourseDAO showlist = new CourseDAO();
    	ArrayList<CourseDTO> listCourse = null;
    	try {
			 listCourse = showlist.getAllCourses();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return listCourse;
    }
    
    protected CourseDTO findCourseByID(String ID, ArrayList<CourseDTO> dataCourse) {
    	CourseDTO course = dataCourse.stream().filter(ac->ac.getCourseID().equals(ID)).findFirst().orElse(null);
    	return course;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String action = request.getServletPath();
	        switch (action) {
	            case "/ManageCourseServlet/show": {
	                ShowListCourse(request, response);
	                break;
	            }
	            case "/ManageCourseServlet/detail": {
	            	ShowDetailCourse(request, response);	              
	                break;
	            }
	            case "/ManageUserServlet/update": {
	              
	                break;
	            }
	            case "/ManageUserServlet/delete":{
	            	
	            }           
	            default:
	                break;
	        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	protected void ShowListCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession();
		 ArrayList<CourseDTO> listCourse = getListCourse();
		 session.setAttribute("listCourse", listCourse);		
		 response.sendRedirect("../ProjectADpage/courseTB.jsp");		
	}
	
	protected void ShowDetailCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession();
		 String ID = request.getParameter("IDcourse");
		 ArrayList<CourseDTO> listCourse = getListCourse();
		 CourseDTO thisCourse = findCourseByID(ID, listCourse);
		 session.setAttribute("CourseDetail", thisCourse);		 		 
		 response.sendRedirect("../ProjectADpage/courseform.jsp");		
	}

}
