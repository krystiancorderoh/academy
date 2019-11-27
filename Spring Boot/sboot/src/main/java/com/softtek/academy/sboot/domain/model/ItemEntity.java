package com.softtek.academy.sboot.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonView;
import com.softtek.academy.sboot.util.serializer.DataViews;

import lombok.Data;

@Data
@Entity
@Table(name = "ITEM")
public class ItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@JsonView(DataViews.Basic.class)
    @Column(name = "description")
    private String description;

    @Column(name = "features")
    private String features;

    //@JsonView(DataViews.Full.class)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "uom_id", referencedColumnName = "id")
    private UomEntity uom;

    @Column(name = "unit_price", columnDefinition = "NUMERIC(10,2)")
    private Double unitPrice;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "stock")
    private Long stock;

    @Type(type = "yes_no")
    @Column(name = "active", columnDefinition = "VARCHAR(1)")
    private boolean active;

    @JsonView(DataViews.Full.class)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CATEGORY_ITEM",
    joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private List<CategoryEntity> categories;


    public ItemEntity() {
    }

    public ItemEntity(Long id) {
        this.id = id;
    }

}
