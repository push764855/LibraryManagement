/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynm.controller;

import huynm.error.ErrorDTO;
import huynm.users.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class ChangePasswordController extends HttpServlet {

    private static final String SUCCESS = "SearchController";
    private static final String ERROR = "changepassword.jsp";

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
            ErrorDTO error = new ErrorDTO("", "", "");
            boolean check = true;
            String oldPass = request.getParameter("txtOldPassword");
            String newPass = request.getParameter("txtNewPassword");
            String repass = request.getParameter("txtRePassword");
            HttpSession session = request.getSession();
            String oldCheck = (String) session.getAttribute("PASSWORD");
            int userID = (int) session.getAttribute("USER_ID");

            if (!oldPass.equals(oldCheck)) {
                error.setErrorPassword("Your Password is not correct");
                check = false;

            }
            if (newPass.length() < 1) {
                error.setErrorNewPassword("New Password must be inputted");
                check = false;
            }
            if (!newPass.equals(repass)) {
                error.setErrorRePassword("Repassword is not correct");
                check = false;
            }
            if (!oldPass.equals(oldCheck)) {
                error.setErrorRePassword("Your Password is not correct");
                check = false;
            }
            if (check) {
                UserDAO dao = new UserDAO();
                dao.updatePass(userID, newPass);
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR_USER", error);
            }
        } catch (Exception e) {
        } finally {
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
