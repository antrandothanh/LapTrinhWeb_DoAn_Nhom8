package DAO;
import Entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import data.*;
public class productDAO {
    public static void insert(Product product)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(product);
            trans.commit();
            System.out.println("OK nha");
        }
        catch (Exception e) {
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    public static void update(Product p) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(p);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
//    public static void update(String productCode, String newCode, String newName, long newPrice, String newBrand, String newCollection,
//                              String newType, String newColor, String newIMG, String newDes) {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        EntityTransaction trans = em.getTransaction();
//        trans.begin();
//        try {
//            Product p = em.find(Product.class, productCode);
//            p.setCode(newCode);
//            p.setName(newName);
//            p.setPrice(newPrice);
//            p.setBrandCode(newBrand);
//            p.setCollection(newCollection);
//            p.setType(newType);
//            p.setColor(newColor);
//            p.setImgURL(newIMG);
//            p.setDescription(newDes);
//            em.merge(p);
//            trans.commit();
//        } catch (Exception e) {
//            System.out.println(e);
//            trans.rollback();
//        } finally {
//            em.close();
//        }
//    }
    public static void delete(String productCode) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            Product p = em.find(Product.class, productCode);
            em.remove(em.merge(p));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static Product selectProduct(String code)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p FROM Product p " +
                "WHERE p.code = :code";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("code",code);
        try {
            Product product=q.getSingleResult();
            return product;
        }
        catch (NoResultException e){
            return null;
        }
        finally {
            em.close();
        }
    }
    public static List<Product> selectProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p from Product p";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);

        List<Product> products;
        try {
            products = q.getResultList();
            if (products == null || products.isEmpty())
                products = null;
        } finally {
            em.close();
        }
        return products;
    }
    public static boolean productExisted(String productCode) {
        Product temp = selectProduct( productCode);
        if (temp == null) {
            return false;
        }
        return true;
    }
}
