package com.spalah.cources.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {
    @Id
    @Column(name = "player_id")
    Long userId;

//    String nickName;
//    String password;
//    BigDecimal ballance;
//    Stata stata;

    public Player() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
