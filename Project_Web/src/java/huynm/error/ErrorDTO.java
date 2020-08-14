/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynm.error;

/**
 *
 * @author ADMIN
 */
public class ErrorDTO {
    
    private String errorUserID ,errorFullName,
            ErrorPassword , ErrorRollID , ErrorRePassword ,ErrorNewPassword; 

    public ErrorDTO() {
    }

    public ErrorDTO(String errorUserID, String errorFullName, String ErrorPassword, String ErrorRollID, String ErrorRePassword) {
        this.errorUserID = errorUserID;
        this.errorFullName = errorFullName;
        this.ErrorPassword = ErrorPassword;
        this.ErrorRollID = ErrorRollID;
        this.ErrorRePassword = ErrorRePassword;
    }

    public ErrorDTO(String ErrorPassword, String ErrorRePassword, String ErrorNewPassword) {
        this.ErrorPassword = ErrorPassword;
        this.ErrorRePassword = ErrorRePassword;
        this.ErrorNewPassword = ErrorNewPassword;
    }

    public ErrorDTO(String errorUserID, String errorFullName, String ErrorPassword, String ErrorRePassword) {
        this.errorUserID = errorUserID;
        this.errorFullName = errorFullName;
        this.ErrorPassword = ErrorPassword;
        this.ErrorRePassword = ErrorRePassword;
    }

    public String getErrorNewPassword() {
        return ErrorNewPassword;
    }

    public void setErrorNewPassword(String ErrorNewPassword) {
        this.ErrorNewPassword = ErrorNewPassword;
    }

    

    
    public String getErrorUserID() {
        return errorUserID;
    }

    public void setErrorUserID(String errorUserID) {
        this.errorUserID = errorUserID;
    }

    public String getErrorFullName() {
        return errorFullName;
    }

    public void setErrorFullName(String errorFullName) {
        this.errorFullName = errorFullName;
    }

    public String getErrorPassword() {
        return ErrorPassword;
    }

    public void setErrorPassword(String ErrorPassword) {
        this.ErrorPassword = ErrorPassword;
    }

    public String getErrorRollID() {
        return ErrorRollID;
    }

    public void setErrorRollID(String ErrorRollID) {
        this.ErrorRollID = ErrorRollID;
    }

    public String getErrorRePassword() {
        return ErrorRePassword;
    }

    public void setErrorRePassword(String ErrorRePassword) {
        this.ErrorRePassword = ErrorRePassword;
    }
    
    
    
}
