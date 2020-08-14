/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynm.orderdetail;

/**
 *
 * @author ADMIN
 */
public class OderDetailDTO {

    int orderDetailID;
    String bookID;
    int amount;
    int orderID;

    public OderDetailDTO() {
    }

    public OderDetailDTO(int orderDetailID, String bookID, int amount, int orderID) {
        this.orderDetailID = orderDetailID;
        this.bookID = bookID;
        this.amount = amount;
        this.orderID = orderID;
    }

    public OderDetailDTO(String bookID, int amount, int orderID) {
        this.bookID = bookID;
        this.amount = amount;
        this.orderID = orderID;
    }

    public OderDetailDTO(String bookID, int amount) {
        this.bookID = bookID;
        this.amount = amount;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

}
