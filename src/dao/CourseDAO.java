/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.myConnection;
import dto.CourseDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author WIN 10
 */
public class CourseDAO {

    private List<CourseDTO> course;

    public CourseDAO() {
        try {
            this.course = getAllCourses();
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }

    public List<CourseDTO> findAll() {
        return this.course;
    }

    public CourseDTO find(String id) {
        for (CourseDTO cour : this.course) {
            if (cour.getCourseID().equalsIgnoreCase(id)) {
                return cour;
            }
        }
        return null;
    }

    public ArrayList<CourseDTO> getAllCourses() throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM [AssignmentJavaWeb].[dbo].[Course]";

        ArrayList<CourseDTO> lst = new ArrayList<>();

        try {
            con = myConnection.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    String id = rs.getString("courseID");
                    String idCate = rs.getString("CategoryID");
                    String name = rs.getString("courseName");
                    String time = rs.getString("courseTime");
                    String certificate = rs.getString("certificate");
                    String Description = rs.getString("courseDescription");
                    double price = rs.getDouble("coursePrice");
                    int num = rs.getInt("numberOfStudent");
                    String imgURL = rs.getString("img");

                    CourseDTO p = new CourseDTO(id, idCate, name, time, certificate, Description, price, num, imgURL);
                    lst.add(p);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return lst;
    }

    public int updateCourse(String courseID, String courseName, String CategoryID, String courseDescription, double coursePrice, String img) throws SQLException {
        Connection cn = myConnection.makeConnection();
        int result = 0;
        if (cn != null) {
            String sql = "UPDATE dbo.Course SET courseName = ?, CategoryID = ?, courseDescription = ?, coursePrice = ?, img = ? WHERE courseID = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(6, courseID);
            pst.setString(1, courseName);
            pst.setString(2, CategoryID);
            pst.setString(3, courseDescription);
            pst.setDouble(4, coursePrice);
            pst.setString(5, img);
            result = pst.executeUpdate();
            pst.close();
            cn.close();
        }
        return result;
    }

    public int addCourse(String courseID, String CategoryID, String courseName, String courseTime, String desc, double coursePrice, String img) throws SQLException {
        Connection cn = myConnection.makeConnection();
        int result = 0;
        if (cn != null) {
            String sql = "INSERT INTO dbo.Course( courseID ,CategoryID ,courseName ,courseTime ,courseDescription ,coursePrice ,img) VALUES ( ?,?,?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, courseID);
            pst.setString(2, CategoryID);
            pst.setString(3, courseName);
            pst.setString(4, courseTime);
            pst.setString(5, desc);
            pst.setDouble(6, coursePrice);
            pst.setString(7, img);
            result = pst.executeUpdate();
            cn.close();
        }
        return result;
    }

    public int deleteCourse(String Code) throws SQLException {
        Connection cn = myConnection.makeConnection();
        int result = 0;
        if (cn != null) {
            String sql = "DELETE dbo.Course WHERE courseID = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, Code);
            result = pst.executeUpdate();
            cn.close();
        }
        cn.close();
        return result;
    }
}
