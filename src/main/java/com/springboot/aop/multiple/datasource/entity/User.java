package com.springboot.aop.multiple.datasource.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class User {
    private Long userId;

    private String userName;

    private String userPhone;

    private String address;

    private Integer weight;

    private Date createdAt;

    private Date updatedAt;
}
