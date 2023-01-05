package com.meitong.onlineorder.dao;

//interaction with database
import com.meitong.onlineorder.entity.Authorities;
import com.meitong.onlineorder.entity.Comments;
import com.meitong.onlineorder.entity.Orderhistory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
public class CommentsDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Comments comment) {

        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            LocalDateTime nowTime = LocalDateTime.now();
            comment.setPublishedTimestamp(nowTime);
            session.save(comment);
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

    public List<Comments> getComments(int menuitmid) {
        try (Session session = sessionFactory.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Comments> query = builder.createQuery(Comments.class);
            Root<Comments> root = query.from(Comments.class);
            query.select(root).where(builder.equal(root.get("menuitemId"), menuitmid));
            Query<Comments> q=session.createQuery(query);
            List<Comments> res=q.getResultList();

            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
}
