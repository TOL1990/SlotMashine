package com.spalah.cources.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Тарас on 07.06.2016.
 */
@Entity
@Table(name = "line_points")
public class LinePoint {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "line_point_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "line_id")
    private Line line;


    @Column(name = "coll", nullable = false)
    private int coll;

    @Column(name = "row", nullable = false)
    private int row;

    public LinePoint() {
    }

    public LinePoint(Line line, int coll, int row) {
        this.line = line;
        this.coll = coll;
        this.row = row;
    }
    public LinePoint(long line_id, int coll, int row) {
        this.line.setId(line_id);
        this.coll = coll;
        this.row = row;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public int getColl() {
        return coll;
    }

    public void setColl(int coll) {
        this.coll = coll;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "[ " + coll + "; " + row+ "]";
    }
}
