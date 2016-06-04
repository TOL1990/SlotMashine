package com.spalah.cources.service.impl;

import com.spalah.cources.model.dao.PlayerDao;
import com.spalah.cources.model.entity.Player;
import com.spalah.cources.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Тарас on 03.06.2016.
 */
@Component
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerDao dao;


    public Player findById(int id)
    {
        return dao.findById(id);
    }

    public void savePlayer(Player player){
        dao.savePlayer(player);
    }

    public void updatePlayer (Player player) {
        Player entity = dao.findById((int) player.getId());
        if (entity != null) {
            entity.setNickName(player.getNickName());
            entity.setPassword(player.getPassword());
            entity.setBallance(player.getBallance());
        }
    }
    public void deletPlayerByNick (String nick){ dao.deletePlayerByNick(nick);}

    @Override
    public List<Player> findAllPlayers () {
        return dao.findAllPlayers();
    }

    @Override
    public Player findPlayerByNick (String nick){
        return dao.findPlayerByNick(nick);
    }

    @Override
    public boolean isPlayerNickUnique (Long id, String nick){
        Player player = findPlayerByNick(nick);
        return ( player == null || ((id != null) && (player.getId() == id)));
    }
}
