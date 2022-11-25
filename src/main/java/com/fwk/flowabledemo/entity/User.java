package com.fwk.flowabledemo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Classname User
 * @Description TODO
 * @Date 2022/11/24 5:32 PM
 * @Created by fuwk
 */
public class User {

    private Long id;

    private String name;

    private Date date;

    private LocalDate ld;

    private LocalDateTime ldt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDate getLd() {
        return ld;
    }

    public void setLd(LocalDate ld) {
        this.ld = ld;
    }

    public LocalDateTime getLdt() {
        return ldt;
    }

    public void setLdt(LocalDateTime ldt) {
        this.ldt = ldt;
    }
}
