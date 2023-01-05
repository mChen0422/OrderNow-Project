package com.meitong.onlineorder.service;

import com.meitong.onlineorder.dao.CartDao;
import com.meitong.onlineorder.dao.HistoryDao;
import com.meitong.onlineorder.entity.Cart;
import com.meitong.onlineorder.entity.Customer;
import com.meitong.onlineorder.entity.OrderItem;
import com.meitong.onlineorder.entity.Orderhistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private HistoryDao historyDao;


    public List<Orderhistory> getHistory() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Customer customer = customerService.getCustomer(username);
        Cart cart = customer.getCart();
        int cartId = cart.getId();

        return historyDao.getAllHistory(cartId);

    }

}

