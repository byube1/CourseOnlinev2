package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.myConnection;
import dto.DashboardDTO;

public class DashboardDAO {
	
	public static DashboardDTO GetInfomationWeb() throws SQLException {
        Connection cn = myConnection.makeConnection();
        DashboardDTO dashboard = null;
        if (cn != null) {
            String sql = "  SELECT TOP 1\r\n" + 
            		"         (SELECT COUNT(*) FROM dbo.UserInformation) AS numUser ,\r\n" + 
            		"         (SELECT COUNT(*)  FROM dbo.Course) AS numCourse,\r\n" + 
            		"		 (SELECT COUNT(*)  FROM dbo.[Order]) AS numOrder,\r\n" + 
            		"		 (SELECT SUM(totals)FROM dbo.[Order])  AS total  \r\n" + 
            		"		 FROM dbo.Course,dbo.UserInformation,dbo.[Order]";            
            PreparedStatement pst = cn.prepareStatement(sql);          
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {          	
            	 dashboard = new DashboardDTO( rs.getInt("numUser"), rs.getInt("numCourse"), rs.getInt("numOrder"), rs.getInt("total"));
            }
            rs.close();
            cn.close();
        }       
		return dashboard;
    }		
}
