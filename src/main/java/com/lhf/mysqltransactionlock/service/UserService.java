package com.lhf.mysqltransactionlock.service;

import com.lhf.mysqltransactionlock.dao.UserMapper;
import com.lhf.mysqltransactionlock.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * @author liuhongfei
 * @since v1.0.0
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public void saveUpdate() throws InterruptedException {
        User user  = new User();
        user.setName("测试name");
        user.setAge(22);
        user.setBirthday(new Date());
        user.setCreatedAt(new Date());
        user.setGender("MALE");
        userMapper.insert(user);

        Thread.sleep(60000);
        user.setAge(30);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public void queryUpdate() throws InterruptedException {
        User user = userMapper.selectByPrimaryKey(2005L);
        user.setAge(33);
        userMapper.updateByPrimaryKeySelective(user);
        Thread.sleep(60000);
        System.out.println("等待");
    }

    @Transactional(rollbackFor = Exception.class)
    public User queryUser(){
        return userMapper.selectByPrimaryKey(2005L);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update() {
        User user = userMapper.selectByPrimaryKey(2005L);
        user.setName("234234");
        userMapper.updateByPrimaryKeySelective(user);
    }
}
