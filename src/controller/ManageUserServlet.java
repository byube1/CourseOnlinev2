package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dto.UserDTO;

/**
 * Servlet implementation class ManageUserServlet
 */
@WebServlet(urlPatterns = {"/ManageUserServlet", "/ManageUserServlet/show", "/ManageUserServlet/detail", "/ManageUserServlet/update"})
public class ManageUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected ArrayList<UserDTO> getlistUser() {
        ArrayList<UserDTO> listUser = null;
        try {
            listUser = UserDAO.GetAllUser();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listUser;
    }

    protected UserDTO findUserbyID(String ID, ArrayList<UserDTO> dataUser) {
        UserDTO thisUser = dataUser.stream().filter(ac -> ac.getId().equals(ID)).findFirst().orElse(null);
        return thisUser;
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String action = request.getServletPath();
        switch (action) {
            case "/ManageUserServlet/show": {
                ShowlistUser(request, response);
                break;
            }
            case "/ManageUserServlet/detail": {
                ShowDetailUser(request, response);
                break;
            }
            case "/ManageUserServlet/update": {
                Update(request, response);
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
        doGet(request, response);
    }

    protected void ShowlistUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        ArrayList<UserDTO> listUser = getlistUser();
        session.setAttribute("ListUser", listUser);
        response.sendRedirect("../ProjectADpage/userTB.jsp");
    }

    protected void ShowDetailUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        String ID = request.getParameter("ID");
        ArrayList<UserDTO> listUser = getlistUser();
        UserDTO detailUser = findUserbyID(ID, listUser);
        session.setAttribute("DetailUser", detailUser);
        response.sendRedirect("../ProjectADpage/userform.jsp");
    }

    protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String phone = request.getParameter("phone");
        String img = request.getParameter("img");
        int type = Integer.parseInt(request.getParameter("type"));

        HttpSession session = request.getSession();
        UserDAO handleUpdate = new UserDAO();
        try {
            handleUpdate.updateUser(id, name, pass, phone, type, img);
            session.setAttribute("Report", "Successfully");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            session.setAttribute("Report", "Cannot update, try again!!");
            e.printStackTrace();
        }
        response.sendRedirect("detail?ID=" + id);
    }

}
