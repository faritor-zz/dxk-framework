package com.demo.web.vo;

import java.util.Date;

/**
 * Created by dxk on 2016/12/2.
 */
public class UserVo {

    private Integer id;
    private String name;
    private Date createAt;

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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
