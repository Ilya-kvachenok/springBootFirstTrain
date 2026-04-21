package com.tms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

    @GetMapping("/login/{param1}")
    public ModelAndView hello(@PathVariable("param1") int param1,
                        @RequestParam(value = "param2", required = false) String param2,
                        ModelAndView model) {
        model.setViewName("hello-page");
        model.addObject("firstParam", param1);
        model.addObject("secondParam", param2);
        return model;
    }
}
