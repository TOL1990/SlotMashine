package com.spalah.cources.controller;

import com.spalah.cources.model.exception.PlayerException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Тарас on 09.06.2016.
 */
@ControllerAdvice  //будет перехватывать все исключения
public class ExceptionController {


    @ExceptionHandler(PlayerException.class)
    public ModelAndView accountException(PlayerException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", ex.getMessage());
        return modelAndView;
    }


}
