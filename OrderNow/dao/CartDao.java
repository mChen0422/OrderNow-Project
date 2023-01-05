package com.meitong.onlineorder.dao;

import com.meitong.onlineorder.entity.Cart;
import com.meitong.onlineorder.entity.OrderItem;
import com.meitong.onlineorder.entity.Orderhistory;
import com.meitong.onlineorder.entity.MenuItem;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void removeCartItem(int orderItemId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            OrderItem cartItem = session.get(OrderItem.class, orderItemId);

            Cart cart = cartItem.getCart();
            cart.getOrderItemList().remove(cartItem);

            session.beginTransaction();
            session.delete(cartItem);
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
    public void save(Orderhistory orderhistory)
    {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(orderhistory);
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public  List<Orderhistory> findHistory(int cartId,int menuItemId) {
        try (Session session = sessionFactory.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Orderhistory> query = builder.createQuery(Orderhistory.class);
            Root<Orderhistory> root = query.from(Orderhistory.class);
            query.select(root).where(builder.equal(root.get("cartId"), cartId)).where(builder.equal(root.get("menuitemId"), menuItemId));
            Query<Orderhistory> q=session.createQuery(query);
            List<Orderhistory> res=q.getResultList();

            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void SaveAllOrderToHistory(Cart cart)
    {
        LocalDateTime nowTime = LocalDateTime.now();
        int cartId = cart.getId();
        for (OrderItem item : cart.getOrderItemList())
        {
            MenuItem menuItem= item.getMenuItem();
            int menuItemId = menuItem.getId();
            String menuName = menuItem.getName();
            if (this.findHistory(cartId,menuItemId).isEmpty())
            {
                final Orderhistory orderhistory = new Orderhistory();
                orderhistory.setPublishedTimestamp(nowTime);
                orderhistory.setCartId(cartId);
                orderhistory.setMenuitemId(menuItemId);
                orderhistory.setMenuItemName(menuName);
                this.save(orderhistory);}



        }
    }
    public void removeAllCartItems(Cart cart) {
        for (OrderItem item : cart.getOrderItemList()) {

            removeCartItem(item.getId());
        }
    }
}

