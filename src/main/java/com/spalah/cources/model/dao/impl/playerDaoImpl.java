package com.spalah.cources.model.dao.impl;

import com.spalah.cources.model.dao.IPlayerDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Leonid on 01.06.2016.
 */
@Component
@Qualifier("test1")
public class playerDaoImpl implements IPlayerDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void test() {
        System.out.println("TEST FROM DAO");
        System.out.println(sessionFactory != null);
    }
}
