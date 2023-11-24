package DAO;

import Entity.*;
import Entity.LineItem;
import Entity.User;
import data.DBUtil;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {
    public static void insert(Cart cart){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(cart);
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void addItem(Cart cart, LineItem item){
        if (cart == null || cart.getItems() == null) {
            List<LineItem> list = new ArrayList<>();
            list.add(item);
            cart.setItems(list);
            insert(cart);
            // Xử lý trường hợp cart hoặc danh sách items là null ở đây (throw exception hoặc xử lý một cách phù hợp)
            return;
        }

        String code = item.getItem().getCode();
        int quantity = item.getQuantity();
        for (int i = 0; i < cart.getItems().size(); i++){
            LineItem lineItem = cart.getItems().get(i);
            if (lineItem.getItem().getCode().equals(code)){
                int newQuantity = lineItem.getQuantity() + quantity;
                lineItem.setQuantity(newQuantity);
                LineItemDAO.update(lineItem);
                update(cart);
                return;
            }
        }
        LineItemDAO.insert(item);
        cart.getItems().add(item);
        update(cart);
    }

    public static void update(Cart cart) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(cart);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void updateLineItem(Cart cart, LineItem item){
        String code = item.getItem().getCode();
        int quantity = item.getQuantity();
        for (int i=0; i<cart.getItems().size(); i++){
            LineItem lineItem = cart.getItems().get(i);
            if (lineItem.getItem().getCode().equals(code)){
                lineItem.setQuantity(quantity);
                return;
            }
        }
    }
    public static void delete(String userId){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            User u = em.find(User.class, userId);
            if (u != null) {
                Cart c = em.find(Cart.class, u);
                if (c != null) {
                    em.remove(c);
                }
            }
            trans.commit();
            System.out.println("Xoa thanh cong");
        } catch (Exception e){
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void removeItem(Cart cart, LineItem item){
        String code = item.getItem().getCode();
        for (int i=0; i<cart.getItems().size(); i++){
            LineItem lineItem = cart.getItems().get(i);
            if (lineItem.getItem().getCode().equals(code)){
                cart.getItems().remove(lineItem);
                update(cart);
                LineItemDAO.deleteItem(lineItem);
                return;
            }
        }

    }
    public static int indexProductIsFound(Product product, Cart cart) {
        for (int i = 0; i < cart.getItems().size(); i++) {
            if (cart.getItems().get(i).getItem().getCode().equals(product.getCode())) {
                return i;
            }
        }
        return -1;
    }
    public static Cart selectCart(long userId){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT c FROM Cart c WHERE c.user.id = :userId";
        TypedQuery<Cart> q = em.createQuery(qString, Cart.class);
        q.setParameter("userId", userId);
        try {
            Cart cart = q.getSingleResult();
            return cart;
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        } finally {
            em.close();
        }
    }
    public static List<Cart> selectCarts(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT c FROM Cart c";
        TypedQuery<Cart> q = em.createQuery(qString, Cart.class);
        List<Cart> carts = null;
        try {
            carts = q.getResultList();
            if (carts == null || carts.isEmpty()){
                carts = null;
            }
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return carts;
    }
}
