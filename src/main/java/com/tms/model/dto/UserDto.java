package com.tms.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private String firstName;
    private String secondName;
    private int age;
}
