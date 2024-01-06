package com.example.mpdemo2.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
@TableName("gps_history")
public class GpsRecord {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("device_id")
    private String deviceId;

    @TableField("device_type")
    private String deviceType;

    @TableField("unit_id")
    private String unitId;

    @TableField("gps_time")
    private Date gpsTime;

    @TableField("recv_time")
    private Date recvTime;

    @TableField("longitude")
    private Double longitude;

    @TableField("latitude")
    private Double latitude;

    @TableField("altitude")
    private Integer altitude;

    @TableField("speed")
    private Double speed;

    @TableField("direction")
    private Integer direction;

    @TableField("location")
    private String location;

    @TableField("data_source")
    private String dataSource;

    @TableField("alarm")
    private Integer alarm;

    @TableField("segment")
    private Integer segment;

    @TableField("area")
    private Integer area;

    @TableField("status")
    private Integer status;

    @TableField("status_debug")
    private Integer statusDebug;

    @TableField("alarm_type")
    private Integer alarmType;

    @TableField("energy")
    private Integer energy;

    @TableField("checked_tag")
    private Integer checkedTag;

    @TableField("checker")
    private String checker;

    @TableField("check_time")
    private Date checkTime;

    @TableField("coordinate_type")
    private String coordinateType;

    @TableField("creator")
    private String creator;

    @TableField("creator_id")
    private String creatorId;

    @TableField("create_time")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public Date getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(Date gpsTime) {
        this.gpsTime = gpsTime;
    }

    public Date getRecvTime() {
        return recvTime;
    }

    public void setRecvTime(Date recvTime) {
        this.recvTime = recvTime;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public Integer getAlarm() {
        return alarm;
    }

    public void setAlarm(Integer alarm) {
        this.alarm = alarm;
    }

    public Integer getSegment() {
        return segment;
    }

    public void setSegment(Integer segment) {
        this.segment = segment;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatusDebug() {
        return statusDebug;
    }

    public void setStatusDebug(Integer statusDebug) {
        this.statusDebug = statusDebug;
    }

    public Integer getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(Integer alarmType) {
        this.alarmType = alarmType;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public Integer getCheckedTag() {
        return checkedTag;
    }

    public void setCheckedTag(Integer checkedTag) {
        this.checkedTag = checkedTag;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCoordinateType() {
        return coordinateType;
    }

    public void setCoordinateType(String coordinateType) {
        this.coordinateType = coordinateType;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public GpsRecord(Long id, String deviceId, String deviceType, String unitId, Date gpsTime, Date recvTime, Double longitude, Double latitude, Integer altitude, Double speed, Integer direction, String location, String dataSource, Integer alarm, Integer segment, Integer area, Integer status, Integer statusDebug, Integer alarmType, Integer energy, Integer checkedTag, String checker, Date checkTime, String coordinateType, String creator, String creatorId, Date createTime) {
        this.id = id;
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.unitId = unitId;
        this.gpsTime = gpsTime;
        this.recvTime = recvTime;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.speed = speed;
        this.direction = direction;
        this.location = location;
        this.dataSource = dataSource;
        this.alarm = alarm;
        this.segment = segment;
        this.area = area;
        this.status = status;
        this.statusDebug = statusDebug;
        this.alarmType = alarmType;
        this.energy = energy;
        this.checkedTag = checkedTag;
        this.checker = checker;
        this.checkTime = checkTime;
        this.coordinateType = coordinateType;
        this.creator = creator;
        this.creatorId = creatorId;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "GpsRecord{" +
                "id=" + id +
                ", deviceId='" + deviceId + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", unitId='" + unitId + '\'' +
                ", gpsTime=" + gpsTime +
                ", recvTime=" + recvTime +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", altitude=" + altitude +
                ", speed=" + speed +
                ", direction=" + direction +
                ", location='" + location + '\'' +
                ", dataSource='" + dataSource + '\'' +
                ", alarm=" + alarm +
                ", segment=" + segment +
                ", area=" + area +
                ", status=" + status +
                ", statusDebug=" + statusDebug +
                ", alarmType=" + alarmType +
                ", energy=" + energy +
                ", checkedTag=" + checkedTag +
                ", checker='" + checker + '\'' +
                ", checkTime=" + checkTime +
                ", coordinateType='" + coordinateType + '\'' +
                ", creator='" + creator + '\'' +
                ", creatorId='" + creatorId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}