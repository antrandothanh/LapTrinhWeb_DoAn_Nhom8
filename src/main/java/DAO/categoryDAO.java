package DAO;

import data.*;
import Entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
public class categoryDAO {
    public static void insert(Category category) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(category);
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
    public static void update(Category category) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(category);
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
    public static void delete(Category category) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(category));
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
    public static Category selectCategory(String code) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT c FROM Category c " +
                "WHERE c.code = :code";
        TypedQuery<Category> q = em.createQuery(qString, Category.class);
        q.setParameter("code", code);
        try {
            Category category = q.getSingleResult();
            return category;
        }
        catch (NoResultException e) {
            return null;
        }
        finally {
            em.close();
        }
    }
    public static List<Category> selectCategories() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT c from Category c";
        TypedQuery<Category> q = em.createQuery(qString, Category.class);

        List<Category> categories;
        try {
            categories = q.getResultList();
            if (categories == null || categories.isEmpty())
                categories = null;
        } finally {
            em.close();
        }
        return categories;
    }
}
