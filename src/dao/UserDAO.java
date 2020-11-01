package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.myConnection;
import dto.UserDTO;

public class UserDAO {
	public  UserDTO Login(String User, String pass) throws SQLException {
		UserDTO thisUser = new UserDTO();
		Connection cn = myConnection.makeConnection();
		if (cn != null) {
			String sql = "SELECT userID,email,pass,name,type,imgUrl,phone,registerDate FROM dbo.UserInformation WHERE email = ? AND pass=?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, User);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				thisUser.setId(rs.getString("userID"));
				thisUser.setEmail(rs.getString("email"));
				thisUser.setPass(rs.getString("pass"));
				thisUser.setName(rs.getString("name"));
				thisUser.setType(rs.getInt("type"));
				thisUser.setImg(rs.getString("imgUrl"));
				thisUser.setPhone(rs.getString("phone"));
				thisUser.setResgisterDate(rs.getString("registerDate"));
				
			}
			rs.close();
			cn.close();
			
		}
		return thisUser;
	}
	
//	public static void main(String[] args) {
//		try {
//			UserDTO thisUser = Login("hoang1@gmail.com", "200");
//			System.out.println(thisUser);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
