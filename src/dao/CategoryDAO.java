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
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author WIN 10
 */
public class CategoryDAO {

    private List<CategoryDTO> cate;

    public CategoryDAO() {
        try {
            this.cate = GetAllCates();
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }

    public List<CategoryDTO> findAllCate() {
        return this.cate;
    }

    public CategoryDTO find(String id) {
        for (CategoryDTO cour : this.cate) {
            if (cour.getCategoryID().equalsIgnoreCase(id)) {
                return cour;
            }
        }
        return null;
    }

    public ArrayList<CategoryDTO> GetAllCates() throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM [AssignmentJavaWeb].[dbo].[Categories]";

        ArrayList<CategoryDTO> lst = new ArrayList<>();

        try {
            con = myConnection.makeConnection();
            if (con != null) {
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    String idCate = rs.getString("categoryID");
                    String name = rs.getString("categoryName");

                    CategoryDTO p = new CategoryDTO(idCate, name);
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
