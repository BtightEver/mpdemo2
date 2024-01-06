package com.example.mpdemo2.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mpdemo2.entity.Order;
import com.example.mpdemo2.entity.User;
import com.example.mpdemo2.mapper.UserMapper;
import com.example.mpdemo2.mapper.UserMapperPlus;
import com.example.mpdemo2.service.UserService;
import com.example.mpdemo2.utils.JwtUtils;
import io.jsonwebtoken.Jwt;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mpdemo2.utils.Result;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {

        @Autowired
        private UserMapper userMapper;
        @Autowired
        private UserMapperPlus userMapperPlus;
        @Autowired
        private UserService userService;



    @PostMapping("/login")
        public Result login(@RequestBody User user){
            String token = JwtUtils.generateToken(user.getUsername());
            return Result.ok().data("token",token);
        }
        @GetMapping("/info")
        public Result info(String token){
            String username= JwtUtils.getClaimsByTokens(token).getSubject();
            String url="https://lmg.jj20.com/up/allimg/1113/051220112022/200512112022-1-1200.jpg";
            return Result
                    .ok().data("name",username).data("avatar",url);
        }


        @GetMapping("/user")
        public IPage query(){
            Page<User> page = new Page<>(0, 2);  // 0表示页数，2表示每页多少个
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("username","王");
            IPage ipage = userMapperPlus.selectPage(page, queryWrapper);
            System.out.println(ipage);
            return ipage;
        }
/*        @GetMapping("/user")
        public List query() {
            List<User> users = userMapper.find();
            System.out.println(users);
            return users;
        }*/
        @GetMapping("/userAndOrder")
        public List queryAll(){
            List<User> users=userMapper.selectAllUserAndOrders();
            System.out.println(users);
            return users;
        }
        @PostMapping("/user")
        public String insertInController(User user){
            int re=userMapper.insert(user);
            if(re>0) return "插入成功";
            return "插入失败";
        }

        @GetMapping("/users/{id}")
        public User getUser(@PathVariable int id) {

            return userService.getUserById(id);
        }
        @GetMapping("/test")
        public String test(User user){
            return "访问成功";
        }
}
