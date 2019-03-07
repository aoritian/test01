package com.owen;

import com.alibaba.fastjson.annotation.JSONField;
import com.owen.support.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tb_device")
public class Device extends BaseEntity {
    
    private static final long serialVersionUID = 1L;

    /**
     * 设备ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "device_sn")
    private String deviceSn;


    /**
     * 设备状态
     */
    private Integer status;


    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


    /**
     * 修改时间
     */
    @Column(name = "update_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 地址
     */
    private String location;


    /**
     * 硬件版本
     */
    @Column(name = "hardware_ver")
    private String hardwareVer;

    /**
     * 公司ID  String没写错
     */
    @Column(name = "group_id")
    private String groupId;

    /**
     * 删除字段
     */
    @Column(name = "delete_str")
    private Integer deleteStr;


    /**
     * 备注
     */
    private String remark;

    /**
     * 应用ID
     */
    @Column(name = "app_id")
    private Integer appId;


    /**
     * IP地址
     */
    private String ip;


    @ManyToMany(cascade = { CascadeType.REFRESH },fetch = FetchType.LAZY)
    @JoinTable(name = "tb_device_group", joinColumns = { @JoinColumn(name = "dgroup_id") }, inverseJoinColumns = { @JoinColumn(name = "group_id") })
    private java.util.Set<Group> groups;

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", deviceSn='" + deviceSn + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", location='" + location + '\'' +
                ", hardwareVer='" + hardwareVer + '\'' +
                ", groupId=" + groupId +
                ", deleteStr=" + deleteStr +
                ", remark='" + remark + '\'' +
                ", appId=" + appId +
                ", ip='" + ip + '\'' +
                '}';
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHardwareVer() {
        return hardwareVer;
    }

    public void setHardwareVer(String hardwareVer) {
        this.hardwareVer = hardwareVer;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Integer getDeleteStr() {
        return deleteStr;
    }

    public void setDeleteStr(Integer deleteStr) {
        this.deleteStr = deleteStr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
