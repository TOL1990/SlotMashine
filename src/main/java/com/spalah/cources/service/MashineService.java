package com.spalah.cources.service;

import com.spalah.cources.model.Line;
import com.spalah.cources.model.entity.Mashine;
import com.spalah.cources.model.entity.MashineBets;

import java.util.List;
import java.util.Map;

/**
 * Created by Тарас on 04.06.2016.
 */
public interface MashineService {
    Mashine findById(int id);

    void saveMashine(Mashine mashine);

    void updateMashine(Mashine mashine);

    void deleteMashineById(long id);

    List<Mashine> findAllMashines();

    int[][] spin();

    String makeBet(Map<Line, Integer> betsMap);
    public List<MashineBets> avaliableBets(long mashine_id);

}
