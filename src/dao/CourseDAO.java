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
                    String Writer = rs.getString("courseWriter");
                    String Publising = rs.getString("coursePublising");
                    String Rating = rs.getString("courseRating");
                    String requiment = rs.getString("requiment");
                    String Content = rs.getString("courseContent");
                    String time = rs.getString("courseTime");
                    String certificate = rs.getString("certificate");
                    String Description = rs.getString("courseDescription");

                    double price = rs.getDouble("coursePrice");
                    int num = rs.getInt("numberOfStudent");
                    String imgURL = rs.getString("img");

                    CourseDTO p = new CourseDTO(id, idCate, name, Writer, Publising, Rating,
                             requiment, Content, time, certificate, Description, price, num, imgURL);
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
}
