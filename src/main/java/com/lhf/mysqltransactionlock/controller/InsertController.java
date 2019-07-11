package com.lhf.mysqltransactionlock.controller;

import com.lhf.mysqltransactionlock.entity.User;
import com.lhf.mysqltransactionlock.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.stream.Stream;

/**
 * 测试连接数据库问题
 * @author liuhongfei
 * @since v1.0.0
 **/
@RestController
@RequestMapping("/insert")
public class InsertController {

    @Autowired
    private InsertService insertService;

    @GetMapping("/insert")
    public String doInsert(){
        Stream.iterate(1,item->item+1).limit(1000).forEach(item->{
            User user  = new User();
            user.setName("测试name");
            user.setAge(item);
            user.setBirthday(new Date());
            user.setCreatedAt(new Date());
            user.setGender("MALE");
            insertService.insert(user);
        });
        return "ok";
    }
}
