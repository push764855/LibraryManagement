/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynm.order;

/**
 *
 * @author ADMIN
 */
public class OrderDTO {
    int orderID, userID ;
    String orderDate;
    String returnDate;

    public OrderDTO() {
    }

    public OrderDTO(int orderID, int userID, String orderDate, String returnDate) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDate = orderDate;
        this.returnDate = returnDate;
    }

    public OrderDTO(int userID, String orderDate, String returnDate) {
        this.userID = userID;
        this.orderDate = orderDate;
        this.returnDate = returnDate;
    }
    
    

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

   

   
    
    
    
}
