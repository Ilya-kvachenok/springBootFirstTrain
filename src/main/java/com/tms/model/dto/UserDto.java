package com.tms.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
}
