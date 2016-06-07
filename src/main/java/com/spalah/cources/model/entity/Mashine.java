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
    long id;

    @Column(name = "name")
    String name;


//    List<Line> lines; //перечень линий доступных для игры
    @Transient
Board drums; // наше игровое поле. Барабаны


//    List<MashineBets> playerBets; // Описывает ставки сделанные игроком

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mashine", cascade = CascadeType.ALL)
    List<MashineBets> bets;
//    int[] mashineBet;//доступные ставки
//    PayTable payTable;

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

    @Override
    public String toString() {
        return "Mashine{" +
                "" + id +
                "  - " + name  +
                '}';
    }
}
