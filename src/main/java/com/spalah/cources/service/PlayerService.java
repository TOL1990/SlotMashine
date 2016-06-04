package com.spalah.cources.service;

import com.spalah.cources.model.entity.Player;

import java.util.List;

/**
 * Created by Тарас on 03.06.2016.
 */
public interface PlayerService {
    Player findById(int id);

    void savePlayer(Player player);

    void updatePlayer(Player player);

    void deletPlayerByNick(String nick);

    List<Player> findAllPlayers();

    Player findPlayerByNick(String nick);

    boolean isPlayerNickUnique(Long id, String nick);
}
