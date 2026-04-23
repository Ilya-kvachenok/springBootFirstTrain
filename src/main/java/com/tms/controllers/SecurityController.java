package com.tms.controllers;

import com.tms.model.User;
import com.tms.model.dto.UserDto;
import com.tms.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/security") // Перед всеми путями методов этого контроллера будет стоять /security
public class SecurityController {

    private final SecurityService securityService;

    @Autowired
    public SecurityController (SecurityService securityService) {
        this.securityService = securityService;
    }

    @PostMapping("/registration")
    public ModelAndView hello(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName,
            @RequestParam(value = "age") int age,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password,
                        ModelAndView model) {

        try {
            UserDto createdUser = securityService.registration(firstName, lastName, age, username, password, email);
            model.addObject("user", createdUser);
            model.setViewName("success-registration");
            model.setStatus(HttpStatus.CREATED); // 201 CREATED
            return model;
        } catch (Exception exception) {
            model.setViewName("error-registration");
            model.addObject("exception", exception.getMessage());
            model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return model;
        }
    }
}
