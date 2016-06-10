package com.spalah.cources.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Класс описывает линию как перечень индексов двумерного массива.
 */
@Entity
@Table(name = "mashine_lines")
public class Line implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "line_id", unique = true, nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "mashine_id")
    private Mashine mashine;

    @OneToMany(mappedBy = "line", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private List<LinePoint> points;

    public Line() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Mashine getMashine() {
        return mashine;
    }

    public void setMashine(Mashine mashine) {
        this.mashine = mashine;
    }

    public List<LinePoint> getPoints() {
        return points;
    }

    public void setPoints(List<LinePoint> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Line # " + id +
                ": {" + points.toString() +
                '}';
    }
}
