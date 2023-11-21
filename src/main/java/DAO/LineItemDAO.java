package DAO;

import Entity.*;
import data.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.sound.sampled.Line;
import java.util.List;

public class LineItemDAO {
    public static void insert(LineItem lineItem){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(lineItem);
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void update(LineItem lineItem){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(lineItem);
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void deleteItem(LineItem lineItem) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(lineItem));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void delete(String productCode){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            Product p = em.find(Product.class, productCode);
            if (p != null) {
                LineItem l = em.find(LineItem.class, p);
                if (l != null) {
                    em.remove(l);
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
    public static LineItem selectLineItem(long id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT l FROM LineItem l WHERE l.id = :id";
        TypedQuery<LineItem> q = em.createQuery(qString, LineItem.class);
        q.setParameter("id", id);
        try {
            LineItem lineItem = q.getSingleResult();
            return lineItem;
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        } finally {
            em.close();
        }
    }
    public static List<LineItem> selectLineItems(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT l FROM LineItem l";
        TypedQuery<LineItem> q = em.createQuery(qString, LineItem.class);
        List<LineItem> lineItems = null;
        try {
            lineItems = q.getResultList();
            if (lineItems == null || lineItems.isEmpty()){
                lineItems = null;
            }
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return lineItems;
    }
}
