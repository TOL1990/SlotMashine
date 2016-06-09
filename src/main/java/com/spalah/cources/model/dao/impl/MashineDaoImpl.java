package com.spalah.cources.model.dao.impl;

import com.spalah.cources.model.entity.Line;
import com.spalah.cources.model.dao.AbstractDao;
import com.spalah.cources.model.dao.MashineDao;
import com.spalah.cources.model.entity.Mashine;
import com.spalah.cources.model.entity.MashineBets;
import com.spalah.cources.model.entity.PayTable;
import org.hibernate.Criteria;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Тарас on 04.06.2016.
 */
@Component
public class MashineDaoImpl extends AbstractDao<Long, Mashine> implements MashineDao {
    @Override
    public List<MashineBets> avaliableBets(Mashine mashine) {

        return null;
    }

    @Override
    public int linesCount(Mashine mashine) {
        return 0;
    }

    @Override
    public List<Line> getLines(Mashine mashine) {

        return null;
    }

    @Override
    public PayTable getPayTable(Mashine mashine) {
        return null;
    }


    public Mashine findById(long id) {
        return getByKey(id);
    }

    @Override
    public void saveMashine(Mashine mashine) {persist(mashine);}

    @Override
    public void deleteMashineById(long id) {

    }


    @Override
    public List<Mashine> findAllMashines() {
        Criteria criteria = createEntityCriteria();
        return (List<Mashine>) criteria.list();
    }
}
