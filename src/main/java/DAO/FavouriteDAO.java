package DAO;
import  Entity.*;
import data.DBUtil;

import java.util.List;
import javax.persistence.*;
public class FavouriteDAO {
    public static void insert(Favourite fav) {
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
    public static void update(Favourite fav) {
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
    public static void delete(Favourite fav) {
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
    public static int indexProductIsFound(Product product, Favourite favourite) {
        for (int i = 0; i < favourite.getProducts().size(); i++) {
            if (favourite.getProducts().get(i).getCode().equals(product.getCode())) {
                return i;
            }
        }
        return -1;
    }
    public static Favourite selectFavourite(long userId){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT f FROM Favourite f WHERE f.user.id = :userId";
        TypedQuery<Favourite> q = em.createQuery(qString, Favourite.class);
        q.setParameter("userId", userId);
        try {
            Favourite favourite = q.getSingleResult();
            return favourite;
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        } finally {
            em.close();
        }
    }
    public static FavouriteDAO selectFavouriteProduct(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        String qString = "SELECT f FROM Favourite f WHERE f.user = :user";
        TypedQuery<FavouriteDAO> q = em.createQuery(qString, FavouriteDAO.class);
        q.setParameter("user", user);
        try {
            FavouriteDAO fav = q.getSingleResult();
            return fav;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    public static boolean favouriteProductExists(User user) {
        FavouriteDAO i = selectFavouriteProduct(user);
        return i != null;
    }
    public static List<FavouriteDAO> selectFavouriteProducts() {
        EntityManager entityManager = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT f FROM Favourite f";
        TypedQuery<FavouriteDAO> q = entityManager.createQuery(qString, FavouriteDAO.class);
        List<FavouriteDAO> favs;
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









