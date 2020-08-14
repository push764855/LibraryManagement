/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynm.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class MyConnection {
    
    public static Connection makeConnection() throws ClassNotFoundException, SQLException{
        Connection cn = null ; 
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=LibraryManagement";
        cn = DriverManager.getConnection(url, "sa", "123456");
        return cn ;
    }
    
}
