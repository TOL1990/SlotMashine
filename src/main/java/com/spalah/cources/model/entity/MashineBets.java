package com.spalah.cources.model.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Тарас on 05.06.2016.
 */
@Entity
@Table(name = "bets")
public class MashineBets implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bet_id", unique = true, nullable = false)
    private long id;

    @Column(name = "bet")
    private BigDecimal bet;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "mashine_id")
    private Mashine mashine;

    public MashineBets() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getBet() {
        return bet;
    }

    public void setBet(BigDecimal bet) {
        this.bet = bet;
    }

    public Mashine getMashine() {
        return mashine;
    }

    public void setMashine(Mashine mashine) {
        this.mashine = mashine;
    }

    @Override
    public String toString() {
        return "MashineBets{" +
                "bet=" + bet +
                '}';
    }
}
