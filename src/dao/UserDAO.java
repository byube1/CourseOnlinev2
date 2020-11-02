package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.myConnection;
import dto.UserDTO;

public class UserDAO {

    public UserDTO Login(String User, String pass) throws SQLException {
        UserDTO thisUser = new UserDTO();
        Connection cn = myConnection.makeConnection();
        if (cn != null) {
            String sql = "SELECT [userID]\n"
                    + "      ,[email]\n"
                    + "      ,[pass]\n"
                    + "      ,[name]\n"
                    + "      ,[type]\n"
                    + "      ,[status]\n"
                    + "      ,[imgUrl]\n"
                    + "      ,[phone]\n"
                    + "      ,[registerDate]\n"
                    + "  FROM [AssignmentJavaWeb].[dbo].[UserInformation] WHERE email = ? AND pass=?";
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

    public static ArrayList<UserDTO> GetAllUser() throws SQLException {
        ArrayList<UserDTO> listUser = new ArrayList<UserDTO>();
        Connection cn = myConnection.makeConnection();
        if (cn != null) {
            String sql = "SELECT [userID]\n"
                    + "      ,[email]\n"
                    + "      ,[pass]\n"
                    + "      ,[name]\n"
                    + "      ,[type]\n"
                    + "      ,[status]\n"
                    + "      ,[imgUrl]\n"
                    + "      ,[phone]\n"
                    + "      ,[registerDate]\n"
                    + "  FROM [AssignmentJavaWeb].[dbo].[UserInformation]";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                UserDTO thisUser = new UserDTO();
                thisUser.setId(rs.getString("userID"));
                thisUser.setEmail(rs.getString("email"));
                thisUser.setPass(rs.getString("pass"));
                thisUser.setName(rs.getString("name"));
                thisUser.setType(rs.getInt("type"));
                thisUser.setImg(rs.getString("imgUrl"));
                thisUser.setPhone(rs.getString("phone"));
                thisUser.setResgisterDate(rs.getString("registerDate"));
                listUser.add(thisUser);
            }
            rs.close();
            cn.close();
        }
        return listUser;
    }

    public int updateUser(String id, String name, String pass, String phone, int type, String img) throws SQLException {
        Connection cn = myConnection.makeConnection();
        int result = 0;
        if (cn != null) {
            String sql = "UPDATE dbo.UserInformation SET name = ?,pass =?,type =?,imgUrl=?,phone=? WHERE userID = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, pass);
            pst.setInt(3, type);
            pst.setString(4, img);
            pst.setString(5, phone);
            pst.setString(6, id);
            result = pst.executeUpdate();
            cn.close();
        }
        return result;
    }

//	public static void main(String[] args) {
//		try {
//			ArrayList<UserDTO> listUser = GetAllUser();
//			for (UserDTO userDTO : listUser) {
//				System.out.println(userDTO);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
