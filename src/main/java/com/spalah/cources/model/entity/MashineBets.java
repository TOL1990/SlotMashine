package com.spalah.cources.model.entity;


import javax.persistence.*;

/**
 * Created by Тарас on 05.06.2016.
 */
@Entity
@Table(name = "bets")
public class MashineBets {


    @Id
    @Column(name = "mashine_id")
    private long id;

    @Column(name = "bet")
    private int bet;

    public MashineBets() {
    }

    public MashineBets(long id, int bet) {
        this.id = id;
        this.bet = bet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }
}
