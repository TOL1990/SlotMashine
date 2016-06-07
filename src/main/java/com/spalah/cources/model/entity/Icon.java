package com.spalah.cources.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Тарас on 07.06.2016.
 */
@Entity
@Table(name = "icons")
public class Icon {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "icon_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pay_table_id")
    private PayTable payTable;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "description")
    private String desription;

    @OneToMany(mappedBy = "icon", fetch = FetchType.EAGER)
    private List<PayIcon> payIcons;


    public Icon() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PayTable getPayTable() {
        return payTable;
    }

    public void setPayTable(PayTable payTable) {
        this.payTable = payTable;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public List<PayIcon> getPayIcons() {
        return payIcons;
    }

    public void setPayIcons(List<PayIcon> payIcons) {
        this.payIcons = payIcons;
    }

    @Override
    public String toString() {
        return "Icon{" +
                "id=" + id +
                ", payTable=" + payTable.getName() +
                ", desription='" + desription + '\'' +
                ", payIcons=" + payIcons.toString() +
                '}';
    }
}
