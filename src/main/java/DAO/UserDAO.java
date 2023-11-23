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
    public static void delete(User user){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            User u = em.find(User.class, user.getId());
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
    public static User selectUser(String username){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u WHERE u.username = :username";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("username", username);
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

    //kiem tra user co ton tai trong database
    public static boolean userExisted(String username) {
        User temp = selectUser(username);
        if (temp == null) {
            return false;
        }
        return true;
    }

    //kiem tra ten tai khoan va mat khau
    public static boolean checkValidAccount(String username, String password) {
        User temp = selectUser(username);
        if (temp == null) {
            return false; //ten tai khoan khong hop le
        } else {
            //kiem tra mat khau hop le
            if (temp.getPassword().equals(password)) {
                return true;
            } return false;
        }
    }
}
