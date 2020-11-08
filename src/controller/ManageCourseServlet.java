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
import tool.Tool;
import validation.valid;

/**
 * Servlet implementation class ManageCourseServlet
 */
@WebServlet(urlPatterns = {"/ManageCourseServlet", "/ManageCourseServlet/show", "/ManageCourseServlet/detail",
    "/ManageCourseServlet/update", "/ManageCourseServlet/add", "/ManageCourseServlet/delete"})
public class ManageCourseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected ArrayList<CourseDTO> getListCourse() {
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
        CourseDTO course = dataCourse.stream().filter(ac -> ac.getCourseID().equals(ID)).findFirst().orElse(null);
        return course;
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
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
            case "/ManageCourseServlet/update": {
                UpdateCourse(request, response);;
                break;
            }
            case "/ManageCourseServlet/add": {
                AddCourse(request, response);
                break;
            }
            case "/ManageCourseServlet/delete": {
                DeleteCourse(request, response);
                break;
            }
            default:
                break;
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
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

    protected void UpdateCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();

        String ID = request.getParameter("CourseID");
        String Name = request.getParameter("CourseName");
        String Category = request.getParameter("Majors");
        String Desc = request.getParameter("Desc");
        String Img = request.getParameter("IMG");
        double price = Double.parseDouble(request.getParameter("Price"));

        CourseDAO handleUpdate = new CourseDAO();
        if (!valid.checkLengthText(Name, 100)) {
            session.setAttribute("ErrorNameCourse", "Name (Max length: 100) ");
        } else if (!valid.checkLengthText(Desc, 200)) {
            session.setAttribute("ErrorDesCourse", "Description (Max length: 200) ");
        } else if (price <= 0) {
            session.setAttribute("ErrorPriceCourse", "Price > 0");
        } else {
            try {
                handleUpdate.updateCourse(ID, Name, Category, Desc, price, Img);
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }

        response.sendRedirect("detail?IDcourse=" + ID);
    }

    protected void AddCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();

        String IDcourse = Tool.AutoCreateID("CR");
        String CourseName = request.getParameter("CourseName");
        String Category = request.getParameter("Majors");
        String Desc = request.getParameter("desc");
        String IMG = request.getParameter("img");
        double price = Double.parseDouble(request.getParameter("price"));
        String RegisterDate = Tool.getTimeNow();

        CourseDAO handleAdd = new CourseDAO();
        if (price <= 0) {
            session.setAttribute("ErrPrice", "Price >0");
        } else {
            try {
                handleAdd.addCourse(IDcourse, Category, CourseName, RegisterDate, Desc, price, IMG);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        response.sendRedirect("show");
    }

    protected void DeleteCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();

        String ID = request.getParameter("IDcourse");

        CourseDAO handleDelete = new CourseDAO();
        try {
            handleDelete.deleteCourse(ID);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("show");
    }

}
