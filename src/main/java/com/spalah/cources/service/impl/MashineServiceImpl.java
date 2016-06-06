package com.spalah.cources.service.impl;

import com.spalah.cources.model.Board;
import com.spalah.cources.model.Line;
import com.spalah.cources.model.dao.MashineDao;
import com.spalah.cources.model.entity.Mashine;
import com.spalah.cources.model.entity.Player;
import com.spalah.cources.service.MashineService;
import com.spalah.cources.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by Тарас on 04.06.2016.
 */
@Component
public class MashineServiceImpl implements MashineService {

//    @Autowired
//    PayTableService payTableService;
    @Autowired
    PlayerService playerService;

    @Autowired
    MashineDao mashineDao;

    public String makeBet(Map<Line, Integer> betsMap) {
        BigDecimal result = null;
//        Player player = new Player(); //Наш игрок бабло которого меняется
        Player player = playerService.findById(1);
        if (chekValid(betsMap)) {
            int[][] drum = spin();
            result = chekResult(betsMap, drum);
            player.setBallance(player.getBallance().add(result));
            playerService.updatePlayer(player);
        }
        return result.toString();
    }

    private BigDecimal chekResult(Map<Line, Integer> betsMap, int[][] drum) {

        // получитьколичество точек линии,
        // карту выиграшей для конкретной машины

        for (Map.Entry<Line, Integer> entry : betsMap.entrySet())
        {
            Line line = entry.getKey();
            Integer value = entry.getValue();
//действия с ключом и значением
        }
//        return null;
        return new BigDecimal(-100); // Хоть функция и тестовая но будем сжирать у тебя бабло а не докидывать
    }

    private boolean chekValid(Map<Line, Integer> betsMap) {
        //проверить хватает ли денег на ставки. 
        //являются ли ставки допустимыми соответствующей слот машине
        return true;
    }

    public int[][] spin() {

        Board board = new Board();
        board.spin();
        return board.getDrum();

    }

    /**
     * Доступные ставки на конкретной машине
     */
    public int[] avaliableBets(Mashine mashine) {
        return null;
    }

    public int linesCount(Mashine mashine) {
        return 0;
    }

    /**
     * @param mashine - какой машины показать линии
     * @return список линий
     */
    public List<Line> getLines(Mashine mashine) {
        return null;
    }

//    public PayTable getPayTable(Mashine mashine) {
//        PayTable tab = payTableService.getPayTable(mashine);
//        return tab;
//    }

    public Mashine findById(int id) {
        return null;
    }

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
