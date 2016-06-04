package com.spalah.cources.service.impl;

import com.spalah.cources.model.Line;
import com.spalah.cources.model.dao.MashineDao;
import com.spalah.cources.model.entity.Mashine;
import com.spalah.cources.model.entity.PayTable;
import com.spalah.cources.service.MashineService;
import com.spalah.cources.service.PayTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    MashineDao mashineDao;

    public void makeBet(Map<List<Line>, Integer> betsMap){
        //принять линии и ставку на каждую из них
//        проверить являются ли ставки допустимыми
//        не привышает ли общая ставка денежный лимит игрока
    }

    public void spin(){
       // получить последнюю ставку
        // перемешать слоты
        //просчет результата
        //изменить баланс пользователя
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

    public Mashine findById(int id){return  null;}

    public void saveMashine(Mashine mashine){  }

    public  void updateMashine(Mashine Mashine){}

    public  void deleteMashineById(long id){}

    public List<Mashine> findAllMashines(){return  mashineDao.findAllMashines();}

}
