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


    public Player findById(long id)
    {
        return dao.findById(id);
    }

    public void savePlayer(Player player){
        dao.savePlayer(player);
    }

    /*
 * Since the method is running with Transaction, No need to call hibernate update explicitly.
 * Just fetch the entity from db and update it with proper values within transaction.
 * It will be updated in db once transaction ends.
 */
    public void updatePlayer (Player player) {
        Player entity = dao.findById((long) player.getId());
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
