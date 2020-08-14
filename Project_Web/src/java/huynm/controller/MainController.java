/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "invalid.html";
    private static final String LOG_IN = "LoginController";
    private static final String LOG_OUT = "LogoutController";
    private static final String SEARCH = "SearchController";
    private static final String ADD_TO_CART = "AddToCartController";
    private static final String VIEW_CART = "viewCart.jsp";
    private static final String FINISH = "FinishController";
    private static final String CHANGE = "ChangePasswordController";
    private static final String CHANGE_PASSWORD = "changepassword.jsp";
    private static final String DECREASE_CART = "DecreaseCartController";
    private static final String INCREASE_CART = "IncreaseCartController";
    private static final String DELETE_ITEM = "DeleteCartController";
    private static final String CREATE_USER = "CreateAccountController";
    private static final String DELETE_BOOK = "DeleteBookController";
    private static final String UPDATE_PAGE = "updateBook.jsp";
    private static final String UPDATE_BOOK = "UpdateBookController";
    private static final String RETURN_BOOK = "ReturnBookController";
    private static final String FIND_ORDER = "FindOrderController";
    private static final String TACK_BACK = "TakeBookBackController";
    private static final String INSERT_PAGE = "insert.jsp";
    private static final String INSERT_CONTROL = "InsertBookController";

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
            String button = request.getParameter("btnAction");
            if (button.equals("Sign In")) {
                url = LOG_IN;
            } else if (button.equals("Log Out")) {
                url = LOG_OUT;
            } else if (button.equals("Search")) {
                url = SEARCH;
            } else if (button.equals("Add To Cart")) {
                url = ADD_TO_CART;
            } else if (button.equals("View Cart")) {
                url = VIEW_CART;
            } else if (button.equals("Finish")) {
                url = FINISH;
            } else if (button.equals("Change")) {
                url = CHANGE;
            } else if (button.equals("Change Password")) {
                url = CHANGE_PASSWORD;
            } else if (button.equals("DecreaseCart")) {
                url = DECREASE_CART;
            } else if (button.equals("IncreaseCart")) {
                url = INCREASE_CART;
            } else if (button.equals("Delete Item")) {
                url = DELETE_ITEM;
            } else if (button.equals("Create")) {
                url = CREATE_USER;
            } else if (button.equals("Delete")) {
                url = DELETE_BOOK;
            } else if (button.equals("Update Book")) {
                url = UPDATE_PAGE;
            } else if (button.equals("Update")) {
                url = UPDATE_BOOK;
            } else if (button.equals("Return Book")) {
                url = RETURN_BOOK;
            } else if (button.equals("Find")) {
                url = FIND_ORDER;
            } else if (button.equals("Take")) {
                url = TACK_BACK;
            } else if (button.equals("Insert New Book")) {
                url = INSERT_PAGE;
            } else if (button.equals("Insert")) {
                url = INSERT_CONTROL;
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
