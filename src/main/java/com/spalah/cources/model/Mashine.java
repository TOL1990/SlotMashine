package com.spalah.cources.model;


import com.spalah.cources.model.entity.User;

import java.util.List;

public class Mashine {
    List<Line> lines; //перечень линий доступных для игры
    Board drums; // наше игровое поле. Барабаны
    User player;
    List<Bet> bets; // Описывает ставки сделанные игроком

    public void spin(){}
    public void checkResult(){}
    public void showAvalialeLines(){}


}
