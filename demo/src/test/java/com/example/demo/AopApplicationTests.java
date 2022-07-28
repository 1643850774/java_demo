package com.example.demo;

import com.example.demo.entity.Students;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

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
    void insertStudents() {
        User tom = new User();
        tom.setName("tom");
        tom.setAge(10);

        User jerry = new User();
        jerry.setName("jerry");
        jerry.setAge(10);

        User rose = new User();
        rose.setName("rose");
        rose.setAge(10);

        ArrayList<User> users = new ArrayList<>();
        users.add(tom);
        users.add(jerry);
        users.add(rose);


        Students students = new Students();
        students.setAge(10);
        students.setStudents(users);


        int result = userMapper.insertStudents(students);
        if (result > 0) System.out.println("成功插入user: " + students);

    }

    @Test
    void select() {
        System.out.println(userMapper.selectById(1));
    }

}
