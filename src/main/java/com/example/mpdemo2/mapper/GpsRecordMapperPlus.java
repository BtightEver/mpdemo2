package com.example.mpdemo2.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpdemo2.entity.GpsRecord;
import com.example.mpdemo2.entity.Order;
import com.example.mpdemo2.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GpsRecordMapperPlus extends BaseMapper<GpsRecord> {
}
