package com.spalah.cources.model.dao.impl;

import com.spalah.cources.model.dao.AbstractDao;
import com.spalah.cources.model.dao.BetDao;
import com.spalah.cources.model.entity.Mashine;
import com.spalah.cources.model.entity.MashineBets;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Тарас on 07.06.2016.
 */
@Component
public class BetDaoImpl extends AbstractDao<Long, MashineBets> implements BetDao {
    public MashineBets findById(Long id) {
        return getByKey(id);
    }

    public void saveMashineBet (MashineBets mashineBets) {
        persist(mashineBets);
    }


    @SuppressWarnings("unchecked")
    public List<MashineBets> getBetsByMashine(Mashine mashine) {
        List<MashineBets> bets = new ArrayList<>();
        Session s = getSession();
        s.beginTransaction();
        Query query = s.createQuery("from MashineBets where mashine.getId():=id").setLong("id", mashine.getId());
        bets = (List<MashineBets>) query.list();
        s.close();
        return bets;
    }

}
