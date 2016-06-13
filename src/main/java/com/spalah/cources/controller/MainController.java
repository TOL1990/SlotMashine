package com.spalah.cources.controller;

import com.spalah.cources.model.entity.Mashine;
import com.spalah.cources.model.entity.MashineBets;
import com.spalah.cources.model.entity.Player;
import com.spalah.cources.model.exception.PlayerException;
import com.spalah.cources.service.MashineService;
import com.spalah.cources.service.PlayerService;
import com.spalah.cources.service.RegEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @RequestMapping(value = {"/player/list"}, method = RequestMethod.GET)
    public String listPlayers(ModelMap model) {

        List<Player> players = playerService.findAllPlayers();
        model.addAttribute("players", players); // вывести в jsp так и не получилось в цикл
        System.out.println(players.toString());
        return "allplayers";
    }

    /**
     * Выводит список доступных слот машин
     * и возможные для них ставки
     * и количество доступных линий
     * Pay Тable для каждой слотмашины
     */
    @RequestMapping(value = {"/mashine/list"}, method = RequestMethod.GET)
    @ResponseBody
    public String listMashines(ModelMap model) {
        List<Mashine> mashines = mashineService.findAllMashines();
        System.out.println(mashines.toString());
        return mashines.toString();
    }

    ////////////////////  не доделанный  посмотреть как передавать  обычный Long в параметры
    @RequestMapping(value = "/test.form", method = RequestMethod.GET)
    public String listMashines(@RequestParam("mashineId") long mashineId, Model model) {
//        long mashineId = 1;// 1 - какой машины посмотреть доступные ставки
        List<MashineBets> bets = mashineService.avaliableBets(mashineId);
        model.addAttribute("hzbet", bets.get(1).getBet());
        return "hello";
    }

    /**
     * Выбрать линии, выбрать ставки для каждой из них
     * линия 1 - ставка 25$
     */

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newPlayer()
    {
        return "registration";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String newPlayer(@RequestBody Player player) throws PlayerException {
        Player newPlayer = playerService.findPlayerByNick(player.getNickName());
        if (newPlayer != null) throw new PlayerException("Nick name is already exist");
        if (!RegEx.nickChek(player.getNickName())) throw new PlayerException("Invalid nick name");
        else {
            playerService.savePlayer(player);
            newPlayer = playerService.findPlayerByNick(player.getNickName());
        }

        return "Hey! New Guy,  \n" + newPlayer.toString();
    }

    //    @RequestMapping(value = "/bet", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public String test(@RequestBody Player player) {
//        Player pl = playerService.findById(player.getId());
//        pl.setBallance(player.getBallance());
//        playerService.updatePlayer(pl);
//        return player.toString();
//    }
    @RequestMapping(value = "/bet", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String test(@RequestBody ResponseBet responseBet) {
//        String result = responseBet.getUserId() + "" + responseBet.getMashineId() + responseBet.getBets().toString();
        String result = null;
        try {
            result = mashineService.makeBet(responseBet.getMashineId(),
                    responseBet.getUserId(),
                    responseBet.getBets());
        } catch (PlayerException e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet()
    {

        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String login(@RequestBody Player player, Model model) throws PlayerException {
        Player newPlayer = playerService.findPlayerByNick(player.getNickName());
        if (newPlayer == null) throw new PlayerException("Invalid login");

        if (!newPlayer.getPassword().equals(player.getPassword())) throw new PlayerException("Invalid password");

        return "Wazzap " + player.getNickName();
    }

    @RequestMapping(value = "/zzz", method = RequestMethod.GET)
    @ResponseBody
    public String login() {

        Mashine mashine = mashineService.findById(1);
        System.out.println(mashine.getBets());

        System.out.println(mashine.getPayTable());

        System.out.println(mashine.getLines());
        return "zzz";
    }

}
