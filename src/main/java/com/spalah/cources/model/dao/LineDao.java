package com.spalah.cources.model.dao;

import com.spalah.cources.model.entity.Line;

import java.util.List;

/**
 * Created by Тарас on 07.06.2016.
 */
public interface LineDao {
    public List<Line> getAllLinesByMashinesId(long id);

     Line findById(long id);

    public void saveLine(Line line);

    public void deleteLineById(long id);

    public int pointsCount(long lineId);

}
