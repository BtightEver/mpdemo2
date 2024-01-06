package com.example.mpdemo2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mpdemo2.entity.Order;
import com.example.mpdemo2.entity.User;
import com.example.mpdemo2.mapper.OrderMapperPlus;
import com.example.mpdemo2.mapper.UserMapper;
import com.example.mpdemo2.mapper.UserMapperPlus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Wrapper;
import java.util.List;

@SpringBootTest
class Mpdemo2ApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("进入了测试类");
    }
    @Autowired
    private UserMapperPlus userMapperPlus;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapperPlus orderMapperPlus;
    @Test
    public void testOrderSelect() {
        System.out.println(("----- selectOrderAll method test ------"));
        List<Order> orderList = orderMapperPlus.selectList(null);
        orderList.forEach(System.out::println);
    }
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapperPlus.selectList(null);
        userList.forEach(System.out::println);
    }
    @Test
    public void testUpdate() {
        System.out.println(("----- update method test ------"));
        List<User> userList = userMapperPlus.selectList(null);
        userList.forEach(System.out::println);
    }
    @Test
    public void testPersonSerialization() throws IOException, ClassNotFoundException {
        // 创建一个Person对象
        Person person = new Person("Tom", 25);

        // 将Person对象写入文件
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            out.writeObject(person);
        }

        // 从文件中读取Person对象
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person p = (Person) in.readObject();
            assertEquals(p.getName(), "Tom");
            assertEquals(p.getAge(), 25);
        }
    }
}
