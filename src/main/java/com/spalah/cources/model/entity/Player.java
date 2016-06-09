package com.spalah.cources.model.entity;

import com.spalah.cources.model.Stata;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

import static javax.swing.text.StyleConstants.Size;

@Entity
@Table(name = "players", uniqueConstraints = {
        @UniqueConstraint(columnNames = "player_id"),
        @UniqueConstraint(columnNames = "nick") })
public class Player implements Serializable {
    @Id
    @Column(name = "player_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 3, max = 50)
    @NotNull
    @NotEmpty
    @Column(name = "nick", unique = true, nullable = false)
    private String nickName;

    @Size(min = 3, max = 50)
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Digits(integer=8, fraction=2)
    @Column(name = "balance", nullable = false)
    private BigDecimal ballance;
//    Stata stata;

    public Player() {
    }

    public Player(String nickName, String password) {
        this.nickName = nickName;
        this.password = password;
        this.ballance = new BigDecimal(10000);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBallance() {
        return ballance;
    }

    public void setBallance(BigDecimal ballance) {
        this.ballance = ballance;
    }

//    public Stata getStata() {
//        return stata;
//    }
//
//    public void setStata(Stata stata) {
//        this.stata = stata;
//    }


    @Override
    public String toString() {
        return "Player{" +
                "# " + id +
                " '" + nickName + '\'' +
                ", password ='" + password + '\'' +
                ", " + ballance + "$ " +
                '}';
    }
}
