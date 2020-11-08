package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.myConnection;

public class CartDAO {
	
	public int Order(String OrderID, int UserID, float total) throws SQLException {
        Connection cn = myConnection.makeConnection();
        int result = 0;
        if (cn != null) {
            String sql = "INSERT INTO dbo.[Order] ( idOrder, userID, dateOrder, totals ) VALUES  ( ?, ?,  GETDATE(), ? )";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, OrderID);
            pst.setInt(2, UserID);
            pst.setDouble(3, total);        
            result = pst.executeUpdate();
            cn.close();
        }
        return result;
    }
	
	public int OrderDetail(String OrderID, String CourseID) throws SQLException {
        Connection cn = myConnection.makeConnection();
        int result = 0;
        if (cn != null) {
            String sql = "INSERT INTO dbo.OrderDetail ( idOrder, courseID ) VALUES ( ?, ?  )";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, OrderID);
            pst.setString(2, CourseID);         
            result = pst.executeUpdate();
            cn.close();
        }
        return result;
    }

}
