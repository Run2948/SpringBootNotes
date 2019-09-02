package com.borun.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Person {

    private int id;

    private String name;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
