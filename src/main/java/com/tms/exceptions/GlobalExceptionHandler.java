package com.tms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice // Глобальный обработчик исключений
public class GlobalExceptionHandler {

    @ExceptionHandler(AgeException.class)
    public ModelAndView AgeExceptionHandler(AgeException ex) {
        System.out.println("Age exception: " + ex.getMessage());
        ModelAndView model = new ModelAndView();
        model.setViewName("error");
        model.setStatus(HttpStatus.BAD_REQUEST);
        model.addObject("exception", ex);
        return model;
    }
}
