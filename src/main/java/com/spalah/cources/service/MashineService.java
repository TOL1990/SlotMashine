package com.spalah.cources.service;

import com.spalah.cources.model.entity.Line;
import com.spalah.cources.model.entity.Mashine;
import com.spalah.cources.model.entity.MashineBets;
import com.spalah.cources.model.exception.PlayerException;

import java.util.List;
import java.util.Map;

/**
 * Created by Тарас on 04.06.2016.
 */
public interface MashineService {
    Mashine findById(long id);

    void saveMashine(Mashine mashine);

    void updateMashine(Mashine mashine);

    void deleteMashineById(long id);

    List<Mashine> findAllMashines();

    int[][] spin();

    public String makeBet(long mashineId, long playerId, Map<Integer, Integer> betsMap) throws PlayerException;

    public List<MashineBets> avaliableBets(long mashine_id);

}
