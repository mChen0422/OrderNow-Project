package com.meitong.onlineorder.controller;


import com.meitong.onlineorder.entity.Comments;

import com.meitong.onlineorder.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void signUp(@RequestBody Comments comment) {
        commentsService.saveComments(comment);
    }

    @RequestMapping(value = "/comments/{menuItemId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Comments> getComments(@PathVariable(value = "menuItemId") int menuItemId) {
        return commentsService.getComments(menuItemId);
    }
}
