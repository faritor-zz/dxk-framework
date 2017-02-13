package com.demo.model;

import java.io.Serializable;

/**
 * Created by dxk on 2017/1/12.
 */
public class Channel implements Serializable{

    private static final long serialVersionUID = -6701403080176091727L;
    private Integer id;
    private String depart; //部门
    private String clazz;  //大类
    private String section;  //小类
    private String channelName;  //渠道中文名
    private String channelNo;  //渠道号
    private String description;  //进件渠道描述

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", depart='" + depart + '\'' +
                ", clazz='" + clazz + '\'' +
                ", section='" + section + '\'' +
                ", channelName='" + channelName + '\'' +
                ", channelNo='" + channelNo + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
