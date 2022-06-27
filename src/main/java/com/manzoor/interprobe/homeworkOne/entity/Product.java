package com.manzoor.interprobe.homeworkOne.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.*;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(generator = "Product")
    @SequenceGenerator(name = "Product", sequenceName = "PRODUCT_ID_SEQ")
    private Long id;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;


    @Column(name = "PRICE",nullable = false)
    private double price;

    @Column(name = "EXPIRY_DATE")
    private Date expiryDate;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "product")
    private List<ProductComment> productComments = new ArrayList<>();




}