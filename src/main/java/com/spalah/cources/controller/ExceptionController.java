package com.spalah.cources.controller;

import com.spalah.cources.model.exception.PlayerException;
import com.spalah.cources.service.messages.ErMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Тарас on 09.06.2016.
 */
@ControllerAdvice  //будет перехватывать все исключения
public class ExceptionController {



//    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Bad filename")
    @ExceptionHandler(PlayerException.class)
    public ModelAndView accountException(PlayerException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", ex.getMessage());
        return modelAndView;
    }




}
