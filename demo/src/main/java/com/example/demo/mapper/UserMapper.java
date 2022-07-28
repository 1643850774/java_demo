package com.example.demo.mapper;

import com.example.demo.entity.Students;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user (name, age) values (#{name}, #{age})")
    int insertUser(User user);


    @Select("select * from user where id = #{id}")
    User selectById(@Param("id") int id);

    @Insert({
            "<script>",
            "insert into user (name, age) values ",
            "<foreach item='student' collection='students' separator=','>",
            "(#{student.name},#{age}) ",
            "</foreach> ",
            "</script>"
    })
    int insertStudents(Students students);
}
