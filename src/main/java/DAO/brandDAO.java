package DAO;
import Entity.*;
import data.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
public class brandDAO {
    public static void insert(Brand brand) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(brand);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Brand brand) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(brand);
            trans.commit();
        }
        catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    public static void delete(Brand brand) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(brand));
            trans.commit();
        }
        catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    public static Brand selectBrand(String name) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT b FROM Brand b " +
                "WHERE b.name = :name";
        TypedQuery<Brand> q = em.createQuery(qString, Brand.class);
        q.setParameter("name", name);
        try {
            Brand brand = q.getSingleResult();
            return brand;
        }
        catch (NoResultException e) {
            return null;
        }
        finally {
            em.close();
        }
    }
    public static List<Brand> selectBrands() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT b from Brand b";
        TypedQuery<Brand> q = em.createQuery(qString, Brand.class);

        List<Brand> brands;
        try {
            brands = q.getResultList();
            if (brands == null || brands.isEmpty())
                brands = null;
        } finally {
            em.close();
        }
        return brands;
    }
}
