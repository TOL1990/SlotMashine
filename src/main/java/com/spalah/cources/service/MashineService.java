package com.spalah.cources.service;

import com.spalah.cources.model.entity.Mashine;
import com.spalah.cources.model.entity.Player;

import java.util.List;

/**
 * Created by Тарас on 04.06.2016.
 */
public interface MashineService {
    Mashine findById(int id);

    void saveMashine(Mashine mashine);

    void updateMashine(Mashine mashine);

    void deleteMashineById(long id);

    List<Mashine> findAllMashines();


}
