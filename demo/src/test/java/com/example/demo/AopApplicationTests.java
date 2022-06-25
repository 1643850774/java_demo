package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AopApplicationTests {


    @Autowired
    UserMapper userMapper;

    @Test
    void insert() {
        User user = new User();
        user.setName("tom");
        user.setAge(10);

        int result = userMapper.insertUser(user);
        if (result > 0) System.out.println("成功插入user: " + user);

    }

    @Test
    void select() {
        System.out.println(userMapper.selectById(1));
    }

}
