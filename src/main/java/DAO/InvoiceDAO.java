package DAO;
import Entity.Invoice;
import Entity.User;
import data.DBUtil;

import java.util.List;
import javax.persistence.*;
public class InvoiceDAO {
    public static void insert(Invoice invoice) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(invoice);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void update(Invoice invoice) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(invoice);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void delete(Invoice invoice) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(invoice));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static Invoice selectInvoice(long userId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT i FROM Invoice i WHERE i.user.id = :userId";
        TypedQuery<Invoice> q = em.createQuery(qString, Invoice.class);
        q.setParameter("userId", userId);
        try {
            Invoice invoice = q.getSingleResult();
            return invoice;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean invoiceExists(long userId) {
        Invoice i = selectInvoice(userId);
        return i != null;
    }
    public static List<Invoice> selectInvoices() {
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT i FROM Invoice i";
        TypedQuery<Invoice> q = entityManager.createQuery(qString, Invoice.class);
        List<Invoice> invoices;
        try {
            invoices = q.getResultList();
            if (invoices == null || invoices.isEmpty()) {
                invoices = null;
            }
        } finally {
            entityManager.close();
        }
        return invoices;
    }
}









