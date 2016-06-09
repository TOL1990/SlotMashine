package com.spalah.cources.model.entity;


import com.spalah.cources.model.Board;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "mashines")
public class Mashine implements Serializable {

    @Id
    @Column(name = "mashine_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Transient
    private Board drums; // наше игровое поле. Барабаны

//    List<MashineBets> playerBets; // Описывает ставки сделанные игроком


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mashine", cascade = CascadeType.ALL)
    private List<Line> lines; //перечень линий доступных для игры

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mashine", cascade = CascadeType.ALL)
    private List<MashineBets> bets; //доступные ставки

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private PayTable payTable;

    public Mashine() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public Board getDrums() {
        return drums;
    }

    public void setDrums(Board drums) {
        this.drums = drums;
    }

    public List<MashineBets> getBets() {
        return bets;
    }

    public void setBets(List<MashineBets> bets) {
        this.bets = bets;
    }

    public PayTable getPayTable() {
        return payTable;
    }

    public void setPayTable(PayTable payTable) {
        this.payTable = payTable;
    }

    @Override
    public String toString() {
        return "Mashine{" +
                "" + id +
                "  - " + name +
                '}';
    }
}
