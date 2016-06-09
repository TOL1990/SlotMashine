package com.spalah.cources.service.impl;

import com.spalah.cources.model.Board;
import com.spalah.cources.model.dao.BetDao;
import com.spalah.cources.model.dao.LineDao;
import com.spalah.cources.model.dao.MashineDao;
import com.spalah.cources.model.entity.*;
import com.spalah.cources.service.MashineService;
import com.spalah.cources.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Тарас on 04.06.2016.
 */
@Component
public class MashineServiceImpl implements MashineService {

    public final int MIN_PAY_TABLE_ICONS_COUNT = 3;//минимально количество иконок за которое дают награду

    //    @Autowired
//    PayTableService payTableService;
    @Autowired
    PlayerService playerService;

    @Autowired
    MashineDao mashineDao;

    @Autowired
    BetDao betDao;

    @Autowired
    LineDao lineDao;

    public String makeBet(long mashineId, long playerId, Map<Integer, Integer> incomingMap) {
        BigDecimal result = null;
        Player player = playerService.findById(playerId);
        Mashine mashine = mashineDao.findById(mashineId);

        //переделаем в мапу линий
        Map<Line, Integer> betsMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : incomingMap.entrySet()) {
            int lineId = entry.getKey();
            int bet = entry.getValue();

            Line line = lineDao.findById((long) lineId);
            betsMap.put(line, bet);
        }



        if (chekValid(mashine, player, betsMap)) {
            int[][] drum = spin();

            result = chekResult(betsMap, drum, mashine.getPayTable());
            player.setBallance(player.getBallance().add(result));
            playerService.updatePlayer(player);
        }
        return result.toString();
    }

    private BigDecimal chekResult(Map<Line, Integer> betsMap, int[][] drum, PayTable payTable) {

        BigDecimal result = new BigDecimal(0);

        for (Icon icon : payTable.getIcons()) {

        }

        //пройдемся по всем значениям и заберем деньги на ставку
        for (Map.Entry<Line, Integer> entry : betsMap.entrySet()) {
            Line line = entry.getKey();
            int bet = entry.getValue();
//            BigDecimal betForLine = BigDecimal.valueOf(bet * line.getPoints().size()); // ставка на линию ()
            int betForLine = line.getPoints().size() * bet;
            result.subtract(BigDecimal.valueOf(betForLine));
        }

        for (Map.Entry<Line, Integer> entry : betsMap.entrySet()) {
            Line line = entry.getKey();
            Integer bet = entry.getValue();

            //массив в который соберутьсязначения иконок сгенеренного барабана[1,2,2,2,2,5]
            ArrayList<Integer> iconsLine = new ArrayList<>();

            //пройдемся по точкам линии и запишем их соответствие с барабаном в iconsLine
            for (LinePoint p : line.getPoints()) {
                int coll = p.getColl();
                int row = p.getRow();
                iconsLine.add(drum[coll][row]);
            }

            int tempWinCount = 1; // для подсчета иконок совпадений
            int tempWinNumber = 0; // какие иконки соберут больше 3-х подряд
            for (int i = 0; i < iconsLine.size() - 1; i++) {
                if (iconsLine.get(i) == iconsLine.get(i + 1))
                    tempWinCount++;
                if (tempWinCount >= MIN_PAY_TABLE_ICONS_COUNT)
                    tempWinNumber = iconsLine.get(i);
            }
            //tempWinNumber = 3  ,   tempWinCount = 4;

            // проверяем что за такой аналог дают по PayTable
            BigDecimal multiplierIcon = new BigDecimal(0);//на сколько умножать выиграшную ставку
            if (tempWinCount >= MIN_PAY_TABLE_ICONS_COUNT) {//если количество картинок больше 3, узнаем Хсколько дадут
                Icon icon = payTable.getIcons().get(tempWinNumber);
                for (PayIcon p : icon.getPayIcons()) {
                    if (p.getImageCount() == tempWinCount) {
                        multiplierIcon = p.getAwards();
                    }
                }
                //результат + (ставка_на_точку_линии * награда_по_Pay_Table)
                result.add(multiplierIcon.multiply(BigDecimal.valueOf(bet)));
            }
        }
//действия с ключом и значением

        return result;
//        return new BigDecimal(-100); // Хоть функция и тестовая но будем сжирать у тебя бабло а не докидывать
    }

    private boolean chekValid(Mashine mashine,Player player, Map<Line, Integer> betsMap) {
        //проверить хватает ли денег на ставки.

        //являются ли ставки допустимыми соответствующей слот машине
        //PS будем ставки передавать из чекбоксов формы. не нужно проверять
        BigDecimal playerBallance = player.getBallance();
        for (Map.Entry<Line, Integer> entry : betsMap.entrySet()) {
            Line line = entry.getKey();
            int bet = entry.getValue();
            int betForLine = line.getPoints().size() * bet;
            playerBallance.subtract(BigDecimal.valueOf(betForLine));
        }
        if (playerBallance.signum() == 1)  // возвращает (-1 если a < 0), (0 если a == 0), (1 если a > 0)
         return true;
       else return false;
    }

    public int[][] spin() {

        Board board = new Board();
        board.spin();
        return board.getDrum();

    }

    /**
     * Доступные ставки на конкретной машине
     */
    public List<MashineBets> avaliableBets(long mashine_id) {
        Mashine mashine = mashineDao.findById(mashine_id);
        System.out.println(mashine.getBets().toString());
        return mashine.getBets();
    }

    public int linesCount(Mashine mashine) {
        return 0;
    }


    public List<Line> getLines(long mashine_id) {
        Mashine mashine = mashineDao.findById(mashine_id);
        System.out.println(mashine.getBets().toString());
        return mashine.getLines();
    }

    public Mashine findById(long id) {return mashineDao.findById(id);    }

    public void saveMashine(Mashine mashine) {
    }

    public void updateMashine(Mashine Mashine) {
    }

    public void deleteMashineById(long id) {
    }

    public List<Mashine> findAllMashines() {
        return mashineDao.findAllMashines();
    }

}
