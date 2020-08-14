/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynm.cart;

import huynm.orderdetail.OderDetailDTO;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class CartDTO {

    private Map<String, OderDetailDTO> cart;

    public CartDTO() {
    }

    public CartDTO(Map<String, OderDetailDTO> cart) {
        this.cart = cart;
    }

    /**
     * @return the cart
     */
    public Map<String, OderDetailDTO> getCart() {
        return cart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(Map<String, OderDetailDTO> cart) {
        this.cart = cart;
    }

    public void add(OderDetailDTO dto) {
        if (getCart() == null) {
            cart = new HashMap<>();
        }
        if (this.getCart().containsKey(dto.getBookID())) {
            int amount = this.getCart().get(dto.getBookID()).getAmount();
            dto.setAmount(amount + 1);
        }
        getCart().put(dto.getBookID(), dto);
    }

    public void removeItem(String id) {
        if ( this.cart != null){
            if(this.cart.containsKey(id)){
                this.cart.remove(id);
            }
        }
    }
    
    public void update(String id, OderDetailDTO dto){
        if ( this.cart != null){
            if(this.cart.containsKey(id)){
                this.cart.replace(id, dto);
            }
        }
    }

//    public boolean checkQuantity(OderDetailDTO dto) throws SQLException {
//        
//        BookDAO dao = new BookDAO();
//        List<BookDTO> list = dao.getListOfBook();
//        if (getCart() == null) {
//            return false;
//        }
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < listCart.size(); j++) {
//                if(cart.get(j).getBookID().equals(list.get(i).getBookID())){
//                    if(cart.get(j).getAmount() <= list.get(i).getQuantity()){
//                        return true ;
//                    }
//                }
//            }
//        }
//        return false ;
//    }
    
    
}
