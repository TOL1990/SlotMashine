package com.spalah.cources.model.dao.impl;

import com.spalah.cources.model.dao.AbstractDao;
import com.spalah.cources.model.dao.LineDao;
import com.spalah.cources.model.entity.Line;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Тарас on 07.06.2016.
 */
@Component
public class LineDaoImpl extends AbstractDao<Long, Line> implements LineDao {


    public Line findById(long id) {
        return getByKey(id);
    }

    public void saveLine(Line line) {
        persist(line);
    }

    public void deleteLineById(long id) {
        Query query = getSession().createQuery("delete from Line where id = :Id");
        query.setLong("Id", id);
        query.executeUpdate();
    }

    public int pointsCount(long lineId)
    {
        Line line = findById(lineId);

        return line.getPoints().size();
    }

    public List<Line> getAllLinesByMashinesId(long id)
    {
        List<Line> lines = new ArrayList<>();
        Session s = getSession();
        s.beginTransaction();
        Query query = s.createQuery("from Line where mashine.getId():=id").setLong("id", id);
        lines = (List<Line>) query.list();
        s.close();
        return lines;
    }
}
