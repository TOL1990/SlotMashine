package com.spalah.cources.model.dao.impl;

import com.spalah.cources.model.Line;
import com.spalah.cources.model.dao.AbstractDao;
import com.spalah.cources.model.dao.MashineDao;
import com.spalah.cources.model.entity.Mashine;
import com.spalah.cources.model.entity.PayTable;
import com.spalah.cources.model.entity.Player;
import org.hibernate.Criteria;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Тарас on 04.06.2016.
 */
@Component
public class MashineDaoImpl extends AbstractDao<Integer, Mashine> implements MashineDao {
    @Override
    public int[] avaliableBets(Mashine mashine) {
        return new int[0];
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

    @Override
    public Mashine findById(long id) {
        return null;
    }

    @Override
    public void saveMashine(Mashine mashine) {

    }

    @Override
    public void deleteMashineById(long id) {

    }


    @Override
    public List<Mashine> findAllMashines() {
        Criteria criteria = createEntityCriteria();
        return (List<Mashine>) criteria.list();
    }
}
