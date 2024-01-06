package com.example.mpdemo2.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mpdemo2.entity.GpsRecord;
import com.example.mpdemo2.entity.Order;
import com.example.mpdemo2.entity.User;
import com.example.mpdemo2.mapper.GpsRecordMapperPlus;
import com.example.mpdemo2.mapper.OrderMapper;
import com.example.mpdemo2.mapper.OrderMapperPlus;
//import com.example.mpdemo2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import lombok.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Transactional
@RestController
public class GpsRecordController {
    @Autowired
    private GpsRecordMapperPlus GpsRecordMapperPlus;

    @GetMapping("/GpsRecord")
    public List<GpsRecord> getGpsSpeedMin_Max(){
        return GpsRecordMapperPlus.selectList(null);
    }

}
