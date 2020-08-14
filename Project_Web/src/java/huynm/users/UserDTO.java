/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynm.users;

/**
 *
 * @author ADMIN
 */
public class UserDTO {
    
    private int userID ;
    private String userName , userPassword , fullName ;
    private boolean isActive ;
    private int roleID ;

    public UserDTO() {
    }

    public UserDTO(int userID, String userName, String userPassword, String fullName, boolean isActive, int roleID) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.fullName = fullName;
        this.isActive = isActive;
        this.roleID = roleID;
    }

    public UserDTO(String userName, String userPassword, String fullName) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.fullName = fullName;
    }
    
    

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    public UserDTO(String userName, String userPassword, String fullName, int roleID) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.fullName = fullName;
        this.roleID = roleID;
    }

    
    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the isActive
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * @return the roleID
     */
    public int getRoleID() {
        return roleID;
    }

    /**
     * @param roleID the roleID to set
     */
    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public UserDTO(int userID, String userName, String userPassword, String fullName, int roleID) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.fullName = fullName;
        this.roleID = roleID;
    }
    
    
    
    
    
    
}
