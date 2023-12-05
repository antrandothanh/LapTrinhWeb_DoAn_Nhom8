package DAO;

import Entity.*;
import data.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class BoughtItemDAO {
    public static void insert(BoughtItem boughtItem){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(boughtItem);
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void update(BoughtItem boughtItem){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(boughtItem);
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void deleteItem(BoughtItem boughtItem) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(boughtItem));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void delete(String productCode){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            Product p = em.find(Product.class, productCode);
            if (p != null) {
                BoughtItem l = em.find(BoughtItem.class, p);
                if (l != null) {
                    em.remove(l);
                }
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
    public static BoughtItem selectBoughtItem(long id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT l FROM BoughtItem l WHERE l.id = :id";
        TypedQuery<BoughtItem> q = em.createQuery(qString, BoughtItem.class);
        q.setParameter("id", id);
        try {
            BoughtItem boughtItem = q.getSingleResult();
            return boughtItem;
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        } finally {
            em.close();
        }
    }
    public static List<BoughtItem> selectBoughtItems(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT l FROM BoughtItem l";
        TypedQuery<BoughtItem> q = em.createQuery(qString, BoughtItem.class);
        List<BoughtItem> boughtItems = null;
        try {
            boughtItems = q.getResultList();
            if (boughtItems == null || boughtItems.isEmpty()){
                boughtItems = null;
            }
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return boughtItems;
    }
//    public static int[] timSanPhamXuatHienNhieuNhat(List<BoughtItem> listBought){
//        int max = 0;
//        int[] index_value = new int[2];
//        int []b = new int[listBought.size()]; //tao mang b co listBought.size phan tu = 0
//        for (int i=0; i<listBought.size(); i++){
//            for (int j=0; j<=i; j++){
//                if (listBought.get(i).getItem().getCode().equals(listBought.get(j).getItem().getCode())){
//                    b[i]+=listBought.get(j).getQuantity();
//                }
//            }
//        }
//        //tim max
//        max = b[0];
//        for (int i=1; i<listBought.size(); i++){
//            if (b[i] > max){
//                max =  b[i];
//            }
//        }
//        for (int i=0; i<listBought.size(); i++){
//            if (b[i] == max){
//                System.out.println("San pham xh nhieu nhat: "+ listBought.get(i).getItem().getCode());
//                System.out.println("So luong: " + b[i]);
//                index_value[0] = i;
//                index_value[1] = b[i];
//            }
//        }
//        return index_value;
//    }

}
