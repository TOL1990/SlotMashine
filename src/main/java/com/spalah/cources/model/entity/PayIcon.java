package com.spalah.cources.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by Тарас on 07.06.2016.
 */
@Entity
@Table(name = "pay_icons")
public class PayIcon {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pay_icon_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "icon_id")
    private Icon icon;

    @Column(name = "images_count")
    @NotNull
    private int imageCount;

    @Column(name = "award")
    @NotNull
    private BigDecimal awards;

    public PayIcon() {
    }

    public PayIcon(Icon icon, int imageCount, BigDecimal awards) {
        this.icon = icon;
        this.imageCount = imageCount;
        this.awards = awards;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public int getImageCount() {
        return imageCount;
    }

    public void setImageCount(int imageCount) {
        this.imageCount = imageCount;
    }

    public BigDecimal getAwards() {
        return awards;
    }

    public void setAwards(BigDecimal awards) {
        this.awards = awards;
    }

    @Override
    public String toString() {
        return " za " + imageCount +" - " + awards +"$ ";
    }
}
