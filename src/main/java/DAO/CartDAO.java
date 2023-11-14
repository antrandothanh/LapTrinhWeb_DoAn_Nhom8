package DAO;

import Entity.Cart;
import Entity.User;
import data.DBUtil;

import javax.persistence.*;
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
    public static void update(Cart cart){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(cart);
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
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
    public static Cart selectCart(String userId){
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
