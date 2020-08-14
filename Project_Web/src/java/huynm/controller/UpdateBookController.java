/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynm.controller;

import huynm.books.BookDAO;
import huynm.books.BookDTO;
import huynm.books.ErrorBookDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class UpdateBookController extends HttpServlet {

    private static final String SEARCH_PAGE = "SearchController";
    private static final String ERROR = "updateBook.jsp";

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
            String bookID = request.getParameter("txtBookID");
            String fullname = request.getParameter("txtBookName");
            String quantity = request.getParameter("txtBookQuantity");
            String bookDes = request.getParameter("txtBookDes");
            String prices = request.getParameter("txtPrices");
            //String searchValues = request.getParameter("txtSearchValue");
            ErrorBookDTO error = new ErrorBookDTO("", "", "", "");
            boolean check = true;
            if (fullname.length() < 1) {
                error.setErrorbookName("Book Name must be inputted");
                check = false;
            }
            if (!quantity.matches("[0-9]+$")) {
                error.setErrorBookQuantity("Quantity must be a positive number");
                check = false;
            }
            if (bookDes.length() < 1) {
                error.setErrorDescrips("Book Name must be inputted");
                check = false;
            }
            if (!prices.matches("[0-9]*\\.?[0-9]+$")) {
                error.setErrorPrice("Prices must be a positive number");
                check = false;
            }

            if (check) {
                boolean showCart = false;
                if (Integer.parseInt(quantity) > 0) {
                    showCart = true;
                }
                BookDAO dao = new BookDAO();
                BookDTO dto = new BookDTO(bookID, fullname, Integer.parseInt(quantity), bookDes, Float.parseFloat(prices), showCart);
                dao.updateBook(dto);
                url = SEARCH_PAGE;
            } else {
                request.setAttribute("ERROR_BOOK", error);
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
