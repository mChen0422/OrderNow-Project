package com.meitong.onlineorder.dao;

import com.meitong.onlineorder.entity.Orderhistory;
import com.meitong.onlineorder.entity.Restaurant;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Repository
public class HistoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    /*
    public List<Orderhistory> getAllHistory(int cartId) {
        try (Session session = sessionFactory.openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Orderhistory> cq = cb.createQuery(Orderhistory.class);
            Root<Orderhistory> rootEntry = cq.from(Orderhistory.class);
            CriteriaQuery<Orderhistory> all = cq.select(rootEntry);
            TypedQuery<Orderhistory> allQuery = session.createQuery(all);
            return allQuery.getResultList();
        } catch (Exception ex) {
        ex.printStackTrace();
            return new ArrayList<>();
        }}}


     */
    /*
    public List<Orderhistory> findBycartId(int cartId) {
        try (Session session = sessionFactory.openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Orderhistory> cq = cb.createQuery(Orderhistory.class);
            Root<Orderhistory> rootEntry = cq.from(Orderhistory.class);
            cq.select(rootEntry);
            cq.where(cb.equal(rootEntry.get("cart_id"),cartId));
            TypedQuery<Orderhistory> allQuery = session.createQuery(cq);
            List<Orderhistory> result =  allQuery.getResultList();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
}
    }
    */
    public  List<Orderhistory> getAllHistory(int cartId) {
        try (Session session = sessionFactory.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Orderhistory> query = builder.createQuery(Orderhistory.class);
            Root<Orderhistory> root = query.from(Orderhistory.class);
            query.select(root).where(builder.equal(root.get("cartId"), cartId));
            Query<Orderhistory> q=session.createQuery(query);
            List<Orderhistory> res=q.getResultList();

            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
}

