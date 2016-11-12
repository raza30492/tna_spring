/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springdatajpa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "BUYER", schema = "tna3")
public class Buyer implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BUYER_ID",nullable = false)
    private Integer id;
    
    @Column(name = "BUYER_NAME",nullable = false)
    private String name;
    
    @OneToMany(mappedBy = "buyer")
    private Set<Tna> tnaSet = new HashSet<>();
    
    @OneToMany(mappedBy = "buyer")
    private Set<Timeline> timelineSet = new HashSet<>();
    
    @ManyToMany(mappedBy = "buyers")
    private Set<Employee> users = new HashSet<>();

    public Buyer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Tna> getTnaSet() {
        return tnaSet;
    }

    public Set<Timeline> getTimelineSet() {
        return timelineSet;
    }

    public Set<Employee> getUsers() {
        return users;
    }
    
}
