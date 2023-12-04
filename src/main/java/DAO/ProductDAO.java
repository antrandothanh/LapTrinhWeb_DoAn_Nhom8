package DAO;
import Entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import data.*;
public class ProductDAO {
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

    public static List<Product> searchProducts(String searchInput) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT p from Product p WHERE p.name LIKE CONCAT('%',:searchInput,'%')";
        TypedQuery<Product> q = em.createQuery(query, Product.class);
        q.setParameter("searchInput", searchInput);
        List<Product> foundProducts;
        try {
            foundProducts = q.getResultList();
            if (foundProducts == null || foundProducts.isEmpty())
                foundProducts = null;
        } finally {
            em.close();
        }
        return foundProducts;
    }
    public static List<Product> getProductsMore500M() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT p FROM Product p WHERE p.price > 5000000";
        TypedQuery<Product> q = em.createQuery(query, Product.class);
        List<Product> highPriceProducts;
        try {
            highPriceProducts = q.getResultList();
            if (highPriceProducts == null || highPriceProducts.isEmpty()) {
                highPriceProducts = null;
            }
        } finally {
            em.close();
        }
        return highPriceProducts;
    }
    public static List<Product> getProductsLess500M() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT p FROM Product p WHERE p.price < 5000000";
        TypedQuery<Product> q = em.createQuery(query, Product.class);
        List<Product> highPriceProducts;
        try {
            highPriceProducts = q.getResultList();
            if (highPriceProducts == null || highPriceProducts.isEmpty()) {
                highPriceProducts = null;
            }
        } finally {
            em.close();
        }
        return highPriceProducts;
    }
    public static List<Product> getProductsMinToMax() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT p FROM Product p ORDER BY p.price ASC";
        TypedQuery<Product> q = em.createQuery(query, Product.class);
        List<Product> sortedProducts;
        try {
            sortedProducts = q.getResultList();
            if (sortedProducts == null || sortedProducts.isEmpty()) {
                sortedProducts = null;
            }
        } finally {
            em.close();
        }
        return sortedProducts;
    }
    public static List<Product> getProductsMaxToMin() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT p FROM Product p ORDER BY p.price DESC";
        TypedQuery<Product> q = em.createQuery(query, Product.class);
        List<Product> sortedProducts;
        try {
            sortedProducts = q.getResultList();
            if (sortedProducts == null || sortedProducts.isEmpty()) {
                sortedProducts = null;
            }
        } finally {
            em.close();
        }
        return sortedProducts;
    }
}
