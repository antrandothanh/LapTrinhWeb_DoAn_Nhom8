package DAO;
import Entity.User;
import data.DBUtil;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UserDAO {
    public static void insert(User user){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(user);
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void update(User user){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.merge(user);
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
            System.out.println(u.toString());
            if (u != null)
            {
                em.remove(u);
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
    public static User selectUser(String userId){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u WHERE u.id = :userId";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("userId", userId);
        try {
            User user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        } finally {
            em.close();
        }
    }
    public static List<User> selectUsers(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u from User u";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        List<User> users = null;
        try{
            users = q.getResultList();
            if (users == null || users.isEmpty()){
                users = null;
            }
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return users;
    }
}
