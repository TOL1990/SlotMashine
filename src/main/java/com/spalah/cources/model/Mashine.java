package com.spalah.cources.model;


import com.spalah.cources.model.entity.Player;

import java.util.List;

public class Mashine {
    List<Line> lines; //перечень линий доступных для игры
    Board drums; // наше игровое поле. Барабаны
    Player player;
    List<Bet> bets; // Описывает ставки сделанные игроком

    public void spin(){}
    public void checkResult(){}
    public void showAvalialeLines(){}


}
