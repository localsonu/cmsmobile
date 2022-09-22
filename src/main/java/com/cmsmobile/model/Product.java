package com.cmsmobile.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;
    @Column
    private String productName;
    @Column
    private Integer inStock;
    @Column
    private Date createdDate;
    @Column
    private String createdBy;
    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categories;
    @Column
    private Integer price;

}
