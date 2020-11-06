package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.myConnection;

public class DashboardDAO {
	
	public static int GetNumCourse() throws SQLException {
       int numOfCourse =0;
        Connection cn = myConnection.makeConnection();
        if (cn != null) {
            String sql = "SELECT COUNT(courseID) AS numCourse FROM dbo.Course";            
            PreparedStatement pst = cn.prepareStatement(sql);          
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
            	numOfCourse = rs.getInt("numCourse");
            }
            rs.close();
            cn.close();
        }
        return numOfCourse;
    }
		

}
