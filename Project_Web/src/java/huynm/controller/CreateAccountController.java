/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynm.controller;

import huynm.error.ErrorDTO;
import huynm.users.UserDAO;
import huynm.users.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class CreateAccountController extends HttpServlet {
    private static final String SUCCESS = "login.html";
    private static final String ERROR = "createaccount.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            ErrorDTO error = new ErrorDTO("","","","");
            boolean check = true;
            String userName = request.getParameter("txtUserName");
            String fullName = request.getParameter("txtFullName");
            String password = request.getParameter("txtPassword");
            String rePassword = request.getParameter("txtRePassword");
            
            if (userName.length() < 1) {
                error.setErrorUserID("UserName must be inputted");
                check = false;
            }
            if (fullName.length() < 1 ) {
                error.setErrorFullName("Fullname must be inputted");
                check = false;
            }
            if (password.length() < 1) {
                error.setErrorPassword("Password must be inputted");
                check = false;
            }
            if (!password.equals(rePassword) ) {
                error.setErrorRePassword("Repassword is not correct");
                check = false;
            }
            
            UserDAO dao = new UserDAO();
            boolean exist = dao.checkID(userName);
            if (exist == false) {
                error.setErrorUserID("UserID is dupplicated !");
                check = false;
            }
            if (check) {
                UserDTO dto = new UserDTO(userName, password, fullName);
                dao.createAccount(dto);
                url = SUCCESS;
            }else {
                request.setAttribute("ERROR_USER", error);
            }
            
        } catch (Exception e) {
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
