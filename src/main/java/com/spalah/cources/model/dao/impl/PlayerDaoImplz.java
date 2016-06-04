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

import java.util.List;

/**
 * Created by Leonid on 01.06.2016.
 */
@Component
//@Qualifier("test1")
public class PlayerDaoImplz extends AbstractDao<Integer, Player> implements PlayerDao {

// получение сесси Я запихнул в    AbstractDao   метод getSession()
// @Autowired
//    private SessionFactory sessionFactory;

    public void test() {
        System.out.println("TEST FROM DAO");
        System.out.println(getSession() != null);
    }

    @Override
    public Player findById(int id) {
        return null;
    }

    @Override
    public void savePlayer(Player player) {

    }

    @Override
    public void deletePlayerByNick(String nick) {

    }

//    public Player findById(int id) {
//        return getByKey(id);
//    }
//
//    public void savePlayer(Player player) {
//        persist(player);
//    }
//
//    public void deletePlayerByNick(String nick) {
//        Query query = getSession().createSQLQuery("delete from Player where nick = :nick");
//        query.setString("nick", nick);
//        query.executeUpdate();
//    }

    @SuppressWarnings("unchecked")
    public List<Player> findAllPlayers() {
//        Session session = sessionFactory.getCurrentSession();
//        Criteria criteria = session.createCriteria(Player.class);
        Criteria criteria = createEntityCriteria();
        return (List<Player>) criteria.list();
    }

    @Override
    public Player findPlayerByNick(String nick) {
        return null;
    }

//    public Player findPlayerByNick(String nick) {
//        Criteria criteria = createEntityCriteria();
//        criteria.add(Restrictions.eq("nick", nick));
//        return (Player) criteria.uniqueResult();
//    }
}
