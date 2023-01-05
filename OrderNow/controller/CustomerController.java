package com.meitong.onlineorder.controller;



import com.meitong.onlineorder.entity.Cart;
import com.meitong.onlineorder.entity.Customer;
import com.meitong.onlineorder.entity.Orderhistory;
import com.meitong.onlineorder.service.CartService;
import com.meitong.onlineorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {


    @Autowired
    private CustomerService customerService;



    @RequestMapping(value = "/getCustomer", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCart(){
        return customerService.getCustomer();
    }}

