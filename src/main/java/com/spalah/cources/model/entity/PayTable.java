package com.spalah.cources.model.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

/**
 * Created by Тарас on 04.06.2016.
 */
@Entity
@Table(name = "pay_tables")
public class PayTable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pay_table_id", unique = true)
    private long id;

    @Column(name = "name")
    private String name;

    @NotNull
    @OneToOne(mappedBy = "payTable", fetch = FetchType.LAZY)
    private Mashine mashine;

    @OneToMany(mappedBy = "payTable", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Icon> icons;

    public PayTable() {
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

    public Mashine getMashine() {
        return mashine;
    }

    public void setMashine(Mashine mashine) {
        this.mashine = mashine;
    }

    public List<Icon> getIcons() {
        return icons;
    }

    public void setIcons(List<Icon> icons) {
        this.icons = icons;
    }

    @Override
    public String toString() {
        return "PayTable #"+ id + " - " + name + ", mashine - " + mashine.getName().toString() + '\''+
               icons.toString();

    }
}
