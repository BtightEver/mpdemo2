package com.example.mpdemo2.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import javafx.scene.chart.PieChart;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.util.Date;

@TableName("public_code") // 指定实体类与数据库表的映射关系，表名为 "device_file"
public class DeviceCode {

    String type;
    String code;
    String content;
    String description;

    @Override
    public String toString() {
        return "DeviceCode{" +
                "type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public DeviceCode(String type, String code, String content, String description) {
        this.type = type;
        this.code = code;
        this.content = content;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
