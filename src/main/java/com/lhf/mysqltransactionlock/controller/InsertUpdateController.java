package com.lhf.mysqltransactionlock.controller;

import com.lhf.mysqltransactionlock.entity.User;
import com.lhf.mysqltransactionlock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuhongfei
 * @since v1.0.0
 **/
@RestController
@RequestMapping("/")
public class InsertUpdateController {

    @Autowired
    private UserService userService;

    @GetMapping("/ts1")
    public String ts1() throws InterruptedException {
        userService.saveUpdate();
        return "ok";
    }

    @GetMapping("/ts2")
    public String ts2() throws InterruptedException {
        userService.queryUpdate();
        return "ok";
    }

    @GetMapping("/ts3")
    public User ts3(){
        return userService.queryUser();
    }

    @GetMapping("/ts4")
    public String ts4(){
        userService.update();
        return "ok";
    }
}
