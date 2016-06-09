package com.spalah.cources.controller;

import com.spalah.cources.model.entity.Line;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Класс для ловли Ставок в пост запрос
 */
public class ResponseBet {
    private long userId;
    private long mashineId;
    private Map<Integer, Integer> bets = new HashMap<>();//<lineId, bet>

    public ResponseBet() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Map<Integer, Integer> getBets() {
        return bets;
    }

    public void setBets(Map<Integer, Integer> bets) {
        this.bets = bets;
    }

    public long getMashineId() {
        return mashineId;
    }

    public void setMashineId(long mashineId) {
        this.mashineId = mashineId;
    }
}
