package com.example.mpdemo2.controller;
import com.example.mpdemo2.entity.DeviceFile;
import com.example.mpdemo2.entity.Order;
import com.example.mpdemo2.entity.User;
import com.example.mpdemo2.mapper.DeviceFileMapperPlus;
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
public class DeviceFileController {
    private static final Logger logger = LoggerFactory.getLogger(DeviceFileController.class);
    @Autowired
    private DeviceFileMapperPlus deviceFileMapperPlus;

    @GetMapping("/DeviceFile")
    public List getDeviceFile(){
        List<DeviceFile> DeviceFileList = deviceFileMapperPlus.selectList(null);
        return  DeviceFileList;
    }

    @GetMapping("/DeviceFile/{id}")
    public DeviceFile getDeviceFileById(@PathVariable Long id){
        System.out.println("获取到的id是"+id);
        return deviceFileMapperPlus.selectById(id);
    }
    @DeleteMapping("/DeviceFile/{id}")
    public void deleteDeviceFileById(@PathVariable Long id){
        System.out.println("获取到的id是"+id);
        deviceFileMapperPlus.deleteById(id);
    }
    @PostMapping("/DeviceFile")
    public String addDeviceFile(@RequestBody DeviceFile devicefile){
            devicefile.setDeviceId(devicefile.getDeviceType()+devicefile.getImgUrl());
            System.out.println("deviceid是:"+devicefile.getDeviceId());
            int re = deviceFileMapperPlus.insert(devicefile);
            if(re>0)
                return "插入成功";
             return "插入失败";
    }
    @PutMapping("/DeviceFile")
    public String updateDeviceFile(@RequestBody DeviceFile devicefile){
        int result = deviceFileMapperPlus.updateById(devicefile);
        if (result > 0) {
            return "更新成功";
        } else {
            return "更新失败";
        }
    }
}
