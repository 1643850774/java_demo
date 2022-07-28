package com.example.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Students {
//    同班级的学生年龄
    private Integer age;

    private List<User> students;
}
