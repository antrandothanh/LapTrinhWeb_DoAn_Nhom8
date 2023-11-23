package DAO;
import Entity.FavouriteProduct;
import  Entity.User;
import data.DBUtil;

import java.util.List;
import javax.persistence.*;
public class FavouriteProductDAO {
    public static void insert(FavouriteProduct fav) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(fav);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void update(FavouriteProduct fav) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(fav);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void delete(FavouriteProduct fav) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(fav));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static FavouriteProduct selectFavouriteProduct(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        String qString = "SELECT f FROM FavouriteProduct f WHERE f.user = :user";
        TypedQuery<FavouriteProduct> q = em.createQuery(qString, FavouriteProduct.class);
        q.setParameter("user", user);
        try {
            FavouriteProduct fav = q.getSingleResult();
            return fav;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    public static boolean favouriteProductExists(User user) {
        FavouriteProduct i = selectFavouriteProduct(user);
        return i != null;
    }
    public static List<FavouriteProduct> selectFavouriteProducts() {
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT f FROM FavouriteProduct f";
        TypedQuery<FavouriteProduct> q = entityManager.createQuery(qString, FavouriteProduct.class);
        List<FavouriteProduct> favs;
        try {
            favs = q.getResultList();
            if (favs == null || favs.isEmpty()) {
                favs = null;
            }
        } finally {
            entityManager.close();
        }
        return favs;
    }
}









