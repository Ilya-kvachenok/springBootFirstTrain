package com.tms.services;

import com.tms.model.dto.UserDto;
import com.tms.repository.SecurityRepostiroty;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityService {
    private final SecurityRepostiroty securityRepostiroty;

    public SecurityService (SecurityRepostiroty securityRepostiroty) {
        this.securityRepostiroty = securityRepostiroty;
    }

    public Optional<UserDto> registration(String firstName, String secondName, int age, String username, String password) {
        return Optional.ofNullable(securityRepostiroty.registration(firstName, secondName, age, username, password));
    }
}
