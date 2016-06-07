package com.spalah.cources.model.dao;

import com.spalah.cources.model.entity.Player;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Leonid on 01.06.2016.
 */
public interface PlayerDao {
    void test();

    Player findById(Long id);

    void savePlayer(Player player);

    void deletePlayerByNick(String nick);

    List<Player> findAllPlayers();

    Player findPlayerByNick(String nick);

    void update(Player player);
}
