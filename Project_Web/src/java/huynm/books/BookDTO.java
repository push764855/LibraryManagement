/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynm.books;

/**
 *
 * @author ADMIN
 */
public class BookDTO {

    private String bookID, bookName;
    private int quantity;
    private String publisher, author, bookDescription;
    private int category;
    private float prices;
    private boolean showCart;

    public BookDTO() {
    }

    public BookDTO(String bookID, String bookName, int quantity, String publisher, String author, String bookDescription, int category, float prices, boolean showCart) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.quantity = quantity;
        this.publisher = publisher;
        this.author = author;
        this.bookDescription = bookDescription;
        this.category = category;
        this.prices = prices;
        this.showCart = showCart;
    }

    public boolean isShowCart() {
        return showCart;
    }

    public void setShowCart(boolean showCart) {
        this.showCart = showCart;
    }

    public float getPrices() {
        return prices;
    }

    public void setPrices(float prices) {
        this.prices = prices;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public BookDTO(String bookID, String bookName, int quantity, String bookDescription, float prices, boolean showCart) {
        this.bookName = bookName;
        this.quantity = quantity;
        this.bookDescription = bookDescription;
        this.prices = prices;
        this.showCart = showCart;
        this.bookID = bookID;
    }

    public BookDTO(String bookID, String bookName, int quantity) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.quantity = quantity;
    }
    
    

}
