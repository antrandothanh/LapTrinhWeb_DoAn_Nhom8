package data;

import Entity.Invoice;
import java.util.List;
import javax.persistence.*;
import Entity.Payment;
public class PaymentDAO {

    public static void insert(Payment payment) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(payment);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Payment payment) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(payment);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Payment payment) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(payment));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static Payment selectPayment(Invoice invoice) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p FROM Payment p " +
                "WHERE p.invoice = :invoice";
        TypedQuery<Payment> q = em.createQuery(qString, Payment.class);
        q.setParameter("invoice", invoice);
        try {
            Payment payment = q.getSingleResult();
            return payment;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean paymentExists(Invoice invoice) {
        Payment p = selectPayment(invoice);
        return p != null;
    }

    public static List<Payment> selectPayments() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p from Payment p";
        TypedQuery<Payment> q = em.createQuery(qString, Payment.class);

        List<Payment> payments;
        try {
            payments = q.getResultList();
            if (payments == null || payments.isEmpty())
                payments = null;
        } finally {
            em.close();
        }
        return payments;
    }
}