package com.example.mpdemo2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import javafx.scene.chart.PieChart;
import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


@TableName("t_order")
public class Order implements Serializable {
    @TableId(type = IdType.AUTO)
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("order_time")
    private String orderTime;
    private String total;
    private int uid;
    @TableField(exist = false)
    private User user;
    public Order() {
    }

    public Order(int id, String orderTime, String total, int uid, User user) {
        this.id = id;
        this.orderTime = orderTime;
        this.total = total;
        this.uid = uid;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_time=" + orderTime +
                ", total='" + total + '\'' +
                ", uid=" + uid +
                ", user=" + user +
                '}';
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public int getId() {
        return id;
    }

    public String getOrderTime() {
        return this.orderTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
