package com.example.mpdemo2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpdemo2.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapperPlus extends BaseMapper<User>  {

}
