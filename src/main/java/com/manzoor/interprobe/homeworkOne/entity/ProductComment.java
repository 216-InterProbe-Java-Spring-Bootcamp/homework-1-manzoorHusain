package com.manzoor.interprobe.homeworkOne.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "PRODUCT_COMMENT")
@Getter
@Setter
public class ProductComment {

    @Id
    @GeneratedValue(generator = "Product_Comment")
    @SequenceGenerator(name = "Product_Comment", sequenceName = "PRODUCT_COMMENT_ID_SEQ")
    private Long id;


    @Column(name = "COMMENT",length = 500,nullable = false)
    private String comment;
    @Column(name = "COMMENT_DATE",nullable = false)
    private Date commentDate;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID",nullable = false,
            foreignKey = @ForeignKey(name = "FK_PRODUCT_COMMENT_PRODUCT",value = ConstraintMode.CONSTRAINT))
    private  Product product;



    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID",nullable = false,
    foreignKey = @ForeignKey(name = "FK_PRODUCT_COMMENT_CUSTOMER",value = ConstraintMode.CONSTRAINT))
    private Customer customer;




}