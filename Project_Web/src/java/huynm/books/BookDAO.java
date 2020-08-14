/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynm.books;

import huynm.dbutils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class BookDAO {

    public List<BookDTO> searchListByName(String bookName) throws SQLException {
        List<BookDTO> list = new ArrayList<>();

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                String sql = "select bookID,bookName, bookQuantity , bookDescription , prices,showCart from Books where bookName like ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + bookName + "%");
                rs = pst.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String bookNames = rs.getString("bookName");
                    int bookQuantity = rs.getInt("bookQuantity");
                    String bookDesctiption = rs.getString("bookDescription");
                    float prices = rs.getFloat("prices");
                    boolean showCart = rs.getBoolean("showCart");

                    list.add(new BookDTO(bookID, bookNames, bookQuantity, bookDesctiption, prices, showCart));

                }
            }

        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public List<BookDTO> getListOfBook() throws SQLException {
        List<BookDTO> list = new ArrayList<>();

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                String sql = "select [bookID],[bookName],[bookQuantity],[bookPublisher],[bookAuthor],[bookDescription],[categoryID],[prices],showCart from Books";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String bookNames = rs.getString("bookName");
                    int bookQuantity = rs.getInt("bookQuantity");
                    String bookPublisher = rs.getString("bookPublisher");
                    String author = rs.getString("bookAuthor");
                    String bookDesctiption = rs.getString("bookDescription");
                    int category = rs.getInt("categoryID");
                    float prices = rs.getFloat("prices");
                    boolean showCart = rs.getBoolean("showCart");

                    list.add(new BookDTO(bookID, bookNames, bookQuantity, bookPublisher, author, bookDesctiption, category, prices, showCart));
                }
            }

        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public void updateShowCart() throws SQLException {
        List<BookDTO> list = getListOfBook();

        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getQuantity() > 0) {
                        String sql = "update [dbo].[Books] set showCart = 1 where [bookID] = ?";
                        pst = cn.prepareStatement(sql);
                        pst.setString(1, list.get(i).getBookID());
                        pst.executeUpdate();
                    } else {
                        String sql = "update [dbo].[Books] set showCart = 0 where [bookID] = ?";
                        pst = cn.prepareStatement(sql);
                        pst.setString(1, list.get(i).getBookID());
                        pst.executeUpdate();
                    }

                }
            }

        } catch (Exception e) {

        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }

    public void updateQuantity(int bookQuantity, int amount, String bookID) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        int result = bookQuantity - amount;
        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                String sql = "update [dbo].[Books] set bookQuantity=? where bookID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, result);
                pst.setString(2, bookID);
                pst.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }

    public void updateReturn(int bookQuantity, int amount, String bookID) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        int result = bookQuantity + amount;
        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                String sql = "update [dbo].[Books] set bookQuantity=? where bookID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, result);
                pst.setString(2, bookID);
                pst.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }

    public BookDTO getBookByID(String bookIDD) throws SQLException {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        BookDTO dto = null;
        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                String sql = "select bookID , bookName, bookQuantity , bookDescription , prices,showCart from Books where bookID = ? ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, bookIDD);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String bookNames = rs.getString("bookName");
                    int bookQuantity = rs.getInt("bookQuantity");
                    String bookDesctiption = rs.getString("bookDescription");
                    float prices = rs.getFloat("prices");
                    boolean showCart = rs.getBoolean("showCart");

                    dto = new BookDTO(bookID, bookNames, bookQuantity, bookDesctiption, prices, showCart);

                }
            }

        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return dto;
    }

    public void delelteByUserID(String bookID) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                String sql = "delete from Books where bookID = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, bookID);
                pst.executeUpdate();
            }
        } catch (Exception e) {

        } finally {

            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }

    public void updateBook(BookDTO dto) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                String sql = "update [dbo].[Books] set [bookName] = ? ,[bookQuantity] = ? ,[bookDescription] = ? ,[prices] = ? where [bookID] = ?";

                pst = cn.prepareStatement(sql);
                pst.setString(5, dto.getBookID());
                pst.setString(1, dto.getBookName());
                pst.setInt(2, dto.getQuantity());
                pst.setString(3, dto.getBookDescription());
                pst.setFloat(4, dto.getPrices());
                pst.executeUpdate();

            }
        } catch (Exception e) {

        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }

    public void insertANewBook(BookDTO dto) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyConnection.makeConnection();
            if (cn != null) {
                String sql = "insert into [dbo].[Books] ([bookID],[bookName],[bookQuantity],[bookPublisher],[bookAuthor],[bookDescription],[categoryID],[prices],[showCart]) values (?,?,?,?,?,?,?,?,?)";

                pst = cn.prepareStatement(sql);
                pst.setString(1, dto.getBookID());
                pst.setString(2, dto.getBookName());
                pst.setInt(3, dto.getQuantity());
                pst.setInt(7, dto.getCategory());
                pst.setString(6, dto.getBookDescription());
                pst.setString(4, dto.getPublisher());
                pst.setString(5, dto.getAuthor());
                pst.setFloat(8, dto.getPrices());
                pst.setBoolean(9, dto.isShowCart());
                pst.executeUpdate();

            }
        } catch (Exception e) {

        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }

}
