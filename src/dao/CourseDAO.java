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

public class CourseDAO {
    public ArrayList<CourseDTO> getAllCourses() throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT courseID,Course.CategoryID,CategoryName,courseName,courseTime,certificate,"
        		    + "courseDescription,coursePrice,numberOfStudent,img FROM dbo.Course JOIN dbo.Categories"
        		    + " ON Categories.CategoryID = Course.CategoryID";
        ArrayList<CourseDTO> lst = new ArrayList<>();
        try {
            con = myConnection.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    String id = rs.getString("courseID");
                    String idCate = rs.getString("CategoryID");
                    String nameCate = rs.getString("CategoryName");
                    String name = rs.getString("courseName");
                    String time = rs.getString("courseTime");
                    String certificate = rs.getString("certificate");
                    String Description = rs.getString("courseDescription");
                    double price = rs.getDouble("coursePrice");
                    int num = rs.getInt("numberOfStudent");
                    String imgURL = rs.getString("img");
                    CourseDTO p = new CourseDTO(id, idCate,nameCate ,name, time, certificate, Description, price, num, imgURL);
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
