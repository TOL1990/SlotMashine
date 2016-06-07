package com.spalah.cources.model.dao;

import com.spalah.cources.model.Line;
import com.spalah.cources.model.entity.Mashine;
import com.spalah.cources.model.entity.MashineBets;
import com.spalah.cources.model.entity.PayTable;

import java.util.List;

/**
 * Created by Тарас on 04.06.2016.
 */
public interface MashineDao {
    public List<MashineBets> avaliableBets(Mashine mashine) ;

    public int linesCount(Mashine mashine) ;

    /**
     * @param mashine - какой машины показать линии
     * @return список линий
     */
    public List<Line> getLines(Mashine mashine) ;

    public PayTable getPayTable(Mashine mashine) ;

    Mashine findById(long id);

    void saveMashine(Mashine mashine);

    void deleteMashineById(long id);

    List<Mashine> findAllMashines();



}
