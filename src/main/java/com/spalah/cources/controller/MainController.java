package com.spalah.cources.controller;

import com.spalah.cources.model.entity.Mashine;
import com.spalah.cources.model.entity.Player;
import com.spalah.cources.service.MashineService;
import com.spalah.cources.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Leonid on 01.06.2016.
 */
@Controller
public class MainController {

/*  Так все работает Женин пример
  @Autowired
    @Qualifier("test1")
    private PlayerDao playerDao;


    @RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String test() {
        System.out.println("TEST FROM CONTROLLER");
        playerDao.test();
        return "test";
    }*/

    @Autowired
    PlayerService playerService;

    @Autowired
    MashineService mashineService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listPlayers(ModelMap model) {

        List<Player> players = playerService.findAllPlayers();
        model.addAttribute("players", players); // вывести в jsp так и не получилось в цикл
        System.out.println(players.toString());
        return "allplayers";
    }

    /**Выводит список доступных слот машин
     *и возможные для них ставки
     * и количество доступных линий
     * Pay Тable для каждой слотмашины
     */
    @RequestMapping(value = {"/mashines"}, method = RequestMethod.GET)
    @ResponseBody
         public String listMashines(ModelMap model) {
        List<Mashine> mashines = mashineService.findAllMashines();
        System.out.println(mashines.toString());
        return mashines.toString();
    }
    /**Выбрать линии, выбрать ставки для каждой из них
     * линия 1 - ставка 25$
     */
    @RequestMapping(value = {"/bet"}, method = RequestMethod.GET)
    public void bet() {
    }
}
