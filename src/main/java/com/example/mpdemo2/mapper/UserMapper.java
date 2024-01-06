package com.example.mpdemo2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpdemo2.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//mybatis
@Mapper
public interface UserMapper {
    @Select("select * from user")
    public List<User> find();

    @Select("select * from user")
    @Results({
            @Result(column="id",property = "id"),
            @Result(column="username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "id",property = "orders",javaType = List.class,
                    many = @Many(select = "com.example.mpdemo2.mapper.OrderMapper.selectByUid"))
    })
    List<User> selectAllUserAndOrders();

    @Select("select * from user where id = #{uid}")
    User selectByUid(int uid);

    @Insert("insert into user values (#{id},#{username},#{password},#{birthday})")
    public int insert(User user);
}

//mybatisPlus



