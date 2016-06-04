package com.spalah.cources.model.entity;


import javax.persistence.*;

@Entity
@Table(name = "mashines")
public class Mashine {

    @Id
    @Column(name = "mashine_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "name")
    String name;


//    List<Line> lines; //перечень линий доступных для игры
//    Board drums; // наше игровое поле. Барабаны
//    List<Bet> playerBets; // Описывает ставки сделанные игроком
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

    @Override
    public String toString() {
        return "Mashine{" +
                "" + id +
                "  - " + name  +
                '}';
    }
}
