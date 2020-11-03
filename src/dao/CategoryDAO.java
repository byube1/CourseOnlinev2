/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.myConnection;
import dto.CategoryDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author WIN 10
 */
public class CategoryDAO {

    public ArrayList<CategoryDTO> GetAllCates() throws SQLException {
        ArrayList<CategoryDTO> list = new ArrayList<>();
        Connection cn = myConnection.makeConnection();
        if (cn != null) {
            String sql = "SELECT [CategoryID]\n"
                    + "      ,[CategoryName]\n"
                    + "  FROM [AssignmentJavaWeb].[dbo].[Categories]";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                CategoryDTO thisC = new CategoryDTO();
                thisC.setCategoryID(rs.getString("CategoryID"));
                thisC.setCategoryName(rs.getString("CategoryName"));

                list.add(thisC);
            }
            rs.close();
            cn.close();
        }
        return list;
    }
}
