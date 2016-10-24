package com.demo.web.model;

import org.joda.time.DateTime;

/**
 * Created by dxk on 2016/10/24.
 */
public class User {

    private Integer id;
    private String name;
    private DateTime createAt;

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

    public DateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(DateTime createAt) {
        this.createAt = createAt;
    }
}
