/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynm.controller;

import huynm.books.BookDAO;
import huynm.books.BookDTO;
import huynm.cart.CartDTO;
import huynm.order.OrderDAO;
import huynm.order.OrderDTO;
import huynm.orderdetail.OderDetailDTO;
import huynm.orderdetail.OrderDetailDAO;
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
public class FinishController extends HttpServlet {

    private static final String SUCCESS = "SearchController";
    private static final String ERROR = "viewCart.jsp";

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
            HttpSession session = request.getSession();
            int userID = (int) session.getAttribute("USER_ID");
            String orderDate = "" + java.time.LocalDate.now();
            String returnDate = request.getParameter("txtReturnDate");

            OrderDAO orderDAO = new OrderDAO();
            
            OrderDTO orderDTO = new OrderDTO(userID, orderDate, returnDate);
            
            int orderKey = orderDAO.createANewOrder(orderDTO);
            CartDTO cart = (CartDTO) session.getAttribute("ORDER");

            if (orderDTO != null) {
                
                if (cart == null) {
                    return;
                }
                OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
                for (OderDetailDTO dto : cart.getCart().values()) {
                    orderDetailDAO.createANewOrder(dto.getBookID(), dto.getAmount(), orderKey);
                    
                    BookDAO bookDAO = new BookDAO();
                    BookDTO bookDTO = bookDAO.getBookByID(dto.getBookID());
                    bookDAO.updateQuantity(bookDTO.getQuantity(), dto.getAmount(), dto.getBookID());
                }
            }
            cart.getCart().clear();
            url = SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
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
