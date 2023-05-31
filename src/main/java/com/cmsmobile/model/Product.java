package com.cmsmobile.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
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
    @Column
    private Integer price;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "category_id")
//    private Category category_id;

}
