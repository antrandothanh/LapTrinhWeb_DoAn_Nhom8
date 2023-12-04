package DAO;
import Entity.Invoice;
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
    public static int[] timUserMuaNhieuNhat(List<Invoice> invoices){
        int max = 0;
        int [] index_value = new int[2];
        int b[] = new int[invoices.size()];
        for (int i=0; i<invoices.size(); i++){
            for (int j=0; j<=i; j++){
                if (invoices.get(i).getUser().getId() == invoices.get(j).getUser().getId()){
                    b[i] += 1;
                }
            }
        }
        max = b[0];
        for (int i=0; i<invoices.size(); i++){
            if (b[i] > max){
                max = b[i];
            }
        }
        for (int i=0; i<invoices.size(); i++){
            if (b[i] == max){
                System.out.println("Ma khach hang mua nhieu nhat: "+ invoices.get(i).getUser().getId());
                System.out.println("Khach hang mua nhieu nhat: "+ invoices.get(i).getUser().getName());
                System.out.println("So lan mua hang: " + b[i]);
                index_value[0] = i;
                index_value[1] = b[i];
            }
        }

        return index_value;
    }
    public static long total_amount_purchased(List<Invoice> invoices, long userid){
        long total = 0;
        for (int i=0; i< invoices.size(); i++){
            if (invoices.get(i).getUser().getId() == userid){
                total += invoices.get(i).getTotalPrice();
            }
        }
        return total;
    }
    public static long totalRevenue(List<Invoice> invoices) {
        long total = 0;
        for (int i = 0; i < invoices.size(); i++) {
            total += invoices.get(i).getTotalPrice();
        }
        return total;
    }
    public static int totalAmountOfProduct(List<Invoice> invoices){
        int quantity = 0;
        for (int i=0; i<invoices.size(); i++){
            quantity += invoices.get(i).getToTalAmountOfProduct();
        }
        return quantity;
    }
}









