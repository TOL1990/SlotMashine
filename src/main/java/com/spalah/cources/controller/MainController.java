package com.spalah.cources.controller;

import com.spalah.cources.model.dao.IPlayerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Leonid on 01.06.2016.
 */
@Controller
public class MainController {
    @Autowired
    @Qualifier("test1")
    private IPlayerDao iPlayerDao;

    @RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String test() {
        System.out.println("TEST FROM CONTROLLER");
        iPlayerDao.test();
        return "test";
    }
}
