package com.example.mpdemo2.controller;
import com.example.mpdemo2.entity.DeviceCode;
import com.example.mpdemo2.entity.DeviceFile;
import com.example.mpdemo2.entity.Order;
import com.example.mpdemo2.entity.User;
import com.example.mpdemo2.mapper.DeviceCodeMapperPlus;
import com.example.mpdemo2.mapper.DeviceFileMapperPlus;
import com.example.mpdemo2.mapper.OrderMapper;
import com.example.mpdemo2.mapper.OrderMapperPlus;
//import com.example.mpdemo2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
@Transactional
@RestController
public class DeviceCodeController {
    @Autowired
    private DeviceCodeMapperPlus deviceCodeMapperPlus;

    @GetMapping("/DeviceCode")
    public List getDeviceFile(){
        List<DeviceCode> DeviceCodeList = deviceCodeMapperPlus.selectList(null);
        return  DeviceCodeList;
    }

}