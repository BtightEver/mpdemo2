package com.example.mpdemo2.service;
import com.example.mpdemo2.entity.User;
import com.example.mpdemo2.mapper.UserMapperPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapperPlus userMapperPlus;
    @Cacheable("user")
    public User getUserById(int id) {
            return userMapperPlus.selectById(id);
    }
}