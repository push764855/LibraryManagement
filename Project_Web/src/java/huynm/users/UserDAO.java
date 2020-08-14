/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynm.users;

import huynm.dbutils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class UserDAO {

    public UserDTO checkLogin(String userName, String userPassword) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        UserDTO dto = null;
        try {
            cn = MyConnection.makeConnection();

            if (cn != null) {
                String sql = "select userID,[fullName],[roleID] from Users where [userName] = ? and [userPassword] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, userName);
                pst.setString(2, userPassword);
                rs = pst.executeQuery();
                if (rs.next()) {
                    int userID = rs.getInt("userID");
                    String fullName = rs.getString("fullName");
                    int roleID = rs.getInt("roleID");
                    dto = new UserDTO(userID, userName, "", fullName, roleID);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                rs.close();
            }
            if (cn != null) {
                rs.close();
            }
        }
        return dto;
    }

    public void updatePass(int userID, String password) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                String sql = "update [dbo].[Users] set [userPassword] = ? where  [userID] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(2, userID);
                pst.setString(1, password);
                pst.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }
    
    public boolean checkID(String userID) throws SQLException {
        boolean result = true;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                String sql = "select [fullName] from Users where [userName] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, userID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    result = false;
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return result;
    }
    
    public void createAccount(UserDTO dto) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                String sql = "insert into [dbo].[Users]([userName],[fullName],[userPassword]) values (?,?,?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, dto.getUserName());
                pst.setString(2, dto.getFullName());
                pst.setString(3, dto.getUserPassword());
                pst.executeUpdate();

            }
        } catch (Exception e) {

        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }

}
