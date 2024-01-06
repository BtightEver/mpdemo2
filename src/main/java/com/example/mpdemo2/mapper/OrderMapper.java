package com.example.mpdemo2.mapper;

import com.example.mpdemo2.entity.Order;
import com.example.mpdemo2.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface OrderMapper {
    @Select("select * from t_order where uid = #{uid}")
    List<Order> selectByUid(int uid);

    @Select("select * from t_order")
    @Results({
            @Result(column="id",property = "id"),
            @Result(column="order_time",property = "order_time"),
            @Result(column = "total",property = "total"),
            @Result(column = "uid",property = "user",javaType = User.class,
                    one = @One(select = "com.example.mpdemo2.mapper.UserMapper.selectByUid"))
    })
    List<Order> selectOrderAndItsOrders();
    @Select("select * from t_order")
    List<Order> Orders();
    @Insert("insert into order values (#{id},#{order_time},#{total},#{uid})")
    public int insert(Order order);
}
