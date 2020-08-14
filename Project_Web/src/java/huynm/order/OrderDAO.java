/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynm.order;

import huynm.dbutils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ADMIN
 */
public class OrderDAO {

    public int createANewOrder(OrderDTO dto) throws SQLException {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        int primaryKey = -1;
        
        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                String sql = "insert into Orders (userID,orderDate,returnDate) values (?,?,?)";
                pst = cn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                pst.setInt(1, dto.getUserID());
                pst.setString(2, dto.getOrderDate());
                pst.setString(3, dto.getReturnDate());
                int result = pst.executeUpdate();
                if(result > 0) {
                    rs = pst.getGeneratedKeys();
                    if(rs.next()) {
                        primaryKey = rs.getInt(1);
                    }
                }
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
        return primaryKey;
    }


}
