package com.meitong.onlineorder.service;

import com.meitong.onlineorder.dao.CommentsDao;

import  com.meitong.onlineorder.dao.CommentsDao;
import com.meitong.onlineorder.entity.Comments;
import com.meitong.onlineorder.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    @Autowired

    private CommentsDao commentsDao;

    public void saveComments(Comments comment) {
        int cartId = comment.getCartId();

        commentsDao.save(comment);
    }

    public List<Comments> getComments(int menuItemId) {
        return commentsDao.getComments(menuItemId);
    }

}
