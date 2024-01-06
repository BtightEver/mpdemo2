package com.example.mpdemo2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
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

@TableName("device_file") // 指定实体类与数据库表的映射关系，表名为 "device_file"
public class DeviceFile {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("parent_id") // 表示该属性与数据库表中的 "parent_id" 列对应
    private String parentId;

    @TableField("object_id")
    private String objectId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @TableField("company_id")
    private String companyId;

    @TableField("group_id")
    private String groupId;

    @TableField("project_id")
    private String projectId;

    @TableField("device_id")
    private String deviceId;

    @TableField("device_name")
    private String deviceName;

    @TableField("device_type")
    private String deviceType;

    @TableField("device_sub_type")
    private String deviceSubType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("limit_time")
    private String limitTime;

    @TableField("qrcode_url")
    private String qrcodeUrl;

    @TableField("qrcode_file")
    private String qrcodeFile;

    @TableField("qrcode_content")
    private String qrcodeContent;

    @TableField("version")
    private String version;

    @TableField("admin_person")
    private String adminPerson;

    public String getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress;
    }

    @TableField("admin_person_phone")
    private String adminPersonPhone;

    @TableField("device_address")
    private String deviceAddress;

    @TableField("longitude")
    private String longitude;

    @TableField("latitude")
    private String latitude;


    @TableField("install_person")
    private String installPerson;

    @TableField("install_person_phone")
    private String installPersonPhone;

    @TableField("install_status")
    private String installStatus;

    @TableField("check_tag")
    private Integer checkTag;

    @TableField("checker")
    private String checker;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("check_time")
    private String checkTime;

    @TableField("used_tag")
    private Boolean usedTag;

    @TableField("creator_id")
    private String creatorId;

    @TableField("creator")
    private String creator;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private String createTime;

    @TableField("img_url")
    private String imgUrl;

    public DeviceFile(Long id, String parentId, String objectId, String companyId, String groupId, String projectId, String deviceId, String deviceName, String deviceType, String deviceSubType, String limitTime, String qrcodeUrl, String qrcodeFile, String qrcodeContent, String version, String adminPerson, String adminPersonPhone, String deviceAddress, String longitude, String latitude, String installPerson, String installPersonPhone, String installStatus, Integer checkTag, String checker, String checkTime, Boolean usedTag, String creatorId, String creator, String createTime, String imgUrl) {
        this.id = id;
        this.parentId = parentId;
        this.objectId = objectId;
        this.companyId = companyId;
        this.groupId = groupId;
        this.projectId = projectId;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.deviceSubType = deviceSubType;
        this.limitTime = limitTime;
        this.qrcodeUrl = qrcodeUrl;
        this.qrcodeFile = qrcodeFile;
        this.qrcodeContent = qrcodeContent;
        this.version = version;
        this.adminPerson = adminPerson;
        this.adminPersonPhone = adminPersonPhone;
        this.deviceAddress = deviceAddress;
        this.longitude = longitude;
        this.latitude = latitude;
        this.installPerson = installPerson;
        this.installPersonPhone = installPersonPhone;
        this.installStatus = installStatus;
        this.checkTag = checkTag;
        this.checker = checker;
        this.checkTime = checkTime;
        this.usedTag = usedTag;
        this.creatorId = creatorId;
        this.creator = creator;
        this.createTime = createTime;
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
// 省略构造方法、Getter和Setter方法


    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceSubType() {
        return deviceSubType;
    }

    public void setDeviceSubType(String deviceSubType) {
        this.deviceSubType = deviceSubType;
    }

    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    public String getQrcodeFile() {
        return qrcodeFile;
    }

    public void setQrcodeFile(String qrcodeFile) {
        this.qrcodeFile = qrcodeFile;
    }

    public String getQrcodeContent() {
        return qrcodeContent;
    }

    public void setQrcodeContent(String qrcodeContent) {
        this.qrcodeContent = qrcodeContent;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAdminPerson() {
        return adminPerson;
    }

    public void setAdminPerson(String adminPerson) {
        this.adminPerson = adminPerson;
    }

    public String getAdminPersonPhone() {
        return adminPersonPhone;
    }

    public void setAdminPersonPhone(String adminPersonPhone) {
        this.adminPersonPhone = adminPersonPhone;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }



    public String getInstallPerson() {
        return installPerson;
    }

    public void setInstallPerson(String installPerson) {
        this.installPerson = installPerson;
    }

    public String getInstallPersonPhone() {
        return installPersonPhone;
    }

    public void setInstallPersonPhone(String installPersonPhone) {
        this.installPersonPhone = installPersonPhone;
    }

    public String getInstallStatus() {
        return installStatus;
    }

    public void setInstallStatus(String installStatus) {
        this.installStatus = installStatus;
    }

    public Integer getCheckTag() {
        return checkTag;
    }

    public void setCheckTag(Integer checkTag) {
        this.checkTag = checkTag;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public Boolean getUsedTag() {
        return usedTag;
    }

    public void setUsedTag(Boolean usedTag) {
        this.usedTag = usedTag;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DeviceFile{" +
                ", parentId='" + parentId + '\'' +
                ", objectId='" + objectId + '\'' +
                ", companyId='" + companyId + '\'' +
                ", groupId='" + groupId + '\'' +
                ", projectId='" + projectId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", deviceSubType='" + deviceSubType + '\'' +
                ", limitTime=" + limitTime +
                ", qrcodeUrl='" + qrcodeUrl + '\'' +
                ", qrcodeFile='" + qrcodeFile + '\'' +
                ", qrcodeContent='" + qrcodeContent + '\'' +
                ", version='" + version + '\'' +
                ", adminPerson='" + adminPerson + '\'' +
                ", adminPersonPhone='" + adminPersonPhone + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", installPerson='" + installPerson + '\'' +
                ", installPersonPhone='" + installPersonPhone + '\'' +
                ", installStatus='" + installStatus + '\'' +
                ", checkTag=" + checkTag +
                ", checker='" + checker + '\'' +
                ", checkTime=" + checkTime +
                ", usedTag=" + usedTag +
                ", creatorId='" + creatorId + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", imgUrl=" + imgUrl +
                '}';
    }
}