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
public class ErrorBookDTO {

    String errorBookID, errorbookName, errorBookQuantity, errorPublisher, errorAuthor, errorDescrips, errorCate, errorPrice;

    public ErrorBookDTO(String errorBookID, String errorbookName, String errorBookQuantity, String errorPublisher, String errorAuthor, String errorDescrips, String errorCate, String errorPrice) {
        this.errorBookID = errorBookID;
        this.errorbookName = errorbookName;
        this.errorBookQuantity = errorBookQuantity;
        this.errorPublisher = errorPublisher;
        this.errorAuthor = errorAuthor;
        this.errorDescrips = errorDescrips;
        this.errorCate = errorCate;
        this.errorPrice = errorPrice;
    }

    public ErrorBookDTO(String errorbookName, String errorBookQuantity, String errorDescrips, String errorPrice) {
        this.errorbookName = errorbookName;
        this.errorBookQuantity = errorBookQuantity;
        this.errorDescrips = errorDescrips;
        this.errorPrice = errorPrice;
    }
    
    

    public ErrorBookDTO(String errorBookQuantity, String errorPrice) {
        this.errorBookQuantity = errorBookQuantity;
        this.errorPrice = errorPrice;
    }

    public String getErrorBookID() {
        return errorBookID;
    }

    public void setErrorBookID(String errorBookID) {
        this.errorBookID = errorBookID;
    }

    public String getErrorbookName() {
        return errorbookName;
    }

    public void setErrorbookName(String errorbookName) {
        this.errorbookName = errorbookName;
    }

    public String getErrorBookQuantity() {
        return errorBookQuantity;
    }

    public void setErrorBookQuantity(String errorBookQuantity) {
        this.errorBookQuantity = errorBookQuantity;
    }

    public String getErrorPublisher() {
        return errorPublisher;
    }

    public void setErrorPublisher(String errorPublisher) {
        this.errorPublisher = errorPublisher;
    }

    public String getErrorAuthor() {
        return errorAuthor;
    }

    public void setErrorAuthor(String errorAuthor) {
        this.errorAuthor = errorAuthor;
    }

    public String getErrorDescrips() {
        return errorDescrips;
    }

    public void setErrorDescrips(String errorDescrips) {
        this.errorDescrips = errorDescrips;
    }

    public String getErrorCate() {
        return errorCate;
    }

    public void setErrorCate(String errorCate) {
        this.errorCate = errorCate;
    }

    public String getErrorPrice() {
        return errorPrice;
    }

    public void setErrorPrice(String errorPrice) {
        this.errorPrice = errorPrice;
    }
    
    

}
