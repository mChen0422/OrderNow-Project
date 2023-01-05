package com.meitong.onlineorder.controller;
import com.meitong.onlineorder.entity.Cart;
import com.meitong.onlineorder.entity.Orderhistory;
import com.meitong.onlineorder.service.CartService;
import com.meitong.onlineorder.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class OrderHistoryController {

    @Autowired
    private OrderHistoryService orderHistoryService;


    @RequestMapping(value = "/history", method = RequestMethod.GET)
    @ResponseBody


    public List<Orderhistory> getHistory(){
        return orderHistoryService.getHistory();
    }}



