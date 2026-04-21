package com.tms.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private String firstName;
    private String secondName;
    private int age;
    private LocalDateTime created;
    private LocalDateTime updated;
}
