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
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class InsertBookController extends HttpServlet {
    private static final String SEARCH_PAGE = "SearchController";
    private static final String ERROR = "insert.jsp";

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
            String publisher = request.getParameter("txtPublisher");
            String author = request.getParameter("txtAuthor");
            String bookDes = request.getParameter("txtBookDes");
            String category = request.getParameter("txtCate");
            String prices = request.getParameter("txtPrices");
            
            ErrorBookDTO error = new ErrorBookDTO("", "", "", "", "", "", "", "");
            boolean check = true;
            if (fullname.length() < 1) {
                error.setErrorbookName("Book Name must be inputted");
                check = false;
            }
            if (bookID.length() < 1) {
                error.setErrorBookID("Book ID must be inputted");
                check = false;
            }
            if (publisher.length() < 1) {
                error.setErrorPublisher("Book Publisher must be inputted");
                check = false;
            }
            if (author.length() < 1) {
                error.setErrorAuthor("Author must be inputted");
                check = false;
            }
            
            if (!quantity.matches("[0-9]+$")) {
                error.setErrorBookQuantity("Quantity must be a positive number");
                check = false;
            }
            if (!category.matches("[0-9]+$")) {
                error.setErrorCate("Category must be a positive number");
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
            if(check){
                BookDAO dao = new BookDAO();
                BookDTO dto = new BookDTO(bookID, fullname, Integer.parseInt(quantity), publisher, author, bookDes, Integer.parseInt(category), Float.parseFloat(prices), true);
                dao.insertANewBook(dto);
                url = SEARCH_PAGE;
            }else {
                request.setAttribute("ERROR_BOOK", error);
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
