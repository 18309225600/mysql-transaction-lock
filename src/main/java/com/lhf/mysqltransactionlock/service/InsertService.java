package com.lhf.mysqltransactionlock.service;

import com.lhf.mysqltransactionlock.dao.UserMapper;
import com.lhf.mysqltransactionlock.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuhongfei
 * @since v1.0.0
 **/
@Service
public class InsertService {

    @Autowired
    private UserMapper userMapper;

    public void insert(User user){
        userMapper.insert(user);
    }
}
