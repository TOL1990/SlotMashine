package com.spalah.cources.model.dao.impl;

import com.spalah.cources.model.dao.AbstractDao;
import com.spalah.cources.model.dao.PlayerDao;
import com.spalah.cources.model.entity.Player;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Leonid on 01.06.2016.
 */
@Component
//@Qualifier("test1")
public class PlayerDaoImpl extends AbstractDao<Long, Player> implements PlayerDao {

// получение сесси Я запихнул в    AbstractDao   метод getSession()
// @Autowired
//    private SessionFactory sessionFactory;

    public void test() {
        System.out.println("TEST FROM DAO");
        System.out.println(getSession() != null);
    }

    @Override
    public Player findById(Long id) {
        return getByKey(id);
    }

    @Override
    public void savePlayer(Player player) {
            persist(player);
    }

    @Override
    public void deletePlayerByNick(String nick) {
        Query query = getSession().createSQLQuery("delete from Player where nickName = :nick");
        query.setString("nick", nick);
        query.executeUpdate();
    }


    @SuppressWarnings("unchecked")
    public List<Player> findAllPlayers() {
        Criteria criteria = createEntityCriteria();
        return (List<Player>) criteria.list();
    }

    @Override
    public Player findPlayerByNick(String nickName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nickName", nickName));
        return (Player) criteria.uniqueResult();
    }


}
