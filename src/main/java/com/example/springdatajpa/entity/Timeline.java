/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springdatajpa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "TIMELINE", schema = "tna3")
public class Timeline implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIMELINE_ID",nullable = false)
    private Integer id;
    
    @Column(name = "TIMELINE",nullable = false)
    private Integer timeline;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "ACTIVITY_ID")
    private Activity activity;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "BUYER_ID")
    private Buyer buyer;

    public Timeline() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTimeline() {
        return timeline;
    }

    public void setTimeline(Integer timeline) {
        this.timeline = timeline;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
    
    
    
}
