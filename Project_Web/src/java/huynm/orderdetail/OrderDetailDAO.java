/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynm.orderdetail;

import huynm.dbutils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class OrderDetailDAO {

    public List<OderDetailDTO> getListOfOrderDetail() throws SQLException {
        List<OderDetailDTO> list = new ArrayList<>();

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                String sql = "select [orderDetailID],[bookID],[amount],[ordearID] from orderDetail";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int orderDetailID = rs.getInt("orderDetailID");
                    String bookID = rs.getString("bookID");
                    int amount = rs.getInt("amount");
                    int orderID = rs.getInt("orderID");

                    list.add(new OderDetailDTO(orderDetailID, bookID, amount, orderID));
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
        return list;
    }

    public void createANewOrder(String bookID, int mount, int orderID) throws SQLException {

        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                String sql = "insert into orderDetail values (?,?,?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, bookID);
                pst.setInt(2, mount);
                pst.setInt(3, orderID);
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

    public List<OderDetailDTO> getListOrderByUserID(String userID) throws SQLException {
        List<OderDetailDTO> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                String sql = "select bookID, amount, i.orderID as orderID from Orders as o inner join orderDetail as i on o.orderID = i.orderID "
                        + "where o.userID = ? and status = 1 ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, userID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    int amount = rs.getInt("amount");                    
                    int orderID = rs.getInt("orderID");
                    list.add(new OderDetailDTO(bookID, amount,orderID));
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
        return list;
    }

    public List<OderDetailDTO> FindByBookID(String userID, String bookIDs) throws SQLException {
        List<OderDetailDTO> list = new ArrayList<>();

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                String sql = "select bookID, amount, i.orderID as orderID from Orders as o inner join orderDetail as i on o.orderID = i.orderID "
                        + "where o.userID = ? and status = 1 and bookID like ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, userID);
                pst.setString(2, "%" + bookIDs + "%");
                rs = pst.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    int amount = rs.getInt("amount");
                    int orderID = rs.getInt("orderID");
                    list.add(new OderDetailDTO(bookID, amount,orderID));
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
        return list;
    }
    
    public void updateStatus(String bookID,int orderID) throws SQLException {

        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                String sql = "update orderDetail set status = 0 where bookID = ? and orderID = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, bookID);
                pst.setInt(2, orderID);
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
