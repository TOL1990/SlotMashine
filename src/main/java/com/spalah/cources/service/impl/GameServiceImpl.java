package com.spalah.cources.service.impl;

import com.spalah.cources.model.dao.PlayerDao;
import com.spalah.cources.service.GameService;
import com.spalah.cources.service.MashineService;
import com.spalah.cources.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Тарас on 04.06.2016.
 */
@Component
public class GameServiceImpl implements GameService {

    @Autowired
    MashineService mashineService;

    @Autowired
    PlayerService playerService;

    public void spin(){}


}
