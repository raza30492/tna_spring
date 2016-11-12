/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springdatajpa.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "TNA", schema = "tna3")
public class Tna {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TNA_ID",nullable = false)
    private Integer id;
    
    @Column(name = "PO_REF",nullable = false)
    private String poRef;
    
    @Column(name = "STYLE",nullable = false)
    private String style;
    
    @Column(name = "SEASON",nullable = false)
    private String season;
    
    @Column(name = "QUANTITY",nullable = false)
    private Integer quantity;
    
    @Column(name = "ORDER_DATE",nullable = false)
    private LocalDate orderDate;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "BUYER_ID")
    private Buyer buyer;
    
    @OneToMany(mappedBy = "tna")
    private Set<TnaDetails> tnaDetailsSet = new HashSet<>();

    public Tna() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoRef() {
        return poRef;
    }

    public void setPoRef(String poRef) {
        this.poRef = poRef;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Set<TnaDetails> getTnaDetailsSet() {
        return tnaDetailsSet;
    }
    
    
}
