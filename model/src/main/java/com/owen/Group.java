package com.owen;

import com.alibaba.fastjson.annotation.JSONField;
import com.owen.support.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_group")
public class Group extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 公司id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 公司名
     */
    @Column(name = "group_name")
    private String name;

    /**
     * 公司电话
     */
    private Integer telephone;

    /**
     * 公司法人
     */
    private String guarantor;

    /**
     * 公司地址
     */
    private String location;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 是否删除
     */
    @Column(name = "delete_str")
    private Integer deletestr;

    /**
     * 备注
     */
    private String remark;

    /**
     * 法人用户ID
     */
    @Column(name = "gua_id")
    private Integer guaid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getGuarantor() {
        return guarantor;
    }

    public void setGuarantor(String guarantor) {
        this.guarantor = guarantor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDeletestr() {
        return deletestr;
    }

    public void setDeletestr(Integer deletestr) {
        this.deletestr = deletestr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getGuaid() {
        return guaid;
    }

    public void setGuaid(Integer guaid) {
        this.guaid = guaid;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone=" + telephone +
                ", guarantor='" + guarantor + '\'' +
                ", location='" + location + '\'' +
                ", createTime=" + createTime +
                ", deletestr=" + deletestr +
                ", remark='" + remark + '\'' +
                ", guaid=" + guaid +
                '}';
    }
}
