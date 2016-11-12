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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "ACTIVITY",schema = "tna3")
public class Activity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACTIVITY_ID",nullable = false)
    private Integer id;
    
    @Column(name = "ACTIVITY_NAME",nullable = false,unique = true)
    private String name;
    
    @ManyToMany
    @JoinTable(name = "ACTIVITY_DESGN", schema = "tna3",
            joinColumns = @JoinColumn(name = "ACTIVITY_ID"),
            inverseJoinColumns = @JoinColumn(name = "DESGN_ID")
    )
    private Set<Designation> designations = new HashSet<>();

    public Activity() {
    }

    public Activity(String name) {
        this.name = name;
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

    public Set<Designation> getDesignations() {
        return designations;
    }
    
    
}
